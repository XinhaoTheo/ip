package mainDuke;

import mainDuke.TaskList;
import task.*;
import Exception.DukeException;

import java.io.*;
import java.util.ArrayList;

/**
 * Storage class is responsible for the data storage
 * file path will become the attribute of the class, it will be responsible for saving
 * and loading every task added and stored.
 */
public class Storage {
    private String filepath = "data/tasks.txt";

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Responsible for loading the stored tasks to the current operation workplace task list
     * @return None
     * @throws DukeException the coomand in the file is invalid
     */
    public ArrayList<Task> loadFile() throws DukeException {
        try {
            BufferedReader Reader = new BufferedReader(new FileReader(filepath));
            String line;
            ArrayList<Task> tasklist = new ArrayList<>();
            while ( (line = Reader.readLine()) != null ) {
                String[] linearr = line.split(" \\| ");
                Task cur = null;
                switch (linearr[0]) {
                    case "todo":
                        cur = new Todo(linearr[2]);
                        break;
                    case "deadline":
                        cur = new Deadline(linearr[2], linearr[3]);
                        break;
                    case "event":
                        String[] time = linearr[3].substring(5).split(" to ");
                        cur = new Event(linearr[2], time[0], time[1]);
                        break;

                    default:
                        throw new DukeException("Unknown Command from File");
                }
                cur.setStatusIcon(linearr[1].equals("1"));
                // System.out.println(cur);
                // NumOfTask ++;
                tasklist.add(cur);
            }

            return tasklist;

        } catch (FileNotFoundException e) {
            throw new DukeException("File not found");
        } catch (IOException e) {
            throw new DukeException("no lines in the file");
        }
    }

    /**
     * save all the added tasks to the data file
     */
    public void saveFile() {
        try {
            BufferedWriter Writer = new BufferedWriter(new FileWriter(filepath));
            String tasks = "" ;
            for (Task task : TaskList.getTaskList()) {
                tasks += task.toSaveString() + "\n";
            }
            Writer.write(tasks);
            Writer.close();

        } catch (IOException e) {
            System.out.println("file not found");
        }
    }


}
