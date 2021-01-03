public class AppleSpeaker implements Speaker {
    public AppleSpeaker() {
        System.out.println("AppleSpeaker Create");
    }

    @Override
    public void volumeUp() {
        System.out.println("AppleSpeaker VolumeUP");
    }

    @Override
    public void volumeDown() {
        System.out.println("AppleSpeaker VolumeDOWN");
    }
}
