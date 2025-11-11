interface LightAction {
    void trigger();
}

public class SmartHome {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Lights ON due to motion detected!");
        LightAction timeTrigger = () -> System.out.println("Lights DIMMED at night time!");
        LightAction voiceTrigger = () -> System.out.println("Lights OFF via voice command!");

        motionTrigger.trigger();
        timeTrigger.trigger();
        voiceTrigger.trigger();
    }
}
