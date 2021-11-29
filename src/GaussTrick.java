import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int currentSize = numbers.size() / 2;
        for (int index = 0; index < currentSize; index++) {
            int sum = numbers.get(index) + numbers.get(numbers.size() - 1);
            numbers.set(index,sum);
            numbers.remove(numbers.size() - 1);
        }
        for (int number:numbers) {
            System.out.print(number + " ");
        }
    }
}
