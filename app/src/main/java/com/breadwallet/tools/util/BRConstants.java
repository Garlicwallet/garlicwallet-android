package com.breadwallet.tools.util;

import android.util.Pair;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

import com.breadwallet.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.RoundingMode;

/**
 * BreadWallet
 * <p/>
 * Created by Mihail Gutan <mihail@breadwallet.com> on 2/16/16.
 * Copyright (c) 2016 breadwallet LLC
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

public class BRConstants {

    /**
     * Native library name
     */
    public static final String NATIVE_LIB_NAME = "core-lib";

    /**
     * Permissions
     */
    public static final int CAMERA_REQUEST_ID = 34;
    public static final int GEO_REQUEST_ID = 35;

    /**
     * Request codes for auth
     */
    public static final int SHOW_PHRASE_REQUEST_CODE = 111;
    public static final int PAY_REQUEST_CODE = 112;
    public static final int CANARY_REQUEST_CODE = 113;
    public static final int PUT_PHRASE_NEW_WALLET_REQUEST_CODE = 114;
    public static final int PUT_PHRASE_RECOVERY_WALLET_REQUEST_CODE = 115;
    public static final int PAYMENT_PROTOCOL_REQUEST_CODE = 116;
    public static final int REQUEST_PHRASE_BITID = 117;
    public static final int SEND_BCH_REQUEST = 118;
    public static final int PROVE_PHRASE_REQUEST = 119;

    /**
     * Request codes for take picture
     */
    public static final int SCANNER_REQUEST = 201;
    public static final int SCANNER_BCH_REQUEST = 202; //Unused
    public static final int REQUEST_IMAGE_CAPTURE = 203;

    public static final String CANARY_STRING = "canary";
    public static final String FIRST_ADDRESS = "firstAddress";
    public static final String SECURE_TIME_PREFS = "secureTime";
    public static final String FEE_KB_PREFS = "feeKb";
    public static final String ECONOMY_FEE_KB_PREFS = "EconomyFeeKb";
    public static final String LITTLE_CIRCLE = "\u2022";

    public static String SUPPORT_EMAIL = "support@garlicoinfoundation.zendesk.com";

    public static final int ONE_BITCOIN = 100000000;

    /**
     * BRSharedPrefs
     */
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String RECEIVE_ADDRESS = "receive_address";
    public static final String START_HEIGHT = "startHeight";
    public static final String LAST_BLOCK_HEIGHT = "lastBlockHeight";
    public static final String CURRENT_UNIT = "currencyUnit";
    public static final String CURRENT_CURRENCY = "currentCurrency";
    public static final String POSITION = "position";
    public static final String PHRASE_WRITTEN = "phraseWritten";
    public static final String ALLOW_SPEND = "allowSpend";
    public static final String USER_ID = "userId";
    public static final String GEO_PERMISSIONS_REQUESTED = "geoPermissionsRequested";

    /**
     * Currency units
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({CURRENT_UNIT_PHOTONS, CURRENT_UNIT_LITES, CURRENT_UNIT_GARLICOINS})
    public @interface CurrentUnit {}

    public static final int CURRENT_UNIT_PHOTONS = 0; // formerly CURRENT_UNIT_BITS
    public static final int CURRENT_UNIT_LITES = 1; // formerly CURRENT_UNIT_MBITS
    public static final int CURRENT_UNIT_GARLICOINS = 2;

    public static final String bitcoinLowercase = "\u01E5";
    public static final String bitcoinUppercase = "\u20B2";

    public static boolean PLATFORM_ON = true;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    public static final boolean WAL = true;

    /**
     * Donation
     */
    public static final Pair[] DONATION_ADDRESSES = new Pair[] //TODO
            {
                    Pair.create("Litewallet Hardware Fundraiser", "MJ4W7NZya4SzE7R6xpEVdamGCimaQYPiWu"),
                    Pair.create("Garlicoin Foundation", "MVZj7gBRwcVpa9AAWdJm8A3HqTst112eJe")
            };
    public static final long DONATION_AMOUNT = 1_800_000;

    /**
     * Support Center article ids.
     */
    public static final String receive = "receive-garlicoin";
    public static final String send = "send-garlicoin";
    public static final String loopBug = "android-loop-bug";

    public static final String DISCORD_LINK = "https://discord.gg/vAxFRb5DYe";
    public static final String REDDIT_LINK = "https://www.reddit.com/r/garlicoin";
    public static final String WEB_LINK = "https://garlicwallet.com";
    public static final String TOS_LINK = "https://garlicwallet.com/privacy";
    public static String CUSTOMER_SUPPORT_LINK = "https://garlicoinfoundation.zendesk.com";

    public static final String BLOCK_EXPLORER_BASE_URL = BuildConfig.LITECOIN_TESTNET ? "https://garli.co.in/tx/" : "https://garli.co.in/tx/";

    private BRConstants() {
    }


    public static final String _20191105_AL = "APP_LAUNCHED";
    public static final String _20191105_VSC = "VISIT_SEND_CONTROLLER";
    public static final String _20202116_VRC = "VISIT_RECEIVE_CONTROLLER";
    public static final String _20191105_DSL = "DID_SEND_GRLC";
    public static final String _20191105_DULP = "DID_UPDATE_GRLC_PRICE";
    public static final String _20191105_DTBT = "DID_TAP_BUY_TAB";
    public static final String _20200111_DEDG = "DID_ENTER_DISPATCH_GROUP";
    public static final String _20200111_DLDG = "DID_LEAVE_DISPATCH_GROUP";
    public static final String _20200111_RNI = "RATE_NOT_INITIALIZED";
    public static final String _20200111_FNI = "FEEPERKB_NOT_INITIALIZED";
    public static final String _20200111_TNI = "TRANSACTION_NOT_INITIALIZED";
    public static final String _20200111_WNI = "WALLET_NOT_INITIALIZED";
    public static final String _20200111_PNI = "PHRASE_NOT_INITIALIZED";
    public static final String _20200111_UTST = "UNABLE_TO_SIGN_TRANSACTION";
    public static final String _20200112_ERR = "ERROR";
    public static final String _20200112_DSR = "DID_START_RESYNC";
    public static final String _20200125_DSRR = "DID_SHOW_REVIEW_REQUEST";
    public static final String _20200217_DLWP = "DID_LOGIN_WITH_PIN";
    public static final String _20200217_DLWB = "DID_LOGIN_WITH_BIOMETRICS";
    public static final String _20200223_DD = "DID_DONATE";
    public static final String _20200225_DCD = "DID_CANCEL_DONATE";
    public static final String _20200301_DUDFPK = "DID_USE_DEFAULT_FEE_PER_KB";
    public static final String _20201121_SIL = "STARTED_IFPS_LOOKUP";
    public static final String _20201121_DRIA = "DID_RESOLVE_IPFS_ADDRESS";
    public static final String _20201121_FRIA = "FAILED_RESOLVE_IPFS_ADDRESS";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({_20191105_AL, _20191105_VSC, _20202116_VRC, _20191105_DSL, _20191105_DULP,
            _20191105_DTBT, _20200111_DEDG, _20200111_DLDG, _20200111_RNI, _20200111_FNI,
            _20200111_TNI, _20200111_WNI, _20200111_PNI, _20200111_UTST, _20200112_ERR, _20200112_DSR,
            _20200125_DSRR, _20200217_DLWP, _20200217_DLWB, _20200223_DD, _20200225_DCD, _20200301_DUDFPK,
            _20201121_SIL, _20201121_DRIA, _20201121_FRIA})
    public @interface Event {
    }


    /**
     * Analytics keys
     */

    public static final String START_TIME = "start_time";
    public static final String SUCCESS_TIME = "success_time";
    public static final String FAILURE_TIME = "failure_time";
    public static final String ERROR = "error";
}
