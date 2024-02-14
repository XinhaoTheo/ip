import java.time.LocalDate;

public class Event extends Task{

    protected LocalDate from;
    protected LocalDate to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = Parser.stringToDate(from);
        this.to = Parser.stringToDate(to);
    }

    @Override
    public String toSaveString() {
        // String fromStr = Parser.dateToString(from);
        // String toStr = Parser.dateToString(to);
        return String.format("Event | %s | %s | from %s to %s", super.toSaveString(), description, from, to);
    }

    @Override
    public String toString() {
        String fromStr = Parser.dateToString(from);
        String toStr = Parser.dateToString(to);
        return "[E]" + super.toString() + " (from: " + fromStr + " to: " + toStr + ")";
    }
}
