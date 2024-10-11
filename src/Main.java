import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        String[] elements1 = input1.split(" ");
        String[] elements2 = input2.split(" ");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (String j : elements1) {
            list1.add(Integer.parseInt(j));
        }

        for (String k : elements2) {
            list2.add(Integer.parseInt(k));
        }

        int end = Math.min(list1.size(), list2.size());
        int index = list2.size() - 1;
        List<Integer> mixedList = new ArrayList<>();

        for (int i = 0; i < end; i++) {
            mixedList.add(list1.get(i));
            mixedList.add(list2.get(index));
            index--;
        }
        int startRange;
        int endRange;
        if (list1.size() > list2.size()) {
            endRange = list1.getLast();
            list1.removeLast();
            startRange = list1.getLast();
        } else {
            endRange = list2.getFirst();
            list2.removeFirst();
            startRange = list2.getFirst();
        }

        if (startRange > endRange) {
            int temp = startRange;
            startRange = endRange;
            endRange = temp;
        }
        mixedList.sort(Comparator.naturalOrder());
        for (Integer integer : mixedList) {
            if (integer > startRange && integer < endRange) {
                System.out.print(integer + " ");
            }
        }
    }
}
