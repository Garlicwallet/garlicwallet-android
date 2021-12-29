package com.breadwallet.di.module

import com.breadwallet.BreadApp
import com.breadwallet.tools.util.BRCurrency
import com.breadwallet.tools.util.BRExchange
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/** Litewallet
 * Created by Mohamed Barry on 6/30/20
 * email: mosadialiou@gmail.com
 * Copyright © 2020 Litecoin Foundation. All rights reserved.
 */
@Module
class AppModule(val app: BreadApp) {

    @Provides
    @Singleton
    fun provideApplication() = app

    @Provides
    @Singleton
    fun provideBRExchange(app: BreadApp): BRExchange {
        return BRExchange(app)
    }

    @Provides
    @Singleton
    fun provideBRCurrency(app: BreadApp, brExchange:BRExchange): BRCurrency {
        return BRCurrency(app, brExchange)
    }
}
