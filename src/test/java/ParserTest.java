import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import mainDuke.Parser;
import task.Event;
import Exception.DukeUnknownCommandException;
import Commands.AddCommand;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ParserTest {

    @Test
    public void commandTest() {
        String from = "2024-02-24";
        String to = "2024-02-25";
        try {
            assertEquals("Command: [E][ ] play majohn (from: Feb 24 2024 to: Feb 25 2024)",
                    Parser.parse("event play majohn /from 2024-02-24 /to 2024-02-25").toString());
        } catch (DukeUnknownCommandException e) {
            assertEquals("Sorry boss your command is invalid :-(", e.getMessage());

        }
    }

    @Test
    public void command_ExceptionThrown() {
        String from = "2024-02-24";
        String to = "2024-02-25";
        try {
            assertEquals(new AddCommand(new Event("play majohn", from, to)),
                    Parser.parse("Event play majohn /from 2024-02-24 /to 2024-02-25"));
            fail();
        } catch (DukeUnknownCommandException e) {
            assertEquals("Sorry boss your command is invalid :-(", e.getMessage());

        }
    }

    @Test
    public void command_dateTime_ExceptionThrown() {
        String from = "2024-2-24";
        String to = "2024-2-25";
        try {
            assertEquals(LocalDate.parse(from), Parser.stringToDate(from));
            fail();
        }  catch (DateTimeParseException e) {
            assertEquals("Text '2024-2-24' could not be parsed at index 5", e.getMessage());
        }
    }
}
