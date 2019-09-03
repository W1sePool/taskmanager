package task.taskmanager.repository.dictionary;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import task.taskmanager.model.Dictionary;
import task.taskmanager.model.FromAddress;
import task.taskmanager.model.Status;
import task.taskmanager.model.ToAddress;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("local")
public class LocalDictionaryRepository implements DictionaryRepository{
    private static List<FromAddress> fromAddress = new ArrayList<>();
    private static List<ToAddress> toAddress = new ArrayList<>();
    private static List<Status> status = new ArrayList<>();

    static {
        fromAddress.add(new FromAddress("hello"));
        fromAddress.add(new FromAddress("hello1"));
        fromAddress.add(new FromAddress("hello2"));
        fromAddress.add(new FromAddress("hello3"));
        toAddress.add(new ToAddress("hi1"));
        toAddress.add(new ToAddress("hi2"));
        toAddress.add(new ToAddress("hi3"));
        status.add(new Status("creating"));
        status.add(new Status("send"));
        status.add(new Status("recieve"));
    }

    public  List<FromAddress> getFromAddress() {
        return fromAddress;
    }

    public List<ToAddress> getToAddress() {
        return toAddress;
    }

    public  List<Status> getStatus() {
        return status;
    }
}
