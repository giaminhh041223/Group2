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
        return action;
    }
}
