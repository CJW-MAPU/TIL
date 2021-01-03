import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBeanClient {
    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("applicationContext.xml");

        CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");

//        List<String> addressList = bean.getAddressList();
//        Set<String> addressList = bean.getAddressList();
        Properties addressList = bean.getAddressList();

//        for(String address : addressList) {
//            System.out.println(address.toString());
//        }

        factory.close();
    }
}