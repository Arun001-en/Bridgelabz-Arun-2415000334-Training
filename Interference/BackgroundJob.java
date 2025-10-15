public class BackgroundJob {

    public static void main(String[] args) {
        // Task 1: Print numbers
        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1 - Number: " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        };

        // Task 2: Print letters
        Runnable task2 = () -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Task 2 - Letter: " + c);
                try { Thread.sleep(700); } catch (InterruptedException e) {}
            }
        };

        // Run tasks asynchronously using Threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread continues execution...");
    }
}
