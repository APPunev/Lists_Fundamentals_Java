import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        while(input.size() > 0){
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= input.size() - 1) {
                int removedElement = input.get(index);
                sum += removedElement;
                input.remove(index);
                changeList(input, removedElement);
            }else if (index < 0) {
                int firstElement = input.get(0);
                sum += firstElement;
                input.set(0,input.get(input.size() - 1));
                changeList(input, firstElement);

            }else if (index > input.size() - 1) {
                int lastElement = input.get(input.size() - 1);
                sum += lastElement;
                input.set(input.size() - 1, input.get(0));
                changeList(input, lastElement);
            }
        }
        System.out.println(sum);
    }

    private static void changeList(List<Integer> input, int removedElement) {
        for (int i = 0; i < input.size(); i++) {
           int currentElement = input.get(i);
            if (removedElement >= input.get(i)) {
                currentElement += removedElement;
            }else{
                currentElement -= removedElement;
            }
            input.set(i, currentElement);
        }
    }
}
