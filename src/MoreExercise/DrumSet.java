package MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());//1000

        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> currentList = new ArrayList<>(drumSet);

        String input = scanner.nextLine();
        while(!input.equals("Hit it again, Gabsy!")){
            int power = Integer.parseInt(input); //11
            for (int i = 0; i < currentList.size(); i++) {
                if (currentList.get(i) != 0) {
                    currentList.set(i,currentList.get(i) - power);
                }
                if (currentList.get(i) <= 0) {
                    int initialQuality = drumSet.get(i);
                    if (budget < (initialQuality * 3)) {
                        currentList.set(i,0);
                    }else{
                        budget -= (drumSet.get(i) * 3);
                        currentList.set(i,drumSet.get(i));
                    }
                }
            }
            input = scanner.nextLine();
        }
        List<String> output = new ArrayList<>();
        for (int n:currentList) {
            if (n != 0) {
                output.add(String.valueOf(n));
            }
        }
        System.out.print(String.join(" ",output));
        System.out.printf("%nGabsy has %.2flv.",budget);
    }
}
