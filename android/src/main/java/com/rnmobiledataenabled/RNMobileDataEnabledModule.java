package com.rnmobiledataenabled;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import com.rnmobiledataenabled.NativeMobileDataEnabledSpec;

import android.provider.Settings;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import android.net.ConnectivityManager;
import java.lang.reflect.Method;

public class RNMobileDataEnabledModule extends NativeMobileDataEnabledSpec {

    public static String NAME = "RNMobileDataEnabled";
    private boolean mobileYN;

    RNMobileDataEnabledModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public void isEnabled(Promise promise) {
        boolean enabled = false;
        ConnectivityManager cm = (ConnectivityManager) getReactApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true);            
            enabled = (Boolean) method.invoke(cm);
        } catch (Exception e) {
        }
        promise.resolve(enabled);
    }
}