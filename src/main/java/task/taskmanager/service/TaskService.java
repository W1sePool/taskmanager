package task.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import task.taskmanager.model.Task;
import task.taskmanager.repository.task.TaskRepository;

import java.util.List;

/**
 * класс с логикой работой заявками
 */
@Service
public class TaskService  { //комментарий

    @Autowired
   // @Qualifier("taskDBRepository")
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.getAll();
    }

    private void validateTask(Task task) throws Exception {
        if(task.getNumber() <= 0 ){
            throw new Exception("number must be > 0 ");
        }
       // if(task.getName().matches("^\\d*$")){
         //   throw new Exception("name must contains one character");
        //}
        //if (task.getName().matches("\\D*\\w")){
         //   throw new Exception("name must contains one letter");
        //}

    }
    public void save(Task task) throws Exception {
        validateTask(task);
        taskRepository.save(task);
    }

    public void update(Task task) throws Exception {
        validateTask(task);
        if (task.getId() == null) {
            taskRepository.save(task);
        } else {
            taskRepository.update(task);
        }
    }

    public void delete(Task task){
        taskRepository.delete(task.getId());
    }
}
