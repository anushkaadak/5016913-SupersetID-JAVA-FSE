package di.pattern;

public interface CustomerRepository {
    Customer findCustomerById(String id);
}
