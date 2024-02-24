package task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() { return description;}

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void setStatusIcon(boolean bool) {
        this.isDone = bool;
    }

    public String toSaveString() {
        return (isDone ? "1" : "0");
    }


    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    //...
}
