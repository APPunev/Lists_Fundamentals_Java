import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] bombNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumbers[0]) {
                numbers.set(i, 0);
                changeLeft(numbers, i, bombNumbers);
                changeRight(numbers, i, bombNumbers);
            }

        }
        printSum(numbers);
    }

    private static void printSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.print(sum);
    }

    private static void changeRight(List<Integer> numbers, int index, int[] bombNumbers) {
        int counter = 0;
        for (int i = index;i < numbers.size(); i++) {
            if (i == numbers.size() - 1 || counter == bombNumbers[1]) {
                break;
            }
            numbers.set(i + 1, 0);
            counter++;
        }
    }

    private static void changeLeft(List<Integer> numbers, int index, int[] bombNumbers) {
        int counter = 0;
        for (int i = index;i >= 0; i--) {
            if (i == 0 || counter == bombNumbers[1]) {
                break;
            }
            numbers.set(i - 1, 0);
            counter++;
        }
    }


}

