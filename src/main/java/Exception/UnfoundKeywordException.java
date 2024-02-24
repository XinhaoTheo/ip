package Exception;

import mainDuke.Duke;

public class UnfoundKeywordException extends DukeException {

    public UnfoundKeywordException() {
        super("Keyword cannot be found :-(");
    }
}
