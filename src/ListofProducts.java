import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListofProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int productCount = Integer.parseInt(scanner.nextLine());
        List<String> productList = new ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            String currentProducts = scanner.nextLine();
            productList.add(currentProducts);
        }
        Collections.sort(productList);

        for (int index = 0; index < productList.size(); index++) {
            System.out.printf("%d.%s%n", index + 1,productList.get(index) );
        }
    }
}
