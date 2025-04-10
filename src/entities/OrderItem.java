package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

	private Integer quantity;
	private Double price;
	private List<Product> products = new ArrayList<>();

	public OrderItem() {

	}

	public OrderItem(Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double subTotal() {
		return quantity * price;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Product product : products) {
			sb.append(product.getName() + ", R$ ");
			sb.append(product.getPrice() + ", ");
		}
		sb.append("Quantity: ");
		sb.append(getQuantity() + ", ");
		sb.append("Subtotal: R$ " + subTotal());
		sb.append("\n");
		return sb.toString();
	}

}
