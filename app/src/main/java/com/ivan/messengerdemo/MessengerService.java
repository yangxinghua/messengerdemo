package com.ivan.messengerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ivan on 6/23/16.
 */
public class MessengerService extends Service {
    private static final String TAG = "MessengerService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MainActivity.MSG_FROM_CLIENT:
                    Log.d(TAG, msg.getData().getString("client"));
                    break;
            }
        }
    }

    private Messenger mMessenger = new Messenger(new MessengerHandler());
}
