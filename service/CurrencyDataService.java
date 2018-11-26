package ru.nika2512.globalmarket.service;

import ru.nika2512.globalmarket.model.CurrencyNominal;

import java.time.LocalDate;

/**
 * Класс для получения данных о валюте
 */
public interface CurrencyDataSource {

    /**
     * Метод возвращает информацию о валюте за указанную дату
     */
    CurrencyNominal getCurrencyNominalByDate(LocalDate date) throws Exception;
}
