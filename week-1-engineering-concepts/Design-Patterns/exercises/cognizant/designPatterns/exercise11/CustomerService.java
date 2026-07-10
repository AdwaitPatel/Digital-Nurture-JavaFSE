package cognizant.designPatterns.exercise11;

public class CustomerService {

    private CustomerRepository customerRepository;

    // this is constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomer(int id) {
        System.out.println(customerRepository.findCustomerById(id));
    }

}

