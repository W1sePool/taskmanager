package task.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;//данный класс запуститься при старте пирложения
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import task.taskmanager.model.FromAddress;
import task.taskmanager.model.Status;
import task.taskmanager.model.Task;
import task.taskmanager.model.ToAddress;
import task.taskmanager.repository.dictionary.FromAddressRepository;
import task.taskmanager.repository.dictionary.StatusRepository;
import task.taskmanager.repository.dictionary.ToAddressRepository;
import task.taskmanager.repository.task.TaskCRUDRepository;

@Component
@Profile("h2")
//@EnableTransactionManagement//подключает к этому классу возможность вставлять в базу данных данные :)
public class DataInit implements ApplicationRunner {


    @Autowired
    private TaskCRUDRepository taskCRUDRepository;
    @Autowired
    private FromAddressRepository fromAddressRepository;
    @Autowired
    private ToAddressRepository toAddressRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Task task1 = new Task(1L, 1, "выдача паспорта","hello1","hi1","creating");
        Task task2 = new Task(2L, 22, "пропуск в посольство","hello2","hi2","send");
        Task task3 = new Task(3L, 343, "приглашение на собеседование","hello3","hi3","recieve");
        taskCRUDRepository.save(task1);
        taskCRUDRepository.save(task2);
        taskCRUDRepository.save(task3);
        fromAddressRepository.save(new FromAddress("hello"));
        fromAddressRepository.save(new FromAddress("hello1"));
        fromAddressRepository.save(new FromAddress("hello2"));
        fromAddressRepository.save(new FromAddress("hello3"));
        toAddressRepository.save(new ToAddress("hi1"));
        toAddressRepository.save(new ToAddress("hi2"));
        toAddressRepository.save(new ToAddress("hi3"));
        statusRepository.save(new Status("creating"));
        statusRepository.save(new Status("send"));
        statusRepository.save(new Status("recieve"));
    }
}
