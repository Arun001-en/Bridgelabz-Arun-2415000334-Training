class MaxValue {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) max = y;
        if (z.compareTo(max) > 0) max = z;
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maximum(10, 20, 5));
        System.out.println(maximum("Apple", "Mango", "Banana"));
    }
}
