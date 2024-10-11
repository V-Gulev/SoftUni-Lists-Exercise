import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        List<Integer> drumQuality = new ArrayList<>();
        for (String element : elements) {
            drumQuality.add(Integer.parseInt(element));
        }
        List<Integer> startingDrumQuality = new ArrayList<>(drumQuality);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Hit it again, Gabsy!")) {
                break;
            }
            int damage = Integer.parseInt(command);
            int index = 0;
            for (int i = 0; i < drumQuality.size(); i++) {
                drumQuality.set(index, drumQuality.get(i) - damage);
                if (drumQuality.get(index) <= 0 && budget >= startingDrumQuality.get(index) * 3) {
                    drumQuality.set(index, startingDrumQuality.get(index));
                    budget -= startingDrumQuality.get(index) * 3;
                    index++;
                } else if (drumQuality.get(index) <= 0) {
                    drumQuality.remove(index);
                    startingDrumQuality.remove(index);
                    i--;
                } else index++;

            }


        }
        for (Integer integer : drumQuality) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
