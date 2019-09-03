package task.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import task.taskmanager.model.Dictionary;
import task.taskmanager.model.FromAddress;
import task.taskmanager.model.Status;
import task.taskmanager.model.ToAddress;
import task.taskmanager.repository.dictionary.DictionaryRepository;

import java.util.List;

@Service
public class DicrionaryService {
    @Autowired
  //  @Qualifier("localDictionaryRepository")//какой из репозиториев нам использовать локальный или DB
    private DictionaryRepository dictionaryRepository; // вставили наш сервайс diction repository

    public List<FromAddress> getFromAddress() {
        return dictionaryRepository.getFromAddress();
    }

    public List<ToAddress> getToAddress() {
        return dictionaryRepository.getToAddress();
    }

    public  List<Status> getStatus() {
        return dictionaryRepository.getStatus();
    }
}
