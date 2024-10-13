import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int removedNumbersSum = 0;
        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(sc.nextLine());

            if (index < 0) {
                int setNumber = pokemons.getLast();
                int removedNumber = pokemons.getFirst();
                removedNumbersSum += removedNumber;
                pokemons.removeFirst();
                pokemons.addFirst(setNumber);
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= removedNumber) {
                        pokemons.set(i, pokemons.get(i) + removedNumber);
                    } else {
                        pokemons.set(i, pokemons.get(i) - removedNumber);
                    }
                }
            } else if (index >= pokemons.size()) {
                int setNumber = pokemons.getFirst();
                int removedNumber = pokemons.getLast();
                removedNumbersSum += removedNumber;
                pokemons.removeLast();
                pokemons.add(setNumber);

                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= removedNumber) {
                        pokemons.set(i, pokemons.get(i) + removedNumber);
                    } else {
                        pokemons.set(i, pokemons.get(i) - removedNumber);
                    }
                }
            } else {
                int removedNumber = pokemons.remove(index);
                removedNumbersSum += removedNumber;
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= removedNumber) {
                        pokemons.set(i, pokemons.get(i) + removedNumber);
                    } else {
                        pokemons.set(i, pokemons.get(i) - removedNumber);
                    }
                }
            }

        }
        System.out.println(removedNumbersSum);

    }
}
