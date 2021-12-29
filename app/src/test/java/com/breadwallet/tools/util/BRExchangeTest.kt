package com.breadwallet.tools.util

import com.breadwallet.presenter.entities.CurrencyEntity
import com.breadwallet.tools.sqlite.CurrencyDataSource
import com.breadwallet.wallet.BRWalletManager
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class BRExchangeTest {

    private val rates = mock<CurrencyDataSource>()
    private val walletManager = mock<BRWalletManager>()

    @Test
    fun `get max amount in sats should be 69000000 for grlc`() {
        val exchange = BRExchange(rates, walletManager)

        assertEquals(69000000.toBigDecimal(), exchange.getMaxAmount("grlc"))
    }

    @Test
    fun `test exchange rates applied correctly when getting max`() {
        val exchange = BRExchange(rates, walletManager)

        whenever(rates.getCurrencyByIso(any())).thenReturn(CurrencyEntity("USD", "United States Dollar", "11"))

        assertEquals((69000000 * 11).toBigDecimal(), exchange.getMaxAmount("usd"))
    }

    @Test
    fun testSatoshisToGarlicoin() {
        val exchange = BRExchange(rates, walletManager)
        assertEquals(1.toBigDecimal(), exchange.satoshisToGarlicoin(100000000.toBigDecimal()))
    }

    @Test
    fun testGarlicoinToSatoshis() {
        val exchange = BRExchange(rates, walletManager)
        assertEquals(100000000.toBigDecimal(), exchange.garlicoinToSatoshis(1.toBigDecimal()))
    }

    @Test
    fun testGetBitcoinSymbol() {
        val exchange = BRExchange(rates, walletManager)
        assertEquals(BRConstants.bitcoinUppercase, exchange.bitcoinSymbol)
    }

    @Test
    fun testGetAmountInLocalCurrency() {
        val exchange = BRExchange(rates, walletManager)

        whenever(rates.getCurrencyByIso(any())).thenReturn(CurrencyEntity("USD", "United States Dollar", "11"))

        assertEquals(11.toBigDecimal(), exchange.garlicoinToLocalValue("usd", 1.toBigDecimal()))
    }

    @Test
    fun testGetSatoshisFromAmount() {
        val exchange = BRExchange(rates, walletManager)

        whenever(rates.getCurrencyByIso(any())).thenReturn(CurrencyEntity("USD", "United States Dollar", "11"))

        assertEquals(1.toBigDecimal(), exchange.localValueToGarlicoin("usd", 11.toBigDecimal()))
    }

    private fun assertEquals(a: BigDecimal, b: BigDecimal): Boolean {
        return a.compareTo(b) == 0

    }
}