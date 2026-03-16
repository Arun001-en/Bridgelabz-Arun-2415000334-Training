public class StringBufferConcat {
    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "powerful"};
        
        StringBuffer sb = new StringBuffer();
        
        for (String w : words) {
            sb.append(w);
        }
        
        System.out.println("Concatenated: " + sb.toString());
    }
}
