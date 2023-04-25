import java.io.Serializable;

public abstract class Task implements Serializable {
    protected MyDate startDate;
    protected Time2 startTime;
    protected MyDate dueDate;
    protected Time2 dueTime;
    protected MyDate completionDate;
    protected Time2 completionTime;
    protected boolean completed;
    protected String shortDescription;
    protected String longDescription;

    public Task(String shortDescription,
                String longDescription,
                MyDate startDate,
                Time2 startTime,
                MyDate dueDate,
                Time2 dueTime) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.startDate = startDate;
        this.startTime = startTime;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.completed = false;
        this.completionDate = null;
        this.completionTime = null;
    }

    public MyDate getStartDate() {
        return this.startDate;
    }

    public Time2 getStartTime() {
        return this.startTime;
    }

    public MyDate getDueDate() {
        return this.dueDate;
    }

    public Time2 getDueTime() {
        return this.dueTime;
    }

    public MyDate getCompletionDate() {
        return this.completionDate;
    }

    public Time2 getCompletionTime() {
        return this.completionTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setStartDate(MyDate updatedStart) {
        this.startDate = updatedStart;
    }

    public void setStartTime(Time2 updatedTime) {
        this.startTime = updatedTime;
    }

    public void setDueDate(MyDate updatedDue) {
        this.dueDate = updatedDue;
    }

    public void setDueTime(Time2 updatedTime) {
        this.dueTime = updatedTime;
    }

    public boolean setCompleted(boolean isComplete) {
        this.completed = true;

        return isComplete;
    }

    public void setLongDescription(String updatedDescription) {
        this.longDescription = updatedDescription;
    }

    public void setShortDescription(String updatedDescription) {
        this.shortDescription = updatedDescription;
    }

    @Override
    public boolean equals(Object other) {
        boolean theyAreEqual = false;
        if (other instanceof Task) {
            Task otherTask = (Task) other;
            if (this.shortDescription.equals(otherTask.getShortDescription()) &&
                    this.longDescription.equals(otherTask.getLongDescription()) &&
                    this.completed == otherTask.isCompleted() &&
                    this.startDate.equals(otherTask.getStartDate()) &&
                    this.startTime.equals(otherTask.getStartTime()) &&
                    this.dueDate.equals(otherTask.getDueDate()) &&
                    this.dueTime.equals(otherTask.getDueTime())) {

                if (completionDate != null && completionTime != null) {
                    if (this.completionDate.equals(otherTask.getCompletionDate()) &&
                            this.completionTime.equals(otherTask.getCompletionTime())) {
                        theyAreEqual = true;
                    }
                } else {
                    if (completed == false)
                        theyAreEqual = true;
                }
            }
        }
        return theyAreEqual;
    }
    @Override
    public String toString() {
        String taskString = "";
        taskString += "Short Description: " + shortDescription + "\n";
        taskString += "Long Description: " + longDescription + "\n";
        taskString += "Start Date: " + startDate + "\n";
        taskString += "Start Time: " + startTime + "\n";
        taskString += "Due Date: " + dueDate + "\n";
        taskString += "Due Time: " + dueTime + "\n";
        if (completed == true) {
            taskString += "Completion Date: " + completionDate + "\n";
            taskString += "Completion Time: " + completionTime + "\n";
        }
        return taskString;
    }
}
