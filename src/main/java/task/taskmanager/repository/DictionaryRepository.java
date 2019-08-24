package task.taskmanager.repository;

import org.springframework.stereotype.Repository;
import task.taskmanager.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository {
    private static List<Dictionary> fromAddress = new ArrayList<>();
    private static List<Dictionary> toAddress = new ArrayList<>();
    private static List<Dictionary> status = new ArrayList<>();

    static {
        fromAddress.add(new Dictionary("hello"));
        fromAddress.add(new Dictionary("hello1"));
        fromAddress.add(new Dictionary("hello2"));
        fromAddress.add(new Dictionary("hello3"));
        toAddress.add(new Dictionary("hi1"));
        toAddress.add(new Dictionary("hi2"));
        toAddress.add(new Dictionary("hi3"));
        status.add(new Dictionary("creating"));
        status.add(new Dictionary("send"));
        status.add(new Dictionary("recieve"));
    }

    public  List<Dictionary> getFromAddress() {
        return fromAddress;
    }

    public List<Dictionary> getToAddress() {
        return toAddress;
    }

    public  List<Dictionary> getStatus() {
        return status;
    }
}
