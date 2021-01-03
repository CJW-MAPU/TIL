public class SonySpeaker implements Speaker{

    public SonySpeaker() {
        System.out.println("SonySpeaker Create");
    }
    @Override
    public void volumeUp() {
        System.out.println("SonySpeaker VolumeUP");
    }
    @Override
    public void volumeDown() {
        System.out.println("SonySpeaker VolumeDOWN");
    }
}
