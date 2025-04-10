package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Date orderMoment = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data: ");

		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(nameClient, emailClient, birthDate);
		client.setName(nameClient);
		client.setEmail(emailClient);
		client.setBirthDate(birthDate);

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine();

		Order order = new Order(orderMoment, OrderStatus.valueOf(orderStatus));

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			sc.nextLine();
			System.out.print("Product Name: ");
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice);
			order.addItem(orderItem);
			orderItem.addProduct(product);
		}
		order.addClient(client);

		System.out.println(order);

		sc.close();
	}

}
