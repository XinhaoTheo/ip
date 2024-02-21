package Commands;

import mainDuke.Storage;
import mainDuke.TaskList;
import mainDuke.Ui;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveFile();
        isExit = true;
        ui.printBye();
    }
}
