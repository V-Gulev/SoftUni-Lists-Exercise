import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());

        while (true) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];
            if (input[0].equals("End")) {
                break;
            }

            switch (command) {
                case "Add":
                    numbers.add(Integer.parseInt(input[1]));
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(input[1]);
                    if (removeIndex >= numbers.size() || removeIndex < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(removeIndex);
                    }
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(input[2]);
                    if (insertIndex > numbers.size() || insertIndex < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(insertIndex, Integer.parseInt(input[1]));
                    }
                    break;
                case "Shift":
                    if (input[1].equals("left")) {
                        shiftLeft(numbers, Integer.parseInt(input[2]));
                    } else {
                        shiftRight(numbers, Integer.parseInt(input[2]));
                    }
                    break;
                default:
                    break;
            }
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static void shiftLeft(List<Integer> numbers, int timesRepeat) {
        for (int i = 0; i < timesRepeat; i++) {
            numbers.add(numbers.get(0));
            numbers.remove(0);
        }
    }

    public static void shiftRight(List<Integer> numbers, int timesRepeat) {
        for (int i = 0; i < timesRepeat; i++) {
            numbers.add(0, numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
    }
}
