class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class TestBox {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(10);
        System.out.println(b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Hello");
        System.out.println(b2.get());

        Box<Double> b3 = new Box<>();
        b3.set(20.5);
        System.out.println(b3.get());
    }
}
