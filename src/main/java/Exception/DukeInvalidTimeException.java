package Exception;

public class DukeInvalidTimeException extends DukeException{
    public DukeInvalidTimeException() {
        super ("The time format is not correct\n" +
                "Remember to add 0 before any number less than 10\n" +
                "eg. 02 stands for Feb");
    }
}
