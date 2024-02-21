package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class DeleteCommand extends Command{

    private int numToDelete;

    public DeleteCommand(int numToDelete) {
        this.numToDelete = numToDelete;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printDeleteTask(numToDelete);
        tasks.delete(numToDelete);
        // ui.printDeleteTask(numToDelete);


    }
}
