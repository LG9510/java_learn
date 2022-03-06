package com.baeldung.maths;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static BigDecimal calculateTotalAmount(BigDecimal quantity,
                                                  BigDecimal unitPrice, BigDecimal discountRate, BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        BigDecimal discount = amount.multiply(discountRate);
        BigDecimal discountAmount = amount.subtract(discount);
        BigDecimal tax = discountAmount.multiply(taxRate);
        BigDecimal total = discountAmount.add(tax);

        BigDecimal roundTotal = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);

        return roundTotal;
    }
}
