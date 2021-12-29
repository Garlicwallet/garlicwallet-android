package com.breadwallet.di.component

import com.breadwallet.BreadApp
import com.breadwallet.di.module.AppModule
import com.breadwallet.presenter.activities.BreadActivity
import com.breadwallet.presenter.activities.util.BRActivity
import com.breadwallet.presenter.fragments.FragmentRequestAmount
import com.breadwallet.presenter.fragments.FragmentSend
import com.breadwallet.presenter.fragments.FragmentTransactionItem
import com.breadwallet.tools.adapter.TransactionListAdapter
import com.breadwallet.tools.security.BRSender
import com.breadwallet.tools.threads.ImportPrivKeyTask
import com.breadwallet.tools.threads.PaymentProtocolTask
import dagger.Component
import javax.inject.Singleton

/** Litewallet
 * Created by Mohamed Barry on 6/30/20
 * email: mosadialiou@gmail.com
 * Copyright © 2020 Litecoin Foundation. All rights reserved.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: BreadApp)
    fun inject(fragment: FragmentSend)
    fun inject(activity: BRActivity)
    fun inject(paymentProtocolTask: PaymentProtocolTask)
    fun inject(importPrivKeyTask: ImportPrivKeyTask)
    fun inject(brSender: BRSender)
    fun inject(transactionListAdapter: TransactionListAdapter)
    fun inject(fragmentTransactionItem: FragmentTransactionItem)
    fun inject(fragmentRequestAmount: FragmentRequestAmount)
}
