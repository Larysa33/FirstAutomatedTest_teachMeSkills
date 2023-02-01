package by.teachmeskills.hometask13;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.Scanner;

/*Вычислить сумму налога по прогрессивной шкале в зависимости от полученного заработка: 13% на доход до 10 000,
20% на доход от 10 000 до 50 000, 30% на доход выше 50 000.
Метод должен принимать сумму оплаты труда, а возвращать сумму налога.*/
public class TaxTest {
    public static final double LOWESTPERCENT=0.13;
    public static final double MEDIUMPERCENT=0.20;
    public static final double HIGHESTPERCENT=0.30;
    public double countTax(double salary){
        //Можно ли сюда запихнуть сканер для ввода с консоли? Если раскомитить этот кусок, пишет что для
        //сканера не найдено конструктора
        //Scanner scanner = new Scanner();
        //System.out.println("Введите сумму зп:");
        //double salary = Math.abs(scanner.nextInt());
        double tax;
        if(salary<10000){
            tax=salary*LOWESTPERCENT;
        }else if(salary>=10000&&salary<=50000){
            tax=salary*MEDIUMPERCENT;
        }else{
            tax=salary*HIGHESTPERCENT;
        }
        System.out.println("Процент от Вашей зарплаты составляет: " + tax);
        return tax;
    }

    @Test(dataProvider = "incomeProvider")
    public void testCountTax(int salary, double expPercent) {
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
