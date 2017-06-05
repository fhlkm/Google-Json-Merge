package com.looppay.android.tpd.common.service.push;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/**
 * Created by hanlu.feng on 5/23/2016.
 */
public class GCMOperation {
    private String TAG = "GCMOperation";
    private Context mContext;
    private boolean isReceiverRegistered;
    private BroadcastReceiver commonRegistrationBroadcastReceiver;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static GCMOperation gcmOperation;
    private Activity mActivity;

    private GCMOperation(){
//        mContext = CommonLib.getApplicationContext();
    }

    public Activity getmActivity() {
        return mActivity;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
        mContext = mActivity.getApplicationContext();
    }

    public static GCMOperation getInstance() {
        if(gcmOperation == null){
            gcmOperation = new GCMOperation();

        }
        return gcmOperation;
    }

    public void startCommonGCM() {

        // Registering BroadcastReceiver
//        registerReceiver();

        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(mContext, RegistrationIntentService.class);
            mContext.startService(intent);
        }
    }

    public void unRegisterGCM(){
        RegistrationIntentService.unRegisterToken();
    }
//    private void registerReceiver() {
//        if (!isReceiverRegistered) {
//            LocalBroadcastManager.getInstance(mContext).registerReceiver(commonRegistrationBroadcastReceiver,
//                    new IntentFilter(IntentAction.GCM_REGISTRATION_COMPLETE));
//            isReceiverRegistered = true;
//        }
//    }

    private boolean checkPlayServices() {
//        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//        int resultCode = apiAvailability.isGooglePlayServicesAvailable(mContext);
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (apiAvailability.isUserResolvableError(resultCode)) {
//                if(null != mActivity&& !mActivity.isFinishing()) {
//                    apiAvailability.getErrorDialog(mActivity, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
//                            .show();
//                }else{
//                    Log.i(TAG, apiAvailability.getErrorString(resultCode));
//                }
//            } else {
//                Log.i(TAG, "This device is not supported.");
////                finish();
//            }
//            return false;
//        }
        return true;
    }
}
