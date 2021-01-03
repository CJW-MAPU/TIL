interface PhoneInterface {
    final int TIMEOUT = 10000;

    void sendCall();
    void receiveCall();

    default void printLogo() {
        System.out.println("** Phone **");
    }
}

class Calc {
    public int calculate(int x, int y) {
        return x + y;
    }
}

class SamsungPhone extends Calc implements PhoneInterface {

    @Override
    public void sendCall() {
        System.out.println("Drrrrr");
    }

    @Override
    public void receiveCall() {
        System.out.println("Call is Comming");
    }

    public void flash() {
        System.out.println("Light");
    }

    public void schedule() {
        System.out.println("Schedule");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();

        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
        phone.schedule();
        System.out.println("3 + 5 = " + phone.calculate(3, 5));
    }
}
