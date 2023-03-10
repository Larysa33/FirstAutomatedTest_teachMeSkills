package by.teachmeskills.hometask13;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/*Вычислить сумму налога по прогрессивной шкале в зависимости от полученного заработка: 13% на доход до 10 000,
20% на доход от 10 000 до 50 000, 30% на доход выше 50 000.
Метод должен принимать сумму оплаты труда, а возвращать сумму налога.*/
public class TaxTest {
    public static final double LOWEST_PERCENT = 0.13;
    public static final double MEDIUM_PERCENT = 0.20;
    public static final double HIGHEST_PERCENT = 0.30;

    public double countTax(double salary) {
        double tax;
        if (salary < 10000) {
            tax = salary * LOWEST_PERCENT;
        } else if (salary >= 10000 && salary <= 50000) {
            tax = salary * MEDIUM_PERCENT;
        } else {
            tax = salary * HIGHEST_PERCENT;
        }
        System.out.println("Процент от Вашей зарплаты составляет: " + tax);
        return tax;
    }

    @Test(dataProvider = "incomeProvider")
    public void CountTaxTest(int salary, double expPercent) {
        Assert.assertEquals(countTax(salary), expPercent * salary, String.format("Налог для зарплаты %s должен быть = %s", salary, expPercent));
    }

    @DataProvider
    public Object[][] incomeProvider() {
        return new Object[][]{
                {0, 0},
                {9999, 0.13},
                {10000, 0.2},
                {49999, 0.2},
                {50000, 0.3}
        };
    }
}
