package com.breadwallet.presenter.activities.util;

import com.breadwallet.presenter.entities.TxItem;

import java.util.Date;

public class ScreenshotUtil {
    private static final String[] REDACTED_ADDRESS = new String[]{"G●●●●●●●●●●●●●●●●●●●●"};

    public static final TxItem[] SCREENSHOT_TRANSACTIONS = new TxItem[]{
            makeFakeTxForScreenshots(new Date(2021-1900,3,20), 9000),
            makeFakeTxForScreenshots(new Date(2020-1900,0,8), -69),
            makeFakeTxForScreenshots(new Date(2018-1900,1,20), 420),
            makeFakeTxForScreenshots(new Date(2018-1900,7,2), -420),
            makeFakeTxForScreenshots(new Date(2018-1900,1,20), -420),
            makeFakeTxForScreenshots(new Date(2018-1900,1,16), 42069)
    };

    private static TxItem makeFakeTxForScreenshots(Date date, int amount){
        long sent = amount < 0 ? Math.abs(amount) * 100000000L : 0;
        long received = amount > 0 ? amount * 100000000L : 0;
        return new TxItem(date.getTime()/1000, 3,  new byte[16], "",
                sent, received, 0, REDACTED_ADDRESS, REDACTED_ADDRESS, 12,
                10, new long[]{}, true);
    }
}
