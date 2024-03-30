package Commands;

import mainDuke.Storage;
import mainDuke.TaskList;
import mainDuke.Ui;

import Exception.UnfoundKeywordException;

public class FindCommand extends Command{

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            ui.printKeywordSearching(tasks.findTask(keyword));
        } catch (UnfoundKeywordException e) {
            System.out.println(e.getMessage());
        }

    }
}
