package com.aop.exam.util;

import com.aop.exam.exception.BeanNotFoundException;
import com.aop.exam.exception.NodeIsElementNodeException;
import com.aop.exam.exception.OverlapBeanIDException;
import com.aop.exam.exception.OverlapPointcutIDException;
import net.sf.cglib.proxy.Enhancer;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySpringContainer {
    File file;
    ParseDOM parseDOM;

    List<String> refList = new ArrayList<>();

    /* NOTE : <BeanID, Path> */
    Map<String, String> beans = new HashMap<>();

    /* NOTE : <BeanID, ProxyClass> */
    Map<String, Object> beanList = new HashMap<>();

    /* NOTE : <BeanID, Aspect<Method, pointcut-ref>> */
    Map<String, Aspect> aspect = new HashMap<>();

    /* NOTE : <pointcutID, expression> */
    Map<String, String> pointcut = new HashMap<>();

    public MySpringContainer(String Path) throws Exception {
        file = new File(Path);
        parseDOM = new ParseDOM(file);
        NodeList beans = parseDOM.getBeanList();
        NodeList configTag = parseDOM.getConfigList();

        createInstance(beans);
        createAspectConfig(configTag);
    }

    public Object getBean(String beanID) {
        return beanList.get(beanID);
    }

    private void createAspectConfig(NodeList nodeList) throws Exception {
        Node node = nodeList.item(0);

        Element element = (Element) node;

        NodeList pointcutList = element.getElementsByTagName("pointcut");
        NodeList aspectList = element.getElementsByTagName("aspect");

        for (int i = 0; i < pointcutList.getLength(); i++) {
            Node pointcutNode = pointcutList.item(i);

            Element pointcutElement = (Element) pointcutNode;
            if (pointcut.get(pointcutElement.getAttribute("id")) == null) {
                pointcut.put(pointcutElement.getAttribute("id"), pointcutElement.getAttribute("expression"));
            } else {
                throw new OverlapPointcutIDException();
            }
        }

        for (int i = 0; i < aspectList.getLength(); i++) {
            Aspect temp = new Aspect();

            Node aspectNode = aspectList.item(i);

            Element aspectElement = (Element) aspectNode;

            String aspectRef = aspectElement.getAttribute("ref");

            NodeList beforeList = aspectElement.getElementsByTagName("before");
            NodeList afterList = aspectElement.getElementsByTagName("after");

            for (int j = 0; j < beforeList.getLength(); j++) {
                Node beforeNode = beforeList.item(j);

                Element beforeElement = (Element) beforeNode;

                Class<?> clazz = Class.forName(beans.get(aspectRef));

                temp.addBefore(clazz, beforeElement.getAttribute("method"), beforeElement.getAttribute("pointcut-ref"));
            }

            for (int j = 0; j < afterList.getLength(); j++) {
                Node afterNode = afterList.item(j);

                Element afterElement = (Element) afterNode;

                Class<?> clazz = Class.forName(beans.get(aspectRef));

                temp.addAfter(clazz, afterElement.getAttribute("method"), afterElement.getAttribute("pointcut-ref"));
            }
            refList.add(aspectRef);
            aspect.put(aspectRef, temp);
        }
    }

    private void createInstance(NodeList nodeList) throws Exception {
        if (nodeList.getLength() == 0) {
            throw new BeanNotFoundException();
        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if(!isElementNode(node)) {
                throw new NodeIsElementNodeException();
            }

            Element element = (Element) node;

            if (beanList.get(element.getAttribute("id")) == null) {
                Enhancer enhancer = new Enhancer();

                String path = element.getAttribute("class");
                enhancer.setSuperclass(Class.forName(path));
                enhancer.setCallback(new Interceptor(refList, beans, aspect, pointcut));

                Object obj = enhancer.create();

                beans.put(element.getAttribute("id"), path);
                beanList.put(element.getAttribute("id"), obj);
            } else {
                throw new OverlapBeanIDException();
            }
        }
    }

    private static boolean isElementNode(Node node) {
        return node.getNodeType() == Node.ELEMENT_NODE;
    }
}
