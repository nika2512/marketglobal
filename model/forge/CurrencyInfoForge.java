package ru.nika2512.globalmarket;

import ru.nika2512.globalmarket.model.Currency;
import ru.nika2512.globalmarket.model.Money;
import ru.nika2512.globalmarket.service.CurrencyService;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Клиентское приложение
 */
public class App {
    public static void main(String[] args) throws Exception {

        //получаем абсолютный путь текущей дирректории
        String currentFilePath = Paths.get("").toAbsolutePath().toString();

        //создаем сервис по работе с валютой
        CurrencyService currencyService = new CurrencyService(currentFilePath);

        Money myMoney = new Money(1, Currency.USD);

        //берем текущую датту
        LocalDate localDate = LocalDate.now();
        //преобразуем дату в строку для удобства вывода
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = localDate.format(dateTimeFormatter);

        //конвертируем деньги в другую валюту
        Money exchangedMoney = currencyService.exchangeMoneyСurrencyByDate(myMoney, Currency.RUB, localDate);

        //выводим результат на экра
        System.out.println("Date: " + dateString + " product costs: " + exchangedMoney);
    }
}
