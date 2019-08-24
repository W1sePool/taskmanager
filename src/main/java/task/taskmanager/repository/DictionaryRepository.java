package task.taskmanager.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository {
    private static List<String> fromAddress = new ArrayList<>();
    private static List<String> toAddress = new ArrayList<>();
    private static List<String> status = new ArrayList<>();

    static {
        fromAddress.add("hello");
        fromAddress.add("hello1");
        fromAddress.add("hello2");
        fromAddress.add("hello3");
        toAddress.add("hi1");
        toAddress.add("hi2");
        toAddress.add("hi3");
        status.add("creating");
        status.add("send");
        status.add("recieve");
    }

    public  List<String> getFromAddress() {
        return fromAddress;
    }

    public List<String> getToAddress() {
        return toAddress;
    }

    public  List<String> getStatus() {
        return status;
    }
}
