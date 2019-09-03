package task.taskmanager.repository.dictionary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status,Long> {
}
