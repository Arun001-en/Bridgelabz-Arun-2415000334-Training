class TextState {
    String content;
    TextState next;
    TextState prev;

    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int maxHistory = 10;

    public TextEditor() {
        head = null;
        current = null;
    }

    public void addNewTextState(String newContent) {
        TextState newState = new TextState(newContent);
        
        if (current == null) {
            head = newState;
            current = head;
            return;
        }

        current.next = newState;
        newState.prev = current;
        current = newState;

        if (getHistoryCount() > maxHistory) {
            removeOldestState();
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text State: " + current.content);
        } else {
            System.out.println("No text state available.");
        }
    }

    public void displayHistory() {
        System.out.println("Text History (Recent to Old):");
        TextState temp = current;
        int index = 1;
        while (temp != null && index <= maxHistory) {
            System.out.println(index + ". " + temp.content);
            temp = temp.prev;
            index++;
        }
    }

    private int getHistoryCount() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void removeOldestState() {
        TextState oldest = head;
        if (oldest == null) return;
        
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public TextState getCurrent() {
        return current;
    }
}

class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addNewTextState("Hello");
        editor.addNewTextState("Hello World");
        editor.addNewTextState("Hello World!");
        editor.addNewTextState("Final text state");
        
        System.out.println("=== Initial History ===");
        editor.displayHistory();
        
        System.out.println("\n=== Current State ===");
        editor.displayCurrentState();
        
        editor.undo();
        System.out.println("\n=== After Undo ===");
        editor.displayCurrentState();
        
        editor.undo();
        System.out.println("\n=== After Second Undo ===");
        editor.displayCurrentState();
        
        editor.redo();
        System.out.println("\n=== After Redo ===");
        editor.displayCurrentState();
        
        System.out.println("\n=== Full History ===");
        editor.displayHistory();
        
        editor.addNewTextState("New state after undo/redo");
        System.out.println("\n=== After New State ===");
        editor.displayCurrentState();
        editor.displayHistory();
    }
}
