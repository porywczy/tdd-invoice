package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products;

	public void addProduct(Product product) {
		// TODO: implement
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}

	public BigDecimal getSubtotal() {
		BigDecimal subTotal = new BigDecimal("0");
		for( Product p : products ) {
			subTotal.add(p.getPrice());
		}
		return subTotal;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getTotal() {
		return null;
	}
}
