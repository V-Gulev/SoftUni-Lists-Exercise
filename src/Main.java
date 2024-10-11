import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());
        String[] input = scanner.nextLine().split(" ");
        String command = input[0];
        int number1;
        int number2 = 0;
        while (!command.equals("end")) {

            number1 = Integer.parseInt(input[1]);
            if (command.equals("Insert")) {
                number2 = Integer.parseInt(input[2]);
            }

            switch (command) {
                case "Add":
                    nums.add(number1);
                    break;
                case "Remove":
                    nums.remove(Integer.valueOf(number1));
                    break;
                case "RemoveAt":
                    nums.remove(number1);
                    break;
                case "Insert":
                    nums.add(number2, number1);
                    break;
                default:
                    break;
            }

            input = scanner.nextLine().split(" ");
            command = input[0];
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
