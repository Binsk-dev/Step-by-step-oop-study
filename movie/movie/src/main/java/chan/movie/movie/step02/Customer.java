package chan.movie.movie.step02;

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

	public boolean CheckName(String name) {
		if (this.name == name) {
			return true;
		} else return false;
	}

	public boolean CheckId(String id) {
		if (this.id == id) {
			return true;
		} else return false;
	}
}
