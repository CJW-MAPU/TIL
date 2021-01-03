import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        AbstractApplicationContext factory =
                new GenericXmlApplicationContext("applicationContext.xml");


        TV tv = (TV)factory.getBean("tv");
        tv.powerOn();
        tv.powerOff();
        tv.volumeDown();
        tv.volumeUp();

        factory.close();
    }
}
