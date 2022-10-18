import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = source.stream()
                .peek(num -> logger.Log("Элемент \"" + num + "\" " +((num > threshold) ? "" : "не ") + "проходит"))
                .filter(num -> num > threshold)
                .collect(Collectors.toList());

        logger.Log("Прошло фильтр " + result.size() + " элемента из " + source.size());

        return result;
    }
}