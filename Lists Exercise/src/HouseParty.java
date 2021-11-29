import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= commandCount; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[2]){
                case "not":
                    if (names.contains(command[0])) {
                        names.remove(command[0]);
                    }
                    else{
                        System.out.printf("%s is not in the list!%n",command[0]);
                    }
                    break;
                case "going!":
                    if (!names.contains(command[0])) {
                        names.add(command[0]);
                    }
                    else{
                        System.out.printf("%s is already in the list!%n",command[0]);
                    }
                    break;
            }
        }

        names.forEach(name -> System.out.println(name));


    }
}
