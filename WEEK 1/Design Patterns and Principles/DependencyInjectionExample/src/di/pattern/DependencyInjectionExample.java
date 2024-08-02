package di.pattern;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById("1");
        System.out.println(customer);
    }
}