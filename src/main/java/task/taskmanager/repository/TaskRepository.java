package task.taskmanager.repository;

import task.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> getAll();
    public void save(Task task);
    public void update (Task task);
}
