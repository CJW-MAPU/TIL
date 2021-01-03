public class SamsungTV implements TV {
    private Speaker speaker;
    private int price;

    public SamsungTV() {
        System.out.println("===> SamsungTV(1) Create");
    }

    public SamsungTV(Speaker speaker) {
        System.out.println("===> SamsungTV(2) Create");
        this.speaker = speaker;
    }

    public SamsungTV(Speaker speaker, int price) {
        System.out.println("===> SamsungTV(3) Create");
        this.speaker = speaker;
        this.price = price;
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("===> setSpeaker() Calling");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("===> setPrice() Calling");
        this.price = price;
    }

    public void initMethod() {
        System.out.println("init...");
    }
    public void destroyMethod() {
        System.out.println("destroy...");
    }

    @Override
    public void powerOn() {
        System.out.println("SamsungTV PowerON, Price: " + price);
    }
    @Override
    public void powerOff() {
        System.out.println("SamsungTV PowerOFF");
    }
    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }
    @Override
    public void volumeDown() {
        speaker.volumeDown();
    }
}
