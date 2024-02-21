package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class ListCommand extends Command{

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {;
        ui.showList();
    }

}
