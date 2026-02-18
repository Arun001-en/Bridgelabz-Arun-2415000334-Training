class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = this;
    }
}

class CircularTaskScheduler {
    private Task head;

    public CircularTaskScheduler() {
        head = null;
    }

    public void addTask(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            return;
        }
        Task current = head;
        do {
            current = current.next;
        } while (current.next != head);
        current.next = newTask;
        newTask.next = head;
    }

    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null || position <= 1) {
            newTask.next = head;
            if (head != null) {
                Task last = head;
                while (last.next != head) last = last.next;
                last.next = newTask;
            }
            head = newTask;
            return;
        }
        Task current = head;
        int count;
    }
}
