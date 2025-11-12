package org.example.myBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class myBigDecimal {
    public static void main(String[] args) {
        BigDecimal op1 = new BigDecimal("10.50");
        BigDecimal op2 = new BigDecimal("110.50");

        BigDecimal result = op2.add(op1);
        System.out.println(result);

        BigDecimal result2 = op2.subtract(op1);
        System.out.println(result2);

        BigDecimal result3 = op2.multiply(op1);
        System.out.println(result3);

        BigDecimal result4 = op2.divide(op1, RoundingMode.HALF_DOWN);
        System.out.println(result4);
    }

}
