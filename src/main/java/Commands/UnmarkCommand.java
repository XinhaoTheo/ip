package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class UnmarkCommand extends Command{

    private int numToUnmark;

    public UnmarkCommand(int numToUnmark) {
        this.numToUnmark = numToUnmark;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.unmarkDone(numToUnmark);
        ui.printUnMark(numToUnmark);

    }
}
