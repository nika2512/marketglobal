package ru.nika2512.globalmarket.model.forge;

import java.util.List;

/**
 * TODO: add doc!
 */
public class Forge1Response {
    public final List<Forge1CurrencyInfo> currencyInfoList;

    public Forge1Response(List<Forge1CurrencyInfo> currencyInfoList) {
        this.currencyInfoList = currencyInfoList;
    }
}
