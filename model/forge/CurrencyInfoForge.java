package ru.nika2512.globalmarket.model.forge;

/**
 * Модель данных с forge1 хранящая информацию о валютной пары
 */
public class ForgeCurrencyInfo {
    public final String symbol;
    public final double bid;
    public final double ask;
    public final double price;
    public final long timestamp;

    public ForgeCurrencyInfo(String symbol, double bid, double ask, double price, long timestamp) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        this.price = price;
        this.timestamp = timestamp;
    }
}
