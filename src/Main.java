import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        List<String> items = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String input = sc.nextLine();
            items.add(input);
        }
        items.sort(Comparator.naturalOrder());
        for (int i = 1; i <= items.size(); i++) {
            System.out.printf("%d.%s%n", i, items.get(i - 1));
        }
    }
}
