package task.taskmanager.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import task.taskmanager.Task;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class LocalTaskRepositoryMap implements TaskRepository {

    public LocalTaskRepositoryMap() {
        this.taskMap = new LinkedHashMap<>();
        Task task1 = new Task(1L, 1, "выдача паспорта");
        Task task2 = new Task(2L, 22, "пропуск в посольство");
        Task task3 = new Task(3L, 343, "приглашение на собеседование");
        taskMap.put(task1.getId(), task1);
        taskMap.put(task2.getId(), task2);
        taskMap.put(task3.getId(), task3);

    }

    private Map<Long, Task> taskMap;

    @Override
    public List<Task> getAll() {

        return new ArrayList<>(taskMap.values());
    }

    @Override
    public void save(Task task) {
        long max = 0;
        for (Long l : taskMap.keySet())// берем список всех ключей у такс мап , и в переменную л записываем каждую из них по очередно.
        {
            if (l >  max){
                max = l;
            }

        }
        long nextMax = Collections.max(taskMap.keySet())+1;
        task.setId(max+1);
        taskMap.put(task.getId(), task);
    }

    @Override
    public void update(Task task) {
        taskMap.put(task.getId(),task);
    }
}
