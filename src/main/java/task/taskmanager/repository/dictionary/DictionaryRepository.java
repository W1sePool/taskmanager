package task.taskmanager.repository.dictionary;

import task.taskmanager.model.Dictionary;
import task.taskmanager.model.FromAddress;
import task.taskmanager.model.Status;
import task.taskmanager.model.ToAddress;

import java.util.List;

public interface DictionaryRepository {

    List<FromAddress> getFromAddress();

    List<ToAddress> getToAddress();

    List<Status> getStatus();

}
