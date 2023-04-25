import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The TaskList class represents a list of tasks. it implements serializable
 * to allow serializaton and deserialization of the task objects.
 */
public class TaskList implements Serializable {
    private static final long serialVersionUID=1L;
    private List<Task> tasks;

    /**
     * Constructs a TaskList object with an empty list of tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     * @param task the Task that will be added to the list.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the list based on its index.
     * @param task the task to be removed.
     */
    public void removeTask(int task) {
        tasks.remove(task);
    }

    /**
     * Returns the list of tasks in the task list.
     * @return the list of tasks in the task list.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}

