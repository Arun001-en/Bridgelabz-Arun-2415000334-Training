class Process {
    int id;
    int burstTime;
    int remainingTime;
    Process next;
    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = this;
    }
}
class RoundRobinScheduler {
    private Process head;
    private int timeQuantum;

    public RoundRobinScheduler(int quantum) {
        head = null;
        timeQuantum = quantum;
    }
    public void addProcess(int id, int burstTime) {
        Process newProcess = new Process(id, burstTime);
        if (head == null) {
            head = newProcess;
            return;
        }
        Process current = head;
        do {
            current = current.next;
        } while (current.next != head);
        current.next = newProcess;
        newProcess.next = head;
    }
    public void addProcessAtEnd(int id, int burstTime) {
        addProcess(id, burstTime);
    }
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int totalTime = 0;
        int completedProcesses = 0;

        System.out.printf("Time Quantum: %d\n", timeQuantum);
        System.out.println("Scheduling Simulation:");

        while (completedProcesses < getProcessCount()) {
            Process current = head;
            boolean completed = true;
            do {
                if (current.remainingTime > 0) {
                    completed = false;
                    int execTime = Math.min(timeQuantum, current.remainingTime);
                    current.remainingTime -= execTime;
                    totalTime += execTime;

                    System.out.printf("Time %d-%d: Process %d (Remaining: %d)\n", 
                        totalTime - execTime, totalTime, current.id, current.remainingTime);

                    if (current.remainingTime > 0) {
                        current = current.next;
                    } else {
                        int turnaround = totalTime;
                        int waiting = turnaround - current.burstTime;
                        totalWaitingTime += waiting;
                        totalTurnaroundTime += turnaround;
                        completedProcesses++;
                        
                        System.out.printf("Process %d completed at time %d (Waiting: %d, Turnaround: %d)\n",
                            current.id, totalTime, waiting, turnaround);
                        
                        current = current.next;
                    }
                } else {
                    current = current.next;
                }
            } while (current != head && completedProcesses < getProcessCount());
        }

        displayStatistics(totalWaitingTime, totalTurnaroundTime, totalTime);
    }

    private int getProcessCount() {
        if (head == null) return 0;
        int count = 1;
        Process current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void displayStatistics(int totalWaiting, int totalTurnaround, int totalTime) {
        int processCount = getProcessCount();
        double avgWaitingTime = (double) totalWaiting / processCount;
        double avgTurnaroundTime = (double) totalTurnaround / processCount;
        
        System.out.println("\n=== SCHEDULING STATISTICS ===");
        System.out.printf("Total Processes: %d\n", processCount);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Total Execution Time: %d\n", totalTime);
    }

    public void displayProcessList() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process current = head;
        System.out.println("Process Queue (Circular):");
        do {
            System.out.printf("Process %d (Burst: %d, Remaining: %d)\n", 
                current.id, current.burstTime, current.remainingTime);
            current = current.next;
        } while (current != head);
    }
}

class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(2);
        
        scheduler.addProcess(1, 5);
        scheduler.addProcess(2, 3);
        scheduler.addProcess(3, 8);
        scheduler.addProcess(4, 6);
        
        scheduler.displayProcessList();
        scheduler.simulateScheduling();
    }
}
