public class BeanFactory {
    public Object getBean(String BeanName) {
        if(BeanName.equals("samsung")) {
            return new SamsungTV();
        } else if(BeanName.equals("lg")) {
            return new LgTV();
        }

        return null;
    }
}
