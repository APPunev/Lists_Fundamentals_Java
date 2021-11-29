import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = List.of(scanner.nextLine().split("\\s+"));

        String command = scanner.nextLine();

        while(!command.equals("3:1")){
            String[] operation = command.split(" ");

            if (operation[0].equals("merge")) {
                int startIndex = Integer.parseInt(operation[1]);
                int endIndex = Integer.parseInt(operation[2]);

                if (startIndex >= 0 && startIndex <= input.size() - 1) {
                    mergeElements(input,startIndex,endIndex);
                }

            }else if (operation[0].equals("divide")) {
                int index = Integer.parseInt(operation[1]);
                int partitions = Integer.parseInt(operation[2]);
                String elementToDivide = input.get(index);

                divideElements(elementToDivide,index,partitions,input);
            }
            input.forEach(el -> System.out.print(el + " "));
            command = scanner.nextLine();
        }
        input.forEach(el -> System.out.print(el + " "));

    }

    private static void divideElements(String elementToDivide, int index, int partitions, List<String> data) {
        data.remove(index);
        int partSize = elementToDivide.length() / partitions;
        int begin = 0;

        for (int part = 1; part < partitions; part++) {
            data.add(index, elementToDivide.substring(begin, begin + partSize));
            index++;
            begin += partSize;
        }
        data.add(index,elementToDivide.substring(begin));
    }


    private static void mergeElements(List<String> data, int startIndex, int endIndex) {
        String current = "";
        for (int i = startIndex; i < data.size(); i++) {
            current = current + data.get(i);
            data.remove(i);
        }
        data.set(startIndex, current);
    }
}
