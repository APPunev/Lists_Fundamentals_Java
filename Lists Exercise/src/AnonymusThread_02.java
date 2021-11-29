import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnonymusThread_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        String command = scanner.nextLine();

        while (!command.equals("3:1")){

            String[] input = command.split("\\s+");

            if (input[0].equals("merge")) {
                int startIndex = Integer.parseInt(input[1]);
                int endIndex = Integer.parseInt(input[2]);
                if (startIndex >= 0 && startIndex <= data.size() - 1
                || endIndex >= 0 && endIndex <= data.size() - 1) {
                    mergeList(data,startIndex,endIndex);
                }else{
                    continue;
                }
                
            }else if (input[0].equals("divide")) {

            }
        }
    }

    private static void mergeList(List<String> data, int startIndex, int endIndex) {
        String current = "";
        if (startIndex >= 0 && startIndex <= data.size() - 1) {
            for (int i = startIndex; i < data.size(); i++) {

                current += data.get(i);
                if (i == endIndex) {
                    break;
                }
            }
        }else if (startIndex < 0) {

        }else if (startIndex > data.size() - 1) {

        }else if (endIndex >= 0 && endIndex <= data.size() - 1) {

        }else if (endIndex > data.size() - 1) {

        }else if (endIndex < 0) {

        }
    }
}
//Johny Bony Larry Tony Manny
// 0     1     2    3    4