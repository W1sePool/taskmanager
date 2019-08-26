package task.taskmanager.repository;

import task.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {
     List<Task> getAll();
     void save(Task task);
     void update (Task task);
     void delete(Long id);
}
