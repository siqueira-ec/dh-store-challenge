import java.util.List;

public class Order {
	int id;
	private Client client;
	private List<Product> productList;
	
	public Order (int id, Client client, List<Product> productList) {
		this.id = id;
		this.client = client;
		this.productList = productList;
	}

	public Client getClient() {
		return client;
	}

	public List<Product> getProductList() {
		return productList;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", productList=" + productList + "]";
	}
	
}
