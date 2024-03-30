package mainDuke;

import task.Task;

import java.util.ArrayList;

/**
 * Tasklist class will be responsible for all the task operations like add,
 * delete, mark unmark, find. its attribute is the arraylist to sore all the tasks.
 */
public class TaskList {

    private static ArrayList<Task> tasklist;

    public TaskList(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

    public TaskList() {
        tasklist = new ArrayList<>();
    }

    public void add(Task task) {
        tasklist.add(task);
    }

    public void delete(int i) {
        tasklist.remove(i - 1);
    }

    public void markDone(int i) {
        tasklist.get(i - 1).setStatusIcon(true);
    }
    public void unmarkDone(int i) { tasklist.get(i - 1).setStatusIcon(false); }

    public static ArrayList<Task> getTaskList() {
        return tasklist;
    }


}
