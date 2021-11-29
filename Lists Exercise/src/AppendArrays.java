import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");

        for (int i = input.length - 1; i >= 0 ; i--) {
            String array = input[i].trim();

            if (array.equals(" ") || array.equals("")) {
                continue;
            }

            String[] number = array.split("\\s+");
            System.out.print(String.join(" ",number));
            System.out.print(" ");
        }
    }
}
