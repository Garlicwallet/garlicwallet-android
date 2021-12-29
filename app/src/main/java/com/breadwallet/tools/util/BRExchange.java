package com.breadwallet.tools.util;

import com.breadwallet.presenter.entities.CurrencyEntity;
import com.breadwallet.tools.sqlite.CurrencyDataSource;

import java.math.BigDecimal;

import javax.inject.Inject;

import static com.breadwallet.tools.util.BRConstants.ROUNDING_MODE;

/**
 * BreadWallet
 * <p/>
 * Created by Mihail Gutan on <mihail@breadwallet.com> 3/23/17.
 * Copyright (c) 2017 breadwallet LLC
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
public class BRExchange {
    private final CurrencyDataSource currencyDataSource;
    private static final long MAX_GRLC = 69000000;
    private static final long SAT_PER_GRLC = 100000000;

    @Inject public BRExchange(CurrencyDataSource currencyDataSource) {
        this.currencyDataSource = currencyDataSource;
    }

    public BigDecimal getMaxAmount(String currencyISOCode) {

        return garlicoinToLocalValue(currencyISOCode, BigDecimal.valueOf(MAX_GRLC));
    }

    // amount in satoshis
    public BigDecimal satoshisToGarlicoin(BigDecimal amount) {
        return new BigDecimal(String.valueOf(amount))
                .divide(new BigDecimal(SAT_PER_GRLC), 8, ROUNDING_MODE);
    }

    public BigDecimal garlicoinToSatoshis(BigDecimal amount) {
        return new BigDecimal(String.valueOf(amount)).multiply(new BigDecimal(SAT_PER_GRLC));
    }

    public String getBitcoinSymbol() {
        return BRConstants.bitcoinUppercase;
    }

    /**
     * Returns the value in a given currency for a given amount of Garlicoin
     * @param iso the currency to return a value for
     * @param garlicoin the amount in GRLC
     */
    public BigDecimal garlicoinToLocalValue(String iso, BigDecimal garlicoin) {
        if (iso.equalsIgnoreCase("GRLC")) {
            return garlicoin; // 1 GRLC = 1 GRLC
        } else {
            CurrencyEntity ent = currencyDataSource.getCurrencyByIso(iso);
            if (ent == null) return new BigDecimal(0);
            return ent.rate.multiply(garlicoin);
        }
    }

    /**
     * Returns the garlicoin value for a given amount of local currency
     * @param iso the currency selected
     * @param amount the amount in local currency
     */
    public  BigDecimal localValueToGarlicoin(String iso, BigDecimal amount) {
        if (iso.equalsIgnoreCase("GRLC")) {
            return amount;  // 1 GRLC = 1 GRLC
        } else {
            CurrencyEntity ent = currencyDataSource.getCurrencyByIso(iso);
            if (ent == null) return new BigDecimal(0);
            return amount.divide(amount, BigDecimal.ROUND_HALF_UP);
        }
    }
}
