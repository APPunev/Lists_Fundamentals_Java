package MoreExercise;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String text = "";
        for (char c:input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(Integer.parseInt(String.valueOf(c)));
            }else{
                text += c;
            }
        }
        List<Integer> takeList = new ArrayList<>();//even
        List<Integer> skipList = new ArrayList<>();//odd

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                //even
                takeList.add(numbers.get(i));
            }else{
                skipList.add(numbers.get(i));
            }
        }

        StringBuilder takeBuilder = new StringBuilder();
        StringBuilder skipBuilder = new StringBuilder();

        for (int i = 0; i < takeList.size(); i++) {
            int takeIndex = takeList.get(i);
            int skipIndex = skipList.get(i);
            String take = "";
            String skip = "";
            if (takeIndex > text.length() - 1) {
                take = text.substring(0);
            }else{
                take = text.substring(0,takeIndex);
            }
            text = text.replace(take, "");
            takeBuilder.append(take);

            if (skipIndex > text.length() - 1) {
                skip = text.substring(0);
            }else{
                skip = text.substring(0,skipIndex);
            }
            text = text.replace(skip, "");
            skipBuilder.append(skip);
        }
        System.out.println(takeBuilder.toString());
    }
}
