package task.taskmanager.repository.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.FromAddress;
import task.taskmanager.model.Status;
import task.taskmanager.model.ToAddress;

import java.util.List;

@Repository
@Profile("db")
public class DBDictionaryRepository implements DictionaryRepository{
    @Autowired
    FromAddressRepository fromAddressRepository;
    @Override
    public List<FromAddress> getFromAddress() {
        return (List<FromAddress>) fromAddressRepository.findAll();
    }
    @Autowired
    ToAddressRepository toAddressRepository;
    @Override
    public List<ToAddress> getToAddress() {
        return (List<ToAddress>) toAddressRepository.findAll();
    }
    @Autowired
    StatusRepository statusRepository;
    @Override
    public List<Status> getStatus() {
        return (List<Status>) statusRepository.findAll();
    }
}
