package com.androidbigguy.easyandroid.versionchecklib.core;

import android.content.Intent;
import android.os.IBinder;

public class MyService extends AVersionService {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onResponses(AVersionService service, String response) {

    }
}