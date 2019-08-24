package task.taskmanager.repository;

import org.springframework.stereotype.Repository;
import task.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LocalTaskRepositoryList implements TaskRepository {


    public LocalTaskRepositoryList() {
        this.taskList = new ArrayList<>();
      //  Task task1 = new Task(1L, 1, "выдача паспорта");
       // Task task2 = new Task(2L, 22, "пропуск в посольство");
       // Task task3 = new Task(3L, 343, "приглашение на собеседование");
       // taskList.add(task1);
        //taskList.add(task2);
      //  taskList.add(task3);

    }

    private List<Task> taskList;

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public void save(Task task) {

    }

    @Override
    public void update(Task task) {

    }
}