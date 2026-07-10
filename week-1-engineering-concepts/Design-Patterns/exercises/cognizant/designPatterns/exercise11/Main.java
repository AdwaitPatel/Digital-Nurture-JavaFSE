package cognizant.designPatterns.exercise11;

public class Main {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.getCustomer(101);

    }
}







