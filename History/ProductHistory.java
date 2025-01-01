package History;

import java.util.Calendar;

import Model.Product;

public class ProductHistory extends Action {
	private String productName;
	private int previousQuantity;
	private int quantityAtAction;
    private double purchasePriceAtAction;

	public ProductHistory(String action, Calendar date, Product product, int previousQuantity) {
		super(action, date);
		this.productName = product.getName();
		this.quantityAtAction = product.getQty();
		this.purchasePriceAtAction = product.getPurchasePrice();
		this.previousQuantity = previousQuantity;
	}

	public String toString() {
        return action + ", " + date.get(Calendar.DAY_OF_MONTH) + "-" + (date.get(Calendar.MONTH) + 1) + "-" + date.get(Calendar.YEAR)
        		+ ", " + productName + ", " + quantityAtAction + ", " + purchasePriceAtAction + ", " + previousQuantity;
	}

	public int getPreviousQuantity() {
		return previousQuantity;
	}

	public int getQuantityAtAction() {
        return quantityAtAction;
    }

	public double getPurchasePriceAtAction() {
        return purchasePriceAtAction;
    }
}