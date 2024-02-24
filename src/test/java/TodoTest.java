
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import task.Todo;

public class TodoTest {

    @Test
    public void toStringTest() {
        assertEquals("[T][ ] finish cs2103", new Todo("finish cs2103").toString());
    }

    @Test
    public void toSaveStringTest() {
        Todo todo = new Todo("borrow book");
        todo.setStatusIcon(true);
        assertEquals("todo | 1 | borrow book", todo.toSaveString());
    }
}
