package MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> time = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        double leftRacer = 0;
        double rightRacer = 0;
        if (time.size() == 1) {
            System.out.printf("The winner is left with total time: %.1f",(double)time.get(0));
            return;
        }
        for (int i = 0; i < time.size()/2; i++) {
            if (time.get(i) == 0) {
                leftRacer *= 0.8;
            }else{
                leftRacer += time.get(i);
            }
        }
        for (int i = time.size() - 1; i > time.size()/2; i--) {
            if (time.get(i) == 0) {
                rightRacer *= 0.8;
            }else{
                rightRacer += time.get(i);
            }
        }
        if (rightRacer < leftRacer) {
            System.out.printf("The winner is right with total time: %.1f",rightRacer);
        }else{
            System.out.printf("The winner is left with total time: %.1f",leftRacer);
        }
    }
}
