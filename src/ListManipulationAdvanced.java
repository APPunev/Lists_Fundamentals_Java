import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")){
            switch (command[0]){
                case "Contains":
                    if (numbers.contains(Integer.valueOf(command[1]))) {
                        System.out.println("Yes");
                    }else{
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (command[1]){
                        case "even":
                            printEvenFromList(numbers);
                            break;
                        case "odd":
                            printOddFromList(numbers);
                            break;
                    }
                    break;
                case "Get":
                    printSumOfNumbers(numbers);
                    break;
                case "Filter":
                    printFilteredNumbers(command, numbers);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
    }

    private static void printFilteredNumbers(String[] command, List<Integer> numbers) {
        switch (command[1]){
            case "<":
                for (int index = 0; index < numbers.size(); index++) {
                    if (numbers.get(index) < Integer.parseInt(command[2])) {
                        System.out.print(numbers.get(index) + " ");
                    }
                }
                break;
            case ">":
                for (int index = 0; index < numbers.size(); index++) {
                    if (numbers.get(index) > Integer.parseInt(command[2])) {
                        System.out.print(numbers.get(index) + " ");
                    }
                }
                break;
            case "<=":
                for (int index = 0; index < numbers.size(); index++) {
                    if (numbers.get(index) <= Integer.parseInt(command[2])) {
                        System.out.print(numbers.get(index) + " ");
                    }
                }
                break;
            case ">=":
                for (int index = 0; index < numbers.size(); index++) {
                    if (numbers.get(index) >= Integer.parseInt(command[2])) {
                        System.out.print(numbers.get(index) + " ");
                    }
                }
                break;
        }
        System.out.println();
    }

    private static void printSumOfNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++) {
            sum += numbers.get(index);
        }
        System.out.println(sum);
    }

    private static void printOddFromList(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 != 0) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }

    private static void printEvenFromList(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            if (numbers.get(index) % 2 == 0) {
                System.out.print(numbers.get(index) + " ");
            }
        }
        System.out.println();
    }
}
