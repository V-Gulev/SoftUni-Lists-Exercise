import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> trainWagons = new ArrayList<>(Arrays.stream((scanner.nextLine().split(" "))).map(Integer::parseInt).toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("end")) {
                break;
            } else if (command[0].equals("Add")) {
                trainWagons.add(Integer.parseInt(command[1]));
            } else {
                for (int i = 0; i < trainWagons.size(); i++) {
                    if (trainWagons.get(i) + Integer.parseInt(command[0]) <= maxCapacity) {
                        trainWagons.set(i, trainWagons.get(i) + Integer.parseInt(command[0]));
                        break;
                    }
                }
            }

        }
        for (int wagon : trainWagons) {
            System.out.print(wagon + " ");
        }
    }
}
