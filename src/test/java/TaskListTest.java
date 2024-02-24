import mainDuke.TaskList;
import org.junit.jupiter.api.Test;
import task.Todo;
import Exception.UnfoundKeywordException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskListTest {
    @Test
    public void constructorOfTaskTest() {
        TaskList tasklist = new TaskList();

        Todo todo = new Todo("finish cs2103 ip");
        tasklist.add(todo);
        assertEquals(todo, TaskList.getTaskList().get(0));
        assertEquals(1, TaskList.getTaskList().size());

        tasklist.markDone(1);
        assertEquals("X", TaskList.getTaskList().get(0).getStatusIcon());

        tasklist.delete(1);
        assertEquals(0, TaskList.getTaskList().size());
    }

    @Test
    public void findTaskTest() {
        TaskList tasklist = new TaskList();

        Todo todo = new Todo("finish cs2103 ip");
        tasklist.add(todo);
        try {
            assertEquals("[T][ ] finish cs2103 ip", tasklist.findTask("cs2103").get(0).toString());
            //fail();
        } catch (UnfoundKeywordException e) {
            assertEquals("Keyword cannot be found :-(", e.getMessage());

        }





    }


}
