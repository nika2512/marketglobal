package ru.nika2512.globalmarket.service;

import ru.nika2512.globalmarket.model.Currency;
import ru.nika2512.globalmarket.model.CurrencyNominal;
import ru.nika2512.globalmarket.model.Money;

import java.time.LocalDate;

/**
 * Класс для конвертации денег из одной валюты в другую
 */
public class CurrencyService {

    private final String pathToFiles;

    public CurrencyService(String pathToFiles) {
        this.pathToFiles = pathToFiles;
    }

    /**
     * Функция обменевает заданную сумму денег в одной валюте на другую валюту за указанную дату
     */
    public Money exchangeMoneyСurrencyByDate(Money money, Currency convertToCurrency, LocalDate date) throws Exception {
        CurrencyNominal currencyNominal;

        FileDataSource fileDataSource = new FileDataSource(pathToFiles);

        //проверяем есть ли файл с информацией о валюте
        if (fileDataSource.isFileWithCurrencyExists(date)) {
            currencyNominal = fileDataSource.getCurrencyNominalByDate(date);
        } else {
            //если файла нет то получаем его из внешнего источника
            Forge1DataSource forge1DataSource = new Forge1DataSource();
            currencyNominal = forge1DataSource.getCurrencyNominalByDate(date);

            //сохраняем данные в файл
            fileDataSource.saveCurrencyNominal(date, currencyNominal);
        }

        CurrencyConverter converter = new CurrencyConverter(currencyNominal);

        return converter.transformMoneyCurrency(money, convertToCurrency);
    }
