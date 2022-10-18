import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void Log(String msg) {
        System.out.printf("[%s %d] %s%n",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm:ss")),
                num++,
                msg);
    }
}
