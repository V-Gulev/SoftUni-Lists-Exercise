import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (String j : elements) {
            list.add(Integer.parseInt(j));
        }
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        StringBuilder buildText = new StringBuilder(text);
        for (int number : list) {
            sum = 0;
            while (number > 0) {
                int lastDigit = number % 10;
                sum += lastDigit;
                number /= 10;
            }
            int index = sum % buildText.length();
            char letter = buildText.charAt(index);
            result.append(letter);
            buildText.deleteCharAt(index);

        }
        System.out.println(result.toString());
    }
}
