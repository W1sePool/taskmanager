package task.taskmanager.repository.dictionary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.FromAddress;

@Repository
public interface FromAddressRepository  extends CrudRepository<FromAddress,Long> { //автоматическое создания репозитория на основе "CRUD"

}
