package mainDuke;

import java.io.*;
import Exception.DukeException;
import Commands.Command;


/**
 * Duke is an ip for cs2103T
 * it is also a ChatBot programme which will store all the tasks
 * and perform some simple operations like mark, delete, add, find
 * it is like a task management tool
 * since I cannot take this course as I did not take cs2030, and I am already year 3
 * leaning SE is my dream, so I learn to create this project by myself guided by,
 * the instructions from cs2103/T website
 * thank you for all professors and tutors in charge of this course,
 * to give me a chance to learn this course!
 * Best.
 */

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for Duke class with filepath as the parameter
     *
     * @param filePath the filepath of data
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadFile());
            // System.out.println(tasks.getTaskList());
        } catch (DukeException e) {
            ui.showLoadingError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * run for the Duke chatbot programme
     */

    public void run() {
        ui.printWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * main method for Duke class which will give the exact file path for Duke
     * @param args main class
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
