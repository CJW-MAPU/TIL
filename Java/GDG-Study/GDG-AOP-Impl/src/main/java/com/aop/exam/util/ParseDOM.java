package com.aop.exam.util;


import com.aop.exam.exception.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ParseDOM {
    Document doc;

    ParseDOM(File file) throws RootElementNotBeansException, OverlapConfigTagException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            System.out.println("ParserConfigurationException 발생!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("IOException 발생!!");
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            System.out.println("SAXException 발생!!");
        }

        if (!isBeans(doc)) {
            throw new RootElementNotBeansException();
        }

        if (!CountConfigTag(doc)) {
            throw new OverlapConfigTagException();
        }
    }

    public NodeList getBeanList() {
        return doc.getElementsByTagName("bean");
    }

    public NodeList getConfigList() {
        return doc.getElementsByTagName("config");
    }

    private static boolean isBeans(Document document) {
        return document.getDocumentElement().getNodeName().equals("beans");
    }

    private static boolean CountConfigTag(Document document) {
        return document.getElementsByTagName("config").getLength() == 1 || document.getElementsByTagName("config").getLength() == 0;
    }
}
