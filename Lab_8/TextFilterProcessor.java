import java.util.List;
import java.util.stream.Collectors;

public class TextFilterProcessor {

    @DataProcessor
    public List<String> filterCommentsAndEmptyLines(List<String> data) {
        return data.stream()
                .filter(line -> line != null && !line.trim().isEmpty())
                .filter(line -> !line.trim().startsWith("#"))
                .collect(Collectors.toList());
    }
    
    @DataProcessor
    public List<String> transformToUpperCase(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}