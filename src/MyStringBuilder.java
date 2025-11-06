import java.util.Stack;

public class MyStringBuilder {

    private StringBuilder builder;
    private Stack<Snapshot> history;

    public MyStringBuilder() {
        this.builder = new StringBuilder();
        this.history = new Stack<>();
    }

    private Snapshot save() {
        return new Snapshot(builder.toString());
    }

    private void restore(Snapshot snapshot) {
        builder = new StringBuilder(snapshot.getState());
    }

    public MyStringBuilder append(String str) {
        history.push(save());
        builder.append(str);
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        history.push(save());
        builder.delete(start, end);
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            Snapshot snapshot = history.pop();
            restore(snapshot);
        } else {
            System.out.println("Нет сохранённых состояний для отката.");
        }
    }

    public String toString() {
        return builder.toString();
    }

    public int length() {
        return builder.length();
    }
}
