import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
    @Autowired
    private Speaker speaker;

    @Override
    public void powerOn() {
        System.out.println("LgTV PowerON");
    }

    @Override
    public void powerOff() {
        System.out.println("LgTV PowerOFF");
    }

    @Override
    public void volumeDown() {
        speaker.volumeDown();
    }

    @Override
    public void volumeUp() {
        speaker.volumeUp();
    }

}
