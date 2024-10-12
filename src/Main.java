import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> player1 = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2 = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (!player1.isEmpty() && !player2.isEmpty()) {
            int firstCard = player1.getFirst();
            int secondCard = player2.getFirst();
            player1.removeFirst();
            player2.removeFirst();

            if (firstCard > secondCard) {
                player1.add(firstCard);
                player1.add(secondCard);
            } else if (secondCard > firstCard) {
                player2.add(secondCard);
                player2.add(firstCard);
            }
        }
        int sum = 0;
        if (player1.isEmpty()) {
            for (int card : player2) {
                sum += card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            for (int card : player1) {
                sum += card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

    }
}
