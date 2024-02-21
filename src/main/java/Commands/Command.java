package Commands;

import mainDuke.TaskList;
import mainDuke.Ui;
import mainDuke.Storage;
import task.Task;

public class Command {
    protected boolean isExit = false;

    public Command(){
    }


    public void setExit(boolean bool) {
        isExit = bool;
    }
    public boolean isExit() {return isExit;}

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("Task starts");
    }


}
