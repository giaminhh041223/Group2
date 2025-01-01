package History;

import java.util.Calendar;

import Model.Product;

public class ProductHistory extends Action {
	private Product product;

	public ProductHistory(String action, Calendar date, Product product) {
		super(action, date);
		this.product=product;
	}

	public String toString() {
		return action;
	}
	
}
 