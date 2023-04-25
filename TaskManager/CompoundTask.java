/**
 * @author Matthew Fisher
 *  @version 1.0
 * Times cried over this assignment: 15
 *
 *  A CompoundTask class represents a task that is made up of multiple sub-tasks. Each sub-task
 * is an instance of the Task class. A CompoundTask can have up to 10 sub-tasks.
 *
 *  If more than 10 "sub class" are added to the array an error is printed.
 *
 *  This class extends the abstract Task class and inherits its properties and methods.
 *
 *  The CompoundTask class has an array of Task objects and an integer that keeps track of the number of tasks that have
 *  been added to the CompoundTask.
*/


public class CompoundTask extends Task {
    private Task[] Tasks;
    private int numTasks;

    /**
     * Constructs a CompoundTask object with the inherited parameters.
     *
     * @param shortDescription the short description of CompoundTask.
     * @param longDescription  the long description of CompoundTask.
     * @param startDate        the start date of CompoundTask.
     * @param startTime        the start time of CompoundTask.
     * @param dueDate          the due date of CompoundTask.
     * @param dueTime          the due time of CompoundTask.
     */
    public CompoundTask(String shortDescription, String longDescription, MyDate startDate, Time2 startTime, MyDate dueDate, Time2 dueTime) {
        super(shortDescription, longDescription, startDate, startTime, dueDate, dueTime);
        Tasks = new Task[10];
        numTasks = 0;
    }

    /**
     * If the CompoundTask already has 10 tasks, prints a message and returns.
     * <p>
     * Makes sure that the StartDate is not before the Compound class StartDate and if it is it changes it.
     *
     * @param task the sub-task to add to the CompoundTask
     */
    public void addComponent(Task task) {
        if (numTasks >= 10) {
            System.out.println("Compound Task can only have 10 Tasks");
            return;
        }
        Tasks[numTasks] = task;
        numTasks++;
        if (task.getStartDate().compareTo(this.getStartDate()) == -1) {
            task.setStartDate(this.getStartDate());
        }

        if (task.getDueDate().compareTo(this.getStartDate()) == -1) {
            task.setDueDate(this.getDueDate());
        }
        if (task.getStartDate().compareTo(this.getDueDate()) == 1) {
            task.setStartDate(this.getStartDate());
        }
        if (task.getDueDate().compareTo(this.getDueDate()) == 1) {
            task.setDueDate(this.getDueDate());
        }
    }

    /**
     * Checks if all sub-tasks in the CompoundTask are complete. If all sub-tasks are complete,
     * returns true. Otherwise, returns false.
     *
     * @param tasks the sub-task to check if it is complete.
     * @return true if all sub-tasks in the CompoundTask are complete. Otherwise, returns false.
     */
    public boolean setComplete(Task tasks) {
        boolean completed = true;
        for (int i = 0; i < 10; i++) {
            if (Tasks.equals(0)) {
                completed = false;
                break;
            }

        }

        return completed;
    }

    public int getNumTasks() {
        return numTasks;
    }

    /**
     * getTasks loops through the array
     *
     * @return prints out the task list that is stored in the array
     */
    public Task getTasks() {
        for (int i = 0; i < 10; i++) {
            return Tasks[i];
        }
        return null;
    }


    public Task[] getComponents() {
        for (int j = 0; j < 10; j++) {
            return Tasks;
        }

        return null;
    }
}



