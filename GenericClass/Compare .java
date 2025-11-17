class Compare {
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }
    public static void main(String[] args) {
        System.out.println(isEqual(10, 10));
        System.out.println(isEqual("abc", "xyz"));
    }
}
