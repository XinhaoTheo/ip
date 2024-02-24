package mainDuke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Commands.*;
import task.Todo;
import task.Deadline;
import task.Event;
import Exception.DukeException;
import Exception.DukeUnknownCommandException;
import Exception.DukeInvalidTimeException;

public class Parser {

    public static Command parse(String fullCommand) throws DukeUnknownCommandException {
        String[] fullCommandArray = fullCommand.split(" ",2);
        String firstCommand = fullCommandArray[0];

        switch (firstCommand) {
            case "todo":
                return new AddCommand(new Todo(fullCommandArray[1]));
                //break;

            case "deadline":
                String[] deadlineArr = fullCommandArray[1].split(" /by ");
                String deadlineDes = deadlineArr[0];
                String deadlineTime = deadlineArr[1];

                if (deadlineTime == null) {
                    throw new DukeUnknownCommandException();
                }
                return new AddCommand(new Deadline(deadlineDes, deadlineTime));

            case "event":
                String[] eventline = fullCommandArray[1].split(" /from ");
                String eventDes = eventline[0];
                String[] fromto = eventline[1].split(" /to ");
                String from = fromto[0];
                String to = fromto[1];
                return new AddCommand(new Event(eventDes, from, to ));
                //break;

            case "delete":
                int numToDelete = Integer.parseInt(fullCommandArray[1]);
                if (numToDelete <=0 || numToDelete > TaskList.getTaskList().size()) {
                    throw new DukeUnknownCommandException();
                }
                return new DeleteCommand(numToDelete);
                //break;

            case "List":
                return new ListCommand();
                //break;

            case "mark":
                int numToMark = Integer.parseInt(fullCommandArray[1]);

                if (numToMark <=0 || numToMark > TaskList.getTaskList().size()) {
                    throw new DukeUnknownCommandException();
                }

                return new MarkCommand(numToMark);
                //break;

            case "unmark":
                int numToUnmark = Integer.parseInt(fullCommandArray[1]);

                if (numToUnmark <=0 || numToUnmark > TaskList.getTaskList().size()) {
                    throw new DukeUnknownCommandException();
                }

                return new UnmarkCommand(numToUnmark);


            case "bye":
                return new ExitCommand();

            default:
                throw new DukeUnknownCommandException();
        }

    }

    public static LocalDate stringToDate(String date) throws DateTimeParseException {
         try {
        return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            System.out.println("The time format is not correct\n" +
                    "Remember to add 0 before any number less than 10\n" +
                    "eg. 02 stands for Feb");
        }
        return null;

    }

    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return date.format(formatter);
    }
}
