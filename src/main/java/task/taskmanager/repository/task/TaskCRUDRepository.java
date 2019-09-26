package task.taskmanager.repository.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.Task;
@Repository
public interface TaskCRUDRepository extends CrudRepository<Task,Long> //CRUD спринговый интерфейс для работы с БД
{

}
