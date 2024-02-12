
import java.io.*;
import java.util.Scanner;
import Exception.DukeUnknownCommandException;
import Exception.DukeException;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) {
        String logo = "CMU_bot";
        ArrayList<Task> Taskarr = new ArrayList<>();
        int NumOfTask = 0;
        System.out.println("Hello! Boss I'm your " + logo);
        System.out.println("What can I do for you?");

        String path = "data/tasks.txt";
        try {
            BufferedReader Reader = new BufferedReader(new FileReader(path));
            String line;
            while ( (line = Reader.readLine()) != null ) {
                String[] linearr = line.split(" \\| ");
                Task cur = null;
                switch (linearr[0]) {
                    case "Todo":
                        cur = new Todo(linearr[2]);
                        break;
                    case "Deadline":
                        cur = new Deadline(linearr[2], linearr[3]);
                        break;
                    case "Event":
                        String[] time = linearr[3].substring(5).split(" to ");
                        cur = new Event(linearr[2], time[0], time[1]);
                        break;
                }
                cur.setStatusIcon(linearr[1].equals("1"));
                NumOfTask ++;
                Taskarr.add(cur);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("no lines in the file");
        }
        
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        while (isExit) {
            try {
                String commandString = sc.nextLine();
                String[] command = commandString.split(" ", 2);

                if(command[0].equals("bye")) {
                    BufferedWriter Writer = new BufferedWriter(new FileWriter(path));
                    String tasks = "" ;
                    for (Task task : Taskarr) {
                        tasks += task.toSaveString() + "\n";
                    }
                    Writer.write(tasks);
                    Writer.close();

                    System.out.println("Bye. CMU_bot is always here for you, see you again!");
                    isExit = false;

                } else if (command[0].equals("List")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < NumOfTask; i ++) {
                        System.out.println(i + 1 + ". " +  Taskarr.get(i).toString());
                    }
                }  else if (command[0].equals("mark")) {
                    int NumToMark = Integer.parseInt(command[1]) - 1;
                    Taskarr.get(NumToMark).setStatusIcon(true);

                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println((NumToMark + 1) + ". " +  Taskarr.get(NumToMark).toString());

                } else if (command[0].equals("unmark")) { // error need to be paid attention
                    int NumToUnmark = Integer.parseInt(command[1]) - 1;
                    Taskarr.get(NumToUnmark).setStatusIcon(false);

                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println((NumToUnmark + 1) + ". " +  Taskarr.get(NumToUnmark).toString());

                } else if (command[0].equals("todo")){
                    Todo todo = new Todo(command[1]);
                    Taskarr.add(todo);
                    NumOfTask ++;
                    System.out.println("Got it, I have added this task");
                    System.out.println((NumOfTask) + ". " + todo.toString());
                    System.out.println("Now you have " + (NumOfTask) + " tasks in the list");

                } else if (command[0].equals("deadline")) {
                    String[] tasktime = command[1].split("/", 2);
                    if (tasktime.length == 1) {
                        throw new DukeException("Missing deadline time");
                    }
                    String des = tasktime[0];
                    String by = tasktime[1].substring(3);
                    Deadline deadline = new Deadline(des, by);
                    Taskarr.add(deadline);
                    NumOfTask ++;
                    System.out.println("Got it, I have added this task");
                    System.out.println((NumOfTask) + ". " + deadline.toString());
                    System.out.println("Now you have " + (NumOfTask) + " tasks in the list");

                } else if (command[0].equals("event")) {
                    String[] tasktime = command[1].split("/", 3);
                    if (tasktime.length < 3) {
                        throw new DukeException("the date is not complete");
                    }
                    String des = tasktime[0];
                    String from = tasktime[1].substring(5);
                    String to = tasktime[2].substring(3);
                    String time = " (from: " + from + " to: " + to + ")";
                    Event event = new Event(des, from, to);
                    Taskarr.add(event);
                    NumOfTask ++;
                    System.out.println("Got it, I have added this task");
                    System.out.println((NumOfTask) + ". " + event.toString());
                    System.out.println("Now you have " + (NumOfTask) + " tasks in the list");

                } else if (command[0].equals("delete")) {

                    if (command.length < 2) {
                        throw new DukeUnknownCommandException();
                    }
                    int NumDelete = Integer.parseInt(command[1]);
                    if (NumDelete <= 0 || NumDelete > NumOfTask) {
                        throw new DukeException("the task does not exits");
                    } else {
                        String temp = Taskarr.get(NumDelete - 1).toString();
                        Taskarr.remove(NumDelete - 1);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println(temp);
                        NumOfTask -- ;
                        System.out.println("Now you have " + NumOfTask + " tasks in the list.");

                    }

                } else {
                    throw new DukeUnknownCommandException();
                }

            } catch (DukeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("file not found");
            }


        }
    }
}
