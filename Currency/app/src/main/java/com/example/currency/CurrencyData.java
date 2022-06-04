package com.example.currency;

public class CurrencyData {
    public static Currency[] getCurrency(){
        Currency usa = new Currency("Đô la Mỹ", 1);
        Currency vnd = new Currency("Việt Nam Đồng", 23191);
        Currency eur = new Currency("Euro", 0.9328f);
        Currency jpy = new Currency("Yên Nhật", 130.875f);
        Currency gbp = new Currency("Bảng Anh", 0.8f);
        Currency aud = new Currency("Đô la New Zealand", 1.387f);

        return new Currency[] {usa, vnd, eur, jpy, gbp, aud};
    }
}
