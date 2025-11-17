import java.util.*;

public class CircularBuffer {
    static class CircularQueue {
        int[] arr;
        int size, front, rear, count;

        CircularQueue(int size) {
            this.size = size;
            arr = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }

        void enqueue(int val) {
            rear = (rear + 1) % size;
            arr[rear] = val;
            if (count < size)
                count++;
            else
                front = (front + 1) % size; // overwrite oldest
        }

        void display() {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[(front + i) % size] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue buffer = new CircularQueue(3);
        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.display();

        buffer.enqueue(4); // overwrites oldest
        buffer.display();
    }
}

