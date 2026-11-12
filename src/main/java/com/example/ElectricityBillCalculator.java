
package com.example;

import java.util.Scanner;

public class ElectricityBillCalculator {

    public double calculateBill(int units) {

        if (units < 0) {
            throw new IllegalArgumentException("Invalid units");
        }

        double bill = 0;

        if (units <= 100) {
            bill = units * 1.50;
        }
        else if (units <= 200) {
            bill = (100 * 1.50) + (units - 100) * 2.50;
        }
        else if (units <= 500) {
            bill = (100 * 1.50) + (100 * 2.50)
                    + (units - 200) * 4.00;
        }
        else {
            bill = (100 * 1.50) + (100 * 2.50)
                    + (300 * 4.00) + (units - 500) * 6.00;
        }

        return bill;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter electricity units consumed: ");
        int units = sc.nextInt();

        ElectricityBillCalculator obj =
                new ElectricityBillCalculator();

        try {
            double bill = obj.calculateBill(units);

            System.out.println("Units consumed: " + units);
            System.out.println("Total Electricity Bill: Rs. " + bill);

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}