package History;

import java.util.Calendar;
import Model.Receipt;

public class ReceiptHistory extends Action {
    private Receipt receipt;

    public ReceiptHistory(String action, Calendar date, Receipt receipt) {
        super(action, date);
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Receipt with ID: " + receipt.getID() + " " + action + "d at " + date.getTime();
    }
}
