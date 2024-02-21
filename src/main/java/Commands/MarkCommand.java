package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class MarkCommand extends Command{

    private int numToMark;

    public MarkCommand(int numToMark) {
        this.numToMark = numToMark;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.markDone(numToMark);
        ui.printMark(numToMark);


    }
}
