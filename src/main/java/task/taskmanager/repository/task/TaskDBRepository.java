package task.taskmanager.repository.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.Task;

import java.util.List;
@Repository
@Profile("!local")
public class TaskDBRepository implements TaskRepository {

    @Autowired
    TaskCRUDRepository taskCRUDRepository;
    @Override
    public List<Task> getAll() {
        return (List<Task>) taskCRUDRepository.findAll();
    }

    @Override
    public void save(Task task) {
        taskCRUDRepository.save(task);
    }

    @Override
    public void update(Task task) {
        taskCRUDRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskCRUDRepository.deleteById(id);
    }
}
