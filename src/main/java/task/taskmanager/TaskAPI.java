package task.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * RestController для задач
 */
@RestController // данный класс перехватывает запросы и преобразует ответы в Json
@RequestMapping("tasks") // этот контролер перехватывает запросы которые начинаються с tasks
public class TaskAPI {

    @Autowired //автоматическая иннициализация service бина
    private TaskService taskService;

    @GetMapping//данный метод будет выполняться при get запросах
    public List<Task> getAll() {
        System.out.println("метод get ");
        List<Task> tasks = taskService.getAllTasks();
        return tasks;
    }

    @PostMapping//данный метод будет выполняться при post запросах
    @ResponseStatus(HttpStatus.CREATED)//данный метод возвращает статус 201 ,при успешном выполнении
    public void save(@Valid @RequestBody Task task) throws Exception {
        System.out.println("метод save ");
        taskService.save(task);
    }

    @PutMapping//данный метод будет выполняться при put запросах
    public void update(@Valid @RequestBody Task task) throws Exception {
        System.out.println("метод put ");
        taskService.update(task);

    }


}




