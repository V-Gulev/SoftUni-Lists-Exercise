import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream((scanner.nextLine().split(" "))).map(Integer::parseInt).toList());

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("end")) {
                break;
            } else if (command[0].equals("Delete")) {
                numbers.removeAll(Collections.singleton(Integer.parseInt(command[1])));
            } else {
                numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
            }

        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
