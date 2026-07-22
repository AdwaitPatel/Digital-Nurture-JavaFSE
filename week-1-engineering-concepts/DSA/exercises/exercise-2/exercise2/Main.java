package cognizant.dsa.exercise2;

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")

        };

        Product linearResult = LinearSearch.search(products, 104);

        System.out.println("Linear Search:");
        System.out.println(linearResult);

        Product binaryResult = BinarySearch.search(products, 104);

        System.out.println("\nBinary Search:");
        System.out.println(binaryResult);
    }
}
