import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arrays = input.split("\\|");
        List<String> result = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] nums = arrays[i].trim().split("\\s+");
            for (String num : nums) {
                if (!num.isEmpty()) {
                    result.add(num);
                }
            }
        }
        System.out.println(String.join(" ", result));
    }
}
