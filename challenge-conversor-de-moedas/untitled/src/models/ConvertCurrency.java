package models;

import java.text.DecimalFormat;

public class ConvertCurrency {
    private String base;
    private String target;
    private double conversion;
    private double amountBase;

    public ConvertCurrency(Exchange exchange, double amountBase) {
        this.base = exchange.base_code();
        this.target = exchange.target_code();
        this.conversion = exchange.conversion_result();
        this.amountBase = amountBase;
    }

    public ConvertCurrency() {
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");

        return "Valor " + df.format(amountBase) + " [" + base + "] corresponde ao valor final de => "
                + df.format(conversion) + " [" + target + "]";
    }
}
