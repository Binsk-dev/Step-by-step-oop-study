package movie;

public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
