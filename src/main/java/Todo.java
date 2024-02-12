public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toSaveString() {
        return String.format("Todo | %s | %s", super.toSaveString(), description);
    }


    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
