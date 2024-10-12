import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int specialNumber = sc.nextInt();
        int powerOfNumber = sc.nextInt();
        int index;
        int sum = 0;
        while (numbers.contains(specialNumber)) {

            for (int i = 1; i <= powerOfNumber; i++) {
                index = numbers.indexOf(specialNumber);
                if (index < numbers.size() - 1) {
                    numbers.remove(index + 1);
                }
                index = numbers.indexOf(specialNumber);
                if (index != 0) {
                    numbers.remove(index - 1);
                }
            }
            numbers.remove((Integer) specialNumber);
        }
        for (int num : numbers) {
            sum += num;
        }

        System.out.println(sum);
    }
}
