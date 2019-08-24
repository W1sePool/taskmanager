package task.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.taskmanager.repository.DictionaryRepository;

import java.util.List;

@Service
public class DicrionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository; // вставили наш сервайс diction repository

    public List<String> getFromAddress() {
        return dictionaryRepository.getFromAddress();
    }

    public List<String> getToAddress() {
        return dictionaryRepository.getToAddress();
    }

    public  List<String> getStatus() {
        return dictionaryRepository.getStatus();
    }
}
