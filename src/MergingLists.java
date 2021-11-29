import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("" + " "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("" + " "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int smallerList = Math.min(firstList.size(), secondList.size());
        for (int index = 0; index < smallerList; index++) {
            System.out.print(firstList.get(index) + " " + secondList.get(index) + " ");
        }
        printRestOfLongerList(firstList,smallerList);
        printRestOfLongerList(secondList,smallerList);
    }

    private static void printRestOfLongerList(List<Integer> list, int startIndex) {
        for (int index = startIndex; index < list.size(); index++) {
            System.out.print(list.get(index) + " ");
        }

    }
}
