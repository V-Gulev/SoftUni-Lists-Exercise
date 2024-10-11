import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> peopleGoing = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (input[2].equals("not")) {
                if (peopleGoing.contains(input[0])) {
                    peopleGoing.remove(input[0]);
                } else {
                    System.out.println(input[0] + " is not in the list!");
                }
            } else {
                if (peopleGoing.contains(input[0])) {
                    System.out.println(input[0] + " is already in the list!");
                } else {
                    peopleGoing.add(input[0]);
                }
            }

        }
        for (String name : peopleGoing) {
            System.out.println(name);
        }
    }
}
