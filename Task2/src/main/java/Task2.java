import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {
    public static Logger logger = Logger.getInstance();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        logger.Log("Запускаем программу");

        logger.Log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        int n = scanner.nextInt();
        System.out.println("Введите верхнюю границу для значений:");
        int m = scanner.nextInt();

        logger.Log("Создаём и наполняем список");
        List<Integer> sourceList = new Random().ints(n,1, m).boxed().collect(Collectors.toList());
        logger.Log("Вот случайный список: " + sourceList);

        logger.Log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        int f = scanner.nextInt();

        Filter filter = new Filter(f);
        List<Integer> resultList = filter.filterOut(sourceList);

        logger.Log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + resultList);
        logger.Log("Завершаем программу");
    }
}
