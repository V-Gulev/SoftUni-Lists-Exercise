import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        List<Integer> numberList = new ArrayList<>();
        List<Character> nonNumberList = new ArrayList<>();

        for (char j : input.toCharArray()) {
            if (Character.isDigit(j)) {
                numberList.add(Character.getNumericValue(j));
            } else nonNumberList.add(j);
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numberList.get(i));
            } else skipList.add(numberList.get(i));
        }

        int index = 0;
        for (int i = 0; i < takeList.size(); i++) {
            int takeCount = takeList.get(i);
            for (int j = 0; j < takeCount && index < nonNumberList.size(); j++) {
                result.append(nonNumberList.get(index));
                index++;
            }
            index += skipList.get(i);
        }
        System.out.println(result);

    }
}
