/**
 * @author Matthew Fisher
 * @version 1.0
 * A SimpleTask class which extends the Task class and provides the outline for a task
 * with a short and long description, start date and time, and due date and time.
 *
 * This class inherits the equals method from the abstract
 * Task class to compare equality with another SimpleTask object.
 */

public class SimpleTask extends Task {
    public SimpleTask(String shortDescription, String longDescription, MyDate startDate, Time2 startTime, MyDate dueDate, Time2 dueTime) {
        super(shortDescription, longDescription, startDate, startTime, dueDate, dueTime);
    }

    /**
     * Overrides the equals method to compare equality with another SimpleTask object.
     * @param other: the object to compare to
     * @return true if the objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }



}

