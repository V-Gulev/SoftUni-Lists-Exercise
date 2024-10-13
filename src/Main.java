import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> schedule = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        String input = sc.nextLine();

        while (!input.equals("course start")) {
            String[] commands = input.split(":");

            switch (commands[0]) {
                case "Add":
                    if (!schedule.contains(commands[1])) {
                        schedule.add(commands[1]);
                    }
                    break;
                case "Insert":
                    if (!schedule.contains(commands[1])) {
                        schedule.add(Integer.parseInt(commands[2]), commands[1]);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(commands[1])) {
                        int index = schedule.indexOf(commands[1]);
                        schedule.remove(index);

                        if (index < schedule.size() && schedule.get(index).equals(commands[1] + "-Exercise")) {
                            schedule.remove(index);
                        }
                    }
                    break;
                case "Swap":
                    if (schedule.contains(commands[1]) && schedule.contains(commands[2])) {
                        int index1 = schedule.indexOf(commands[1]);
                        int index2 = schedule.indexOf(commands[2]);


                        String temp = schedule.get(index1);
                        schedule.set(index1, schedule.get(index2));
                        schedule.set(index2, temp);


                        if (index1 + 1 < schedule.size() && schedule.get(index1 + 1).equals(commands[1] + "-Exercise")) {
                            String exercise = schedule.remove(index1 + 1);
                            schedule.add(index2 + 1, exercise);
                        }

                        if (index2 + 1 < schedule.size() && schedule.get(index2 + 1).equals(commands[2] + "-Exercise")) {
                            String exercise = schedule.remove(index2 + 1);
                            schedule.add(index1 + 1, exercise);
                        }
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(commands[1])) {
                        int index = schedule.indexOf(commands[1]);
                        if (index + 1 >= schedule.size() || !schedule.get(index + 1).equals(commands[1] + "-Exercise")) {
                            schedule.add(index + 1, commands[1] + "-Exercise");
                        }
                    } else {
                        schedule.add(commands[1]);
                        schedule.add(commands[1] + "-Exercise");
                    }
                    break;
                default:
                    break;
            }
            input = sc.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }
    }
}
