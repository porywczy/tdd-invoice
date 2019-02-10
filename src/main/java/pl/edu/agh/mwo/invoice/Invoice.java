package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {

	// key: produkt, value: ilosc
	private Map<Product, Integer> products = new HashMap<Product, Integer>();

	// Dodaj do faktury numer. Powinien on być narzucany przez system przy
	// tworzeniu faktury.
	private int number;
	private static Integer nextNumber = 1;

	public Invoice() {
		this.number = nextNumber++;
	}

	public void addProduct(Product product) {
		addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {

		// null, <0
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException();
		}
		// dodanie do mapy
		products.put(product, quantity);
	}

	public BigDecimal getNetTotal() {
		BigDecimal totalNet = BigDecimal.ZERO;

		// iteracja po zbiorze kluczy (produktow)
		for (Product product : products.keySet()) {

			// ile produktow
			BigDecimal quantity = new BigDecimal(products.get(product));
			// cena * liczba
			totalNet = totalNet.add(product.getPrice().multiply(quantity));
		}
		return totalNet;
	}

	public BigDecimal getTaxTotal() {
		// od ceny z podatkiem odjecie bez podatku
		return getGrossTotal().subtract(getNetTotal());
	}

	public BigDecimal getGrossTotal() {
		// cena z podatkiem
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
		}
		return totalGross;
	}

	public Integer getNumber() {
//		Random number = new Random();
//		return number.nextInt(1000);
		return number;

	}
}
