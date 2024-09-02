package joe.command;

import java.time.LocalDate;
import java.util.Objects;

import joe.JoeException;
import joe.Storage;
import joe.Ui;
import joe.task.Deadline;
import joe.task.Task;
import joe.task.TaskList;

/**
 * This class represents the 'deadline' command.
 */
public class DeadlineCommand extends Command {
    private final String description;
    private final LocalDate by;

    /**
     * Constructs a {@code DeadlineCommand} with the specified description and deadline date.
     *
     * @param description the description of the deadline task
     * @param by the date by which the task is to be completed
     */
    public DeadlineCommand(String description, LocalDate by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws JoeException {
        Task newTask = new Deadline(this.description, this.by);
        taskList.addTask(newTask);
        ui.printAddedTask(newTask, taskList.getSize());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        DeadlineCommand that = (DeadlineCommand) obj;
        return Objects.equals(description, that.description) && Objects.equals(by, that.by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, by);
    }
}
