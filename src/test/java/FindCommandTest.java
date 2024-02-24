import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import Commands.FindCommand;
import task.Todo;

public class FindCommandTest {
    @Test
    public void keywordSearchTest() {
        Ui ui = new Ui();
        Storage storage = new Storage("data/tasks.txt");
        TaskList List = new TaskList();

        Todo todo = new Todo("borrow book");
        List.add(todo);
        FindCommand c = new FindCommand("book");
    }
}
