package ru.nika2512.globalmarket.model.forge;

import java.util.List;

/**
 * TODO: add doc!
 */
public class ForgeResponse {
    public final List<ForgeCurrencyInfo> currencyInfoList;

    public ForgeResponse(List<ForgeCurrencyInfo> currencyInfoList) {
        this.currencyInfoList = currencyInfoList;
    }
}
