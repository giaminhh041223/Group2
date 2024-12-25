package History;

import java.util.Calendar;

import Model.Product;

public class ProductHistory extends Action {
	private Product product;
	public ProductHistory(String action, Calendar date, Product product) {
		super(action, date);
		this.product=product;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		if (action=="add") {
			return "product "+ product.getName()+" "+action+"ed at "+date.getTime();
		}else if (action=="remove") {
			return "product "+ product.getName()+" "+action+"ed at "+date.getTime();
		}else {
			return "product "+ product.getName()+" "+" sold at "+date.getTime();
		}
	}
	
}
 