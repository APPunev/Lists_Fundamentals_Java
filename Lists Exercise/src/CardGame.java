import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        comparingCards(firstPlayer,secondPlayer);
    }

    private static void comparingCards(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        while(true){
            if (firstPlayer.isEmpty()){
                printSum(firstPlayer,secondPlayer);
                break;
            }else if (secondPlayer.isEmpty()) {
                printSum(firstPlayer,secondPlayer);
                break;
            }
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                int currentBestFirstPl = firstPlayer.get(0);
                int currentBestSecondPl = secondPlayer.get(0);
                firstPlayer.add(currentBestFirstPl);
                firstPlayer.add(currentBestSecondPl);
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            }else if (firstPlayer.get(0) < secondPlayer.get(0)) {
                int currentBestFirstPl = firstPlayer.get(0);
                int currentBestSecondPl = secondPlayer.get(0);
                secondPlayer.add(currentBestSecondPl);
                secondPlayer.add(currentBestFirstPl);
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }else{
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
            }
        }

    private static void printSum(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        int firstSum = 0;
        if (firstPlayer.isEmpty()) {
            for (int element:secondPlayer) {
                firstSum += element;
            }
            System.out.printf("Second player wins! Sum: %d",firstSum);
        }else if (secondPlayer.isEmpty()) {
            for (int element:firstPlayer) {
                firstSum += element;
            }
            System.out.printf("First player wins! Sum: %d",firstSum);
        }
    }

}

