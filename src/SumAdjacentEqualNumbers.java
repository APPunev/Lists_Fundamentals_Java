import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int index = 0; index < numbers.size() - 1; index++) {
            if (numbers.get(index).equals(numbers.get(index + 1))) {
                numbers.set(index, (numbers.get(index) + numbers.get(index + 1)));
                numbers.remove(index + 1);
                index = -1;
            }
        }
        String output = joinElementsByDelimiter(numbers," ");
        System.out.println(output);


    }

    private static String joinElementsByDelimiter(List<Double> items, String delimiter) {
        String output = "";
        for (Double item:items) {
            output += (new DecimalFormat("0.#").format(item) + delimiter);
        }
        return output;
    }
}
