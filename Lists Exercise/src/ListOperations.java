import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("End")){
            switch (command[0]){
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if (indexIsValid(index, numbers.size() -1)) {
                        numbers.add(Integer.parseInt(command[2]),Integer.parseInt(command[1]));
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int index2 = Integer.parseInt(command[1]);
                    if (indexIsValid(index2, numbers.size() -1)) {
                        numbers.remove(Integer.parseInt(command[1]));
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int shiftCount = Integer.parseInt(command[2]);
                    if (command[1].equals("left")) {
                        shiftLeft(numbers,numbers.size(),shiftCount);
                    }else if(command[1].equals("right")){
                        shiftRight(numbers,numbers.size(),shiftCount);
                    }
                    break;
            }

            command = scanner.nextLine().split(" ");
        }

        numbers.forEach(element -> System.out.print(element + " "));
    }

    private static boolean indexIsValid(int index,int size) {
        return index >= 0 && index <= size;
    }

    private static void shiftRight(List<Integer> numbers, int size, int shiftCount) {
        for (int i = 0; i < shiftCount; i++) {
            int lastNum = numbers.get(numbers.size() - 1);
            numbers.add(0, lastNum);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void shiftLeft(List<Integer> numbers, int size, int shiftCount) {
        for (int i = 0; i < shiftCount; i++) {
            int firstNum = numbers.get(0);
            numbers.add(firstNum);
            numbers.remove(0);
        }

    }
}
