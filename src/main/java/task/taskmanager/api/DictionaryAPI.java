package task.taskmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.taskmanager.model.*;
import task.taskmanager.service.DicrionaryService;

import java.util.List;

@RestController//перехватывает http запрос ,  и преобразует ответ в JSON
@RequestMapping("dictionaries")
public class DictionaryAPI {
    @Autowired
    private DicrionaryService dicrionaryService;
    @GetMapping("fromAddress")//данный метод будет выполняться при get запросах

    public List<FromAddress> getFromAdress() {
        System.out.println("метод get fromAddress ");
        return dicrionaryService.getFromAddress();
    }
    @GetMapping("toAddress")
    public List<ToAddress> getToAdress() {
        System.out.println("метод get to Address ");
        return dicrionaryService.getToAddress();
    }
    @GetMapping("status")
    public List<Status> getStatus() {
        System.out.println("метод get Status ");
        return dicrionaryService.getStatus();
    }


}
