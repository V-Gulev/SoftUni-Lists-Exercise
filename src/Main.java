import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] elements = input.split(" ");
        int index = (int) Math.floor(elements.length/2);
        int[] array1 = new int[index];
        int[] array2 = new int[index];
        int position = array2.length - 1;
        for (int i = 0; i < index; i++) {
            array1[i] = Integer.parseInt(elements[i]);
        }
        for (int i = elements.length - 1; i > index ; i--) {
            array2[position] = Integer.parseInt(elements[i]);
            position--;
        }

        double car1 = 0;
        for (int i = 0; i < index; i++) {
            if (array1[i] == 0 && i != array1.length - 1) {
                car1 = car1 * 0.8;
            } else car1 += array1[i];

        }
        double car2 = 0;
        for (int i = array2.length - 1; i >= 0; i--) {
            if (array2[i] == 0) {
                car2 = car2 * 0.8;
            } else car2 += array2[i];

        }

        if (car2 < car1) {
            System.out.printf("The winner is right with total time: %.1f", car2);
        } else System.out.printf("The winner is left with total time: %.1f", car1);

    }
}
