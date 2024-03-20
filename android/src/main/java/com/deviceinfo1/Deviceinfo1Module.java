package com.deviceinfo1;

import androidx.annotation.NonNull;
import android.provider.Settings;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.xbh.sdk4.database.DatabaseHelper;
import static com.xbh.middleware.sdkprovider.contentprovider.EnumStringProvider.DEVICE_NAME;



@ReactModule(name = Deviceinfo1Module.NAME)
public class Deviceinfo1Module extends ReactContextBaseJavaModule {
  public static final String NAME = "Deviceinfo1";
  DatabaseHelper databaseHelper;

  public Deviceinfo1Module(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;

  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    //promise.resolve(a * b);
	promise.resolve(a + b);
  }

  @ReactMethod
  public void devicename(Promise promise) {
	databaseHelper = new DatabaseHelper();
	String deviceName;
	ReactApplicationContext reactContext = getReactApplicationContext();

    
	String manufacturer = android.os.Build.MANUFACTURER;
        if (manufacturer.equals("XBHG6780")) //v100
        {
            deviceName = databaseHelper.getStringDataFromProvider(DEVICE_NAME);
        }
        else {
            // For Android versions starting from Oreo (API level 27) and higher
            deviceName = Settings.Global.getString(
                    reactContext.getContentResolver(),
                    Settings.Global.DEVICE_NAME
            );

            // If deviceName is null, you can provide a default value or handle it accordingly
            if (deviceName == null) {
                deviceName = "unknown";
            }
        }

	promise.resolve(deviceName);


  }

}
