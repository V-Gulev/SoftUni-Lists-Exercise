import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        while (input.size() > 1) {
            int a = input.get(0) + input.get(input.size() - 1);
            input.remove(0);
            input.remove(input.size() - 1);
            result.add(a);
        }
        if (!input.isEmpty()) {
            result.add(input.get(0));
        }
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
