/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.looppay.android.tpd.common.service.push;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MyGcmListenerService extends FirebaseMessagingService {

    private static final String TAG = "MyGcmListenerService";

    /**
     * Called when message is received.
     *
     */

    @Override
    public void onMessageReceived(RemoteMessage message2){
        String from = message2.getFrom();
        Map data = message2.getData();

        if (data == null) {
            return;
        }
        String message = (String)data.get("message");
        Log.d(TAG, "From: " + from);
        Log.d(TAG, "Message: " + message);
        if (null == message) {
//            String title =(String) data.get("gcm.notification.title");
//            String body =(String) data.get("gcm.notification.body");
            String title = message2.getNotification().getTitle();
            String body = message2.getNotification().getBody();

            JSONObject msgJSON = new JSONObject();
            try {
                msgJSON.put("body", body);
                msgJSON.put("title", title);
//                CommonLib.handleWebPushMessage(msgJSON.toString());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
//        CommonLib.handleWebPushMessage(message);
    }

    // [START receive_message]
//    @Override
//    public void onMessageReceived(String from, Bundle data) {
//        if (data == null) {
//            return;
//        }
//        String message = data.getString("message");
//        Log.d(TAG, "From: " + from);
//        Log.d(TAG, "Message: " + message);
//        if (null == message) {
//            String title = data.getString("gcm.notification.title");
//            String body = data.getString("gcm.notification.body");
//            JSONObject msgJSON = new JSONObject();
//            try {
//                msgJSON.put("body", body);
//                msgJSON.put("title", title);
//                CommonLib.handleWebPushMessage(msgJSON.toString());
//                return;
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        CommonLib.handleWebPushMessage(message);
//    }

}
