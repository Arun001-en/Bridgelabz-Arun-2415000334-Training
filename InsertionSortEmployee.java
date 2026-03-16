public class BufferVsBuilder {
    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "a";

        long start = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) sbuilder.append(text);
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1000000 + " ms");

        start = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) sbuffer.append(text);
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1000000 + " ms");
    }
}
