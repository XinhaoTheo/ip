import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    protected LocalDate by;

    public Deadline(String description, String by) {
        super(description);
        this.by = Parser.stringToDate(by);
    }


    @Override
    public String toSaveString() {
        return String.format("Deadline | %s | %s | %s", super.toSaveString(), description, by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Parser.dateToString(by) + ")";
    }
}
