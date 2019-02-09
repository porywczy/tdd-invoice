package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	
	//zmienic na Map<Product, Integer>
	private Collection<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
//		products.add(product);
		//przy przeciazaniu korzystamy z najbogatszej
		this.addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {

		for (int i = 0; i < quantity; i++) {
			products.add(product);
		}
	}

	public BigDecimal getTotalNetPrice() {
		BigDecimal subTotal = new BigDecimal("0");
		for (Product p : products) {
			subTotal.add(p.getPrice());
		}
		return subTotal;
	}

	public BigDecimal getTax() {
		BigDecimal getTax = new BigDecimal("0");
		for (Product p : products) {
			getTax.add(p.getTaxPercent());
		}
		return getTax;
		
//		return BigDecimal.ZERO;
	}

	public BigDecimal getTotal() {
		BigDecimal getTotal = new BigDecimal("0");
		for (Product p : products) {
			getTotal.add(p.getPriceWithTax());
		}
		return getTotal;
		
//		return BigDecimal.ZERO;
	}
}
