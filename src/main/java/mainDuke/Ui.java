package mainDuke;

import task.Task;

import java.util.Scanner;

public class Ui {
    private Scanner sc;
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void printWelcome() {
        System.out.println("Hello! Boss I'm your CMU_bot.\nWhat can I do for you? ");
    }

    public void showList() {
        // System.out.println("Here are the tasks in your list:");
        int numOfTask = TaskList.getTaskList().size();
        String lines = "";
        for (int i = 0; i < numOfTask; i ++) {
            int num = i + 1;
            lines = lines + (num + ". " +  TaskList.getTaskList().get(i)) + "\n";
        }
        System.out.println("Here are the tasks in your list:"+ "\n" + lines);

    }

    public void printMark(int index) {
        System.out.println("Nice! I've marked this task as done:\n" + TaskList.getTaskList().get(index - 1));
    }

    public void printUnMark(int index) {
        System.out.println("OK, I've marked this task as not done yet:\n" + TaskList.getTaskList().get(index - 1));
    }

    public void printAddTask(Task task) {
        System.out.println ("Got it, I have added this task\n" + task
                + "Now you have " + TaskList.getTaskList().size() + " tasks in the list");
    }

    public void printDeleteTask(int i) {
        // System.out.println(TaskList.getTaskList());
        System.out.println("Noted. I've removed this task:\n" + TaskList.getTaskList().get(i-1)
                + " Now you have " + TaskList.getTaskList().size() + " tasks in the list");
    }

    public void printBye() {
        System.out.println ("Bye. CMU_bot is always here for you, see you again!");
    }

    public void showLoadingError(String error) { System.out.println(error); }

    public void showError(String error) { System.out.println (error); }



}
