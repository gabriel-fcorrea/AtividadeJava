package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private List<Client> clients = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItem() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public List<Client> getClient() {
		return clients;
	}

	double sum;
	String pp;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment));
		sb.append("\nOrder status: " + status);
		sb.append("\n");
		for (Client client : clients) {
			sb.append(client.toString());
		}
		sb.append("\nORDER ITEMS:\n");

		for (OrderItem item : items) {
			pp = item.toString();
			sb.append(pp);
			sum += item.subTotal();
		}

		sb.append("Total price: R$ " + sum);

		return sb.toString();
	}

}
