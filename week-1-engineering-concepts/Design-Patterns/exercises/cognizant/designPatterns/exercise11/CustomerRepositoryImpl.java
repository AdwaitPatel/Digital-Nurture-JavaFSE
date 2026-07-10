package cognizant.designPatterns.exercise11;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer ID : " + id + ", Name : Adwait Patel";
    }

}

