package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class AddCommand extends Command{

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.printAddTask(task);
    }
}
