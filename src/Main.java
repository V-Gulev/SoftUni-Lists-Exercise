import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> data = new ArrayList<>(List.of(sc.nextLine().split("\\s+")));
        String command = sc.nextLine();
        while (!command.equals("3:1")) {
            String[] input = command.split("\\s+");
            String action = input[0];

            switch (action) {
                case "merge":
                    int startIndex = Math.max(Integer.parseInt(input[1]), 0);
                    int endIndex = Math.min(Integer.parseInt(input[2]), data.size() - 1);
                    if (startIndex <= endIndex) {
                        merge(data, startIndex, endIndex);
                    }
                    break;

                case "divide":
                    int index = Integer.parseInt(input[1]);
                    int parts = Integer.parseInt(input[2]);
                    if (index >= 0 && index < data.size() && parts > 0) {
                        divide(data, index, parts);
                    }
                    break;
                default:
                    break;
            }

            command = sc.nextLine();
        }

        System.out.println(String.join(" ", data));
    }

    public static void merge(List<String> data, int startIndex, int endIndex) {
        StringBuilder result = new StringBuilder();

        for (int i = startIndex; i <= endIndex; i++) {
            result.append(data.get(i));
        }

        for (int i = endIndex; i >= startIndex; i--) {
            data.remove(i);
        }

        data.add(startIndex, result.toString());
    }

    public static void divide(List<String> data, int index, int parts) {
        String word = data.get(index);
        int partSize = word.length() / parts;


        List<String> dividedParts = new ArrayList<>();

        int currentIndex = 0;
        for (int i = 0; i < parts; i++) {
            if (i == parts - 1) {
                dividedParts.add(word.substring(currentIndex));
            } else {
                dividedParts.add(word.substring(currentIndex, currentIndex + partSize));
                currentIndex += partSize;
            }
        }

        data.remove(index);
        data.addAll(index, dividedParts);
    }
}
