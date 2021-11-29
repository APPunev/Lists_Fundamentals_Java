import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("end")){
            switch (command[0]){
                case "Delete":
                    int element = Integer.parseInt(command[1]);
                    deleteElementsFromList(numbers, element);
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
        numbers.forEach(element -> System.out.print(element + " "));
    }

    private static void deleteElementsFromList(List<Integer> numbers, int element) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == element) {
                numbers.remove(i);
                i--;
            }
        }
    }
}
