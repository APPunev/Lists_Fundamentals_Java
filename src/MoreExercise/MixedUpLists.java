package MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> combinedList = new ArrayList<>();
        if (firstList.size() > secondList.size()) {
            printCombinedLists(firstList,secondList,combinedList);
        }else{
            printCombinedListsSecond(secondList,firstList,combinedList);
        }
    }

    private static void printCombinedListsSecond(List<Integer> longerList, List<Integer> shorterList, List<Integer> combinedList) {

        while(true){
            if (longerList.size() == 2) {
                break;
            }
            combinedList.add(longerList.get(longerList.size() - 1));
            longerList.remove(longerList.size() -1);
            combinedList.add(shorterList.get(shorterList.size() -1));
            shorterList.remove(shorterList.size() -1);
        }
        Collections.sort(longerList);
        int startRange = longerList.get(0);
        int endRange = longerList.get(1);

        Collections.sort(combinedList);

        List<String> output = new ArrayList<>();
        for (Integer e : combinedList) {
            if (e > startRange && e < endRange) {
                output.add(e.toString());
            }
        }
        System.out.println(String.join(" ",output));


    }

    private static void printCombinedLists(List<Integer> longerList, List<Integer> shorterList,List<Integer> combinedList) {

        //1 5 23 64 2 3 34 54 12
        //43 23 12 31 54 51 92
        
        while(true){
            if (longerList.size() == 2) {
                break;
            }
            combinedList.add(longerList.get(0));
            longerList.remove(0);
            combinedList.add(shorterList.get(0));
            shorterList.remove(0);
        }
        Collections.sort(longerList);
        int startRange = longerList.get(0);
        int endRange = longerList.get(1);

        Collections.sort(combinedList);

        List<String> output = new ArrayList<>();
        for (Integer e : combinedList) {
            if (e > startRange && e < endRange) {
                output.add(e.toString());
            }
        }
        System.out.println(String.join(" ",output));

    }
}
