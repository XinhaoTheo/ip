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

/**
 * Parser class is responsible to help to convert all the commands received
 * to the different commands which can be executed.
 * Since we receive the plain words and sentences from the user
 * we need the conversion to let the ChatBot understand the command.
 */
public class Parser {

    /**
     * This method will take all the commands received converted to
     * @param fullCommand takes from our command which is a string
     * @return the corresponding Command which will be executed
     * @throws DukeUnknownCommandException the invalid command
     */
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

    /**
     * LocalDate method is used to convert the date in string to the object
     * in Java data format
     * @param date in String
     * @return LocalDate in java date
     * @throws DateTimeParseException time format for input string is not correct
     */

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

    /**
     * dateToString method is used to convert Java date to the string in "MMM dd yyyy" format
     * @param date which is Java date
     * @return string of date in "MMM dd yyyy" format
     */
    public static String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return date.format(formatter);
    }
}
