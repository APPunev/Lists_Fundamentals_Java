import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());

        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("end")){
            if (command[0].equals("Add")) {
                int numberToAdd = Integer.parseInt(command[1]);
                wagons.add(numberToAdd);
            }else{
                int passengersCount = Integer.parseInt(command[0]);
                addingPassengers(wagons, passengersCount, capacity);
            }

            command = scanner.nextLine().split(" ");
        }
        wagons.forEach(number -> System.out.print(number + " "));
    }

    private static void addingPassengers(List<Integer> wagons, int passengersCount, int capacity) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i) + passengersCount <= capacity) {
                int sumOfPassangers = wagons.get(i) + passengersCount;
                wagons.set(i, sumOfPassangers);
                break;
            }
        }
    }

}
