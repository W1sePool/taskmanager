package task.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * класс инициализирующий спринг приложения.
 */
@SpringBootApplication
public class TaskmanagerApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);

    }

}
