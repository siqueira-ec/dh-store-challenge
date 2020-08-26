import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {		
		Product p1 = new Product(1, "rc car", 50);
		Product p2 = new Product(2, "tv", 1200);
		Product p3 = new Product(3, "radio", 80);
		Product p4 = new Product(4, "computer", 3300);
		Product p5 = new Product(5, "printer", 180);
		
		Client c1 = new Client(1, "Marcus", 28);
		Client c2 = new Client(2, "Matheus", 24);
		Client c3 = new Client(3, "Estevão", 23);
		Client c4 = new Client(4, "Marcos Segundo", 34);
		Client c5 = new Client(5, "Clístenes", 25);
		
		Order o1 = new Order(1, c2, Arrays.asList(p2, p3, p4));
		Order o2 = new Order(2, c1, Arrays.asList(p4, p5));
		Order o3 = new Order(3, c4, Arrays.asList(p4, p2, p5));
		Order o4 = new Order(4, c3, Arrays.asList(p4, p2, p5));
		Order o5 = new Order(5, c5, Arrays.asList(p4, p2, p5));

		List<Product> productList = Arrays.asList(p1, p2, p3, p4, p5);
		List<Client> clientList = Arrays.asList(c1, c2, c3, c4, c5);
		List<Order> orderList = Arrays.asList(o1, o2, o3, o4, o5);
		
		System.out.println("Product List:");
		productList
			.stream()
			.filter(product -> product.getPrice() > 100)
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Client List:");
		clientList
			.stream()
			.map(client -> client.getName())
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Total Value of Orders:");
		orderList
			.stream()
			.map(order -> order.getProductList())
			.flatMap(productListPerOrder -> productListPerOrder
				.stream()
				.map(product -> product.getPrice()))
			.reduce((total, current) -> total + current)
			.ifPresent(System.out::println);
		System.out.println();
		
		clientList.forEach(client -> printTotalValuePerClientOrder(client, orderList));
	}

	public static void printTotalValuePerClientOrder(Client client, List<Order> orderList) {
		System.out.println("Total Value of Order of " + client.getName() + ":");
		orderList
			.stream()
			.filter(order -> order.getClient() == client)
			.map(order -> order.getProductList())
			.flatMap(productListPerOrder -> productListPerOrder
				.stream()
				.map(product -> product.getPrice()))
			.reduce((total, current) -> total + current)
			.ifPresent(System.out::println);
		System.out.println();
	}
}
