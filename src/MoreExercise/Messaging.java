package MoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> num = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String text = scanner.nextLine();


        String output = "";
        for (String n:num) {
            String current = n;
            int index = 0;
            for (int i = 0; i < n.length(); i++) {
                index += Integer.parseInt(String.valueOf(n.charAt(i)));
            }
            if (index >= text.length()) {
                index = index - text.length();
            }
            output += text.charAt(index);
            StringBuilder bld = new StringBuilder(text);
            bld.deleteCharAt(index);
            text = bld.toString();
        }
        System.out.println(output);
    }
}
//18
//24
