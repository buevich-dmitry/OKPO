package by.bsuir.buevich;

import by.bsuir.buevich.executor.MainExecutor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final String CONTEXT_FILE = "context.xml";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Предоставьте путь к файлу.");
            return;
        }
        ApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_FILE);
        MainExecutor executor = context.getBean(MainExecutor.class);
        executor.run(args[0]);
    }

}
