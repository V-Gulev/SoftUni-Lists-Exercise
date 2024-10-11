import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Integer> list2 = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Integer> result = new ArrayList<>();

        while (!list2.isEmpty() && !list1.isEmpty()) {
            result.add(list1.getFirst());
            result.add(list2.getFirst());
            list1.removeFirst();
            list2.removeFirst();
        }

        if (!list1.isEmpty()) {
            result.addAll(list1);
        } else if (!list2.isEmpty()) {
            result.addAll(list2);
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
