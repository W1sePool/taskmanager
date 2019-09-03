package task.taskmanager.repository.dictionary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.ToAddress;

@Repository
public interface ToAddressRepository extends CrudRepository<ToAddress,Long> {

}
