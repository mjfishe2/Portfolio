import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Matthew Fisher
 * @version 1.0
 * This is a Text Based User Interface for a TaskList program,
 * it provides a simple menu interface for managing tasks.
 */
public class TaskListTUI {
    private TaskList taskList;
    Scanner scanner = new Scanner(System.in);

    /**
     * constructs a tasklistTUI object
     *
     * @param taskList the task list object that will be used for managing tasks.
     */
    public TaskListTUI(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Runs the TUI by displaying a simple user menu and responding to user input.
     * Uses switch cases to respond to the integer input
     */
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Add task");

            System.out.println("2. Remove task");

            System.out.println("3. View Tasks");

            System.out.println("4. Set Complete");

            System.out.println("5. Save");

            System.out.println("6. Load");

            System.out.println("7. Exit");

            System.out.print("Enter you choice: ");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();

                    break;
                case 3:
                    viewTasks(true);

                    break;

                case 4:
                    setComplete();
                    break;

                case 5:
                    saveTaskList();
                    break;

                case 6:
                    loadTaskList();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    /**
     * Adds a task to the task list, by prompting the user to select
     * either simple task or compound task. Then it calls on
     * the respective method.
     *
     */
    protected void addTask() {
        System.out.println(
                "1. Simple Task" + System.lineSeparator() +
                "2. Compound Task" + System.lineSeparator() +
                 "What kind of task do you want (Input Integer)" + System.lineSeparator()
        );
        int choice = getIntInput();
        switch (choice) {
            case 1:
                taskList.add(createSimpleTask());
                break;
            case 2:
               taskList.add(createCompoundTask());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    /**
     * Creates a simple task by prompting the user to enter task information.
     * @return the created SimpleTask object.
     */
    private SimpleTask createSimpleTask(){
        System.out.println("Enter task details: ");
        System.out.print("Short Description: ");
        String shortDescription = getStringInput();
        System.out.print("Long Description: ");
        String longDescription = getStringInput();
        System.out.print("Start Date : ");
        MyDate startDate = getDateInput();
        System.out.print("Start Time : ");
        Time2 startTime = getTimeInput();
        System.out.print("Due Date : ");
        MyDate dueDate = getDateInput();
        System.out.print("Due Time : ");
        Time2 dueTime = getTimeInput();
        SimpleTask stask = new SimpleTask(shortDescription, longDescription, startDate, startTime, dueDate, dueTime);
        System.out.println("Task added");
        return stask;
    }

    /**
     * Creates a compound task by prompting the user to enter task information, then asks
     * if the user would like to create a subtask. If yes,
     * it asks the user whether that subtask will be simple or compound,
     * then it will loop back to the create methods.
     * @return the created Compound Task Object.
     */
    private CompoundTask createCompoundTask(){
        System.out.println("Enter task details: ");
        System.out.print("Short Description: ");
        String shortDescription = getStringInput();
        System.out.print("Long Description: ");
        String longDescription = getStringInput();
        System.out.print("Start Date : ");
        MyDate startDate = getDateInput();
        System.out.print("Start Time : ");
        Time2 startTime = getTimeInput();
        System.out.print("Due Date : ");
        MyDate dueDate = getDateInput();
        System.out.print("Due Time : ");
        Time2 dueTime = getTimeInput();
        CompoundTask ctask = new CompoundTask(shortDescription, longDescription, startDate, startTime, dueDate, dueTime);
        boolean addingSubTasks = true;
        while(addingSubTasks = true){
            System.out.println("Do you want to add a subtask (y/n)? ");
            String choice = getStringInput();
            if(choice.equals("y")){
                Task subtask = null;
                System.out.println("1. Simple Task");
                System.out.println("2. Compound Task");
                System.out.print("Enter the type of subtask(Integer Val): ");
                int subtaskChoice = getIntInput();
                switch (subtaskChoice) {
                    case 1:
                        subtask = createSimpleTask();
                        break;
                    case 2:
                        subtask = createCompoundTask();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                if(subtask != null){
                    ctask.addComponent(subtask);
                    System.out.println("Subtask added");

                }else {
                    System.out.println("Invalid choice. Please enter y/n.");
                    break;
                }
            }else if (choice.equals("n")){
                addingSubTasks = false;
                break;
            }
        }
        System.out.println("Task Added");
        return ctask;
    }

    /**
     * Removes a task from the task list based on user input.
     * If the task ID is valid, it will remove the task.
     */
    protected void removeTask() {
        System.out.println("Enter task ID (starting at 0): ");
        int index = getIntInput();
        List<Task> tasks = taskList.getTasks();
        if (index >=0 && index < tasks.size()) {
            taskList.removeTask(index);
            System.out.println("Task removed");
        }else{
            System.out.println("Invalid task ID");
        }
    }

    /**
     * Displays all tasks in the task list, will always display tasks
     * and subtasks.
     *
     */
    protected void viewTasks(boolean viewSubtasks) {
        List<Task> tasks = taskList.getTasks();
        System.out.println("Tasks");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (viewSubtasks || !(task instanceof CompoundTask)) {
                System.out.println("Task " + (i + 1) + ": " + task);
                if (task instanceof CompoundTask && viewSubtasks) {
                    CompoundTask ctask = (CompoundTask) task;
                    List<Task> subTasks = new ArrayList<>();
                    for (Task component : ctask.getComponents()) {
                        subTasks.add(component);
                    }
                    if (!subTasks.isEmpty()) {
                        System.out.println("Subtasks");
                        for (int j = 0; j < subTasks.size(); j++) {
                            System.out.println("Subtask " + (j + 1) + ": " + subTasks.get(j));
                        }
                    }
                }
            }
        }
    }


    /**
     * Sets a task as complete based on user input.
     * If the input is valid the task will be set as complete,
     * if not an error is thrown.
     */
    public void setComplete() {
        System.out.print("Enter task ID: ");
        int taskId = getIntInput();
        List<Task> tasks = taskList.getTasks();
        if (taskId >= 1 && taskId <= tasks.size()) {
            Task task = tasks.get(taskId - 1);
            if (task instanceof SimpleTask) {
                SimpleTask simpleTask = (SimpleTask) task;
                simpleTask.setCompleted(true);
                System.out.println("Task marked as complete: " + simpleTask.getShortDescription());
            } else if (task instanceof CompoundTask) {
                CompoundTask compoundTask = (CompoundTask) task;
                compoundTask.setCompleted(true);
                System.out.println("Task marked as complete: " + compoundTask.getShortDescription());
            } else {
                System.out.println("Invalid task type");
            }
        } else {
            System.out.println("Invalid task ID");
        }
    }

    /**
     * Saves the task list to a file called Tui.ser, if the user selects it in the menu.
     * If the file already exists, it will overwrite it.
     */
    private void saveTaskList() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Tui.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            objectOut.close();
            fileOut.close();
            System.out.println("TaskList saved to " + "Tui.ser");
        } catch (IOException e) {
            System.out.println("Error saving TaskList: " + e.getMessage());
        }
    }

    /**
     * Loads a task list from Tui.ser if the user selects it in the menu.
     */
    private void loadTaskList() {
        try {
            FileInputStream fileIn = new FileInputStream("Tui.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            taskList = (TaskList) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("TaskList loaded from " + "Tui.ser");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading TaskList: " + e.getMessage());
        }
    }

    /**
     * Helper method
     * Gets an integer input to use for the menu's from the user
     *
     * @return the integer input provided by the user.
     */
    private int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Invalid input. Please enter an integer");
            scanner.next();
        }
        int input = scanner.nextInt();
                scanner.nextLine();
                return input;
    }

    /**
     * Helper method
     * Gets a string input from the user.
     * @return the string input provided by the user.
     */
    private String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Helper Method
     * Gets a date input from the user.
     * @return the MyDate object created from the user input.
     */
    private MyDate getDateInput() {
        Scanner scanner = new Scanner(System.in);
        int input1;
        while (true) {
            System.out.print("Enter month: ");
            if (scanner.hasNextInt()) {
                input1 = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for month.");
                scanner.next(); // Consume the invalid input
            }
        }
        int input2;
        while (true) {
            System.out.print("Enter day: ");
            if (scanner.hasNextInt()) {
                input2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for day.");
                scanner.next(); // Consume the invalid input
            }
        }
        int input3;
        while (true) {
            System.out.print("Enter year: ");
            if (scanner.hasNextInt()) {
                input3 = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for year.");
                scanner.next(); // Consume the invalid input
            }
        }
        int year = input3;
        int day = input2;
        int month = input1;
        MyDate date = new MyDate(day, month, year);
        return date;
    }

    /**
     * Helper Method
     * Gets a time input from the user.
     * @return the Time2 object created from the user input.
     */
    private Time2 getTimeInput() {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print("Hour: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for hour.");
                scanner.next(); // Consume the invalid input
            }
        }
        int input2;
        while (true) {
            System.out.print("Minute: ");
            if (scanner.hasNextInt()) {
                input2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer for minute.");
                scanner.next(); // Consume the invalid input
            }
        }

        int hour =  input;
        int minute = input2;
        Time2 time = new Time2(hour, minute);
        return time;
    }

    /**
     * Main method that runs the program.
     *
     */
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        TaskListTUI tui = new TaskListTUI(taskList);
        tui.run();
    }
}
