import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();

        while (true) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "Contains":
                    int checkNumber = Integer.parseInt(input[1]);
                    contains(numbers, checkNumber);
                    break;
                case "Print":
                    if (input[1].equals("odd")) {
                        printOdd(numbers);
                    } else printEven(numbers);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    String condition = input[1];
                    int number = Integer.parseInt(input[2]);
                    filter(numbers, condition, number);
                    break;
                default:
                    break;
            }
        }
    }

    public static void printEven(List<Integer> numbers) {
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void printOdd(List<Integer> numbers) {
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void contains(List<Integer> numbers, int checkNumber) {
        if (numbers.contains(checkNumber)) {
            System.out.println("Yes");
        } else System.out.println("No such number");
    }

    public static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);

    }

    public static void filter(List<Integer> numbers, String condition, int number) {
        switch (condition) {
            case "<":
                for (int num : numbers) {
                    if (num < number) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (int num : numbers) {
                    if (num <= number) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();
                break;
            case ">":
                for (int num : numbers) {
                    if (num > number) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (int num : numbers) {
                    if (num >= number) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();
                break;
            default:
                break;
        }
    }
}
