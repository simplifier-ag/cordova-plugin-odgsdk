package com.osterhoutgroup.sdk;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.view.InputDevice;

import com.osterhoutgroup.api.ext.OdgHardwareExt;


public class ODG extends CordovaPlugin {
    private static String TAG = ODG.class.getSimpleName();

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if(action.equals("setMouseInput")){
            return setMouseInput(callbackContext);
        } else if(action.equals("setTrackballInput")){
            return setTrackballInput(callbackContext);
        } else {
            return false;
        }
    }

    private boolean setMouseInput(CallbackContext callbackContext){
        return setInputMode(InputDevice.SOURCE_MOUSE, callbackContext);
    }

    private boolean setTrackballInput(CallbackContext callbackContext){
        return setInputMode(InputDevice.SOURCE_TRACKBALL, callbackContext);
    }

    private boolean setInputMode(int mode, CallbackContext callbackContext){
        try{
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            int input = odghardware.getTrackpadMode();
            Log.d(TAG, "Before Change: " + input);

            odghardware.setTrackpadMode(mode);

            input = odghardware.getTrackpadMode();
            Log.d(TAG, "After Change: " + input);
            callbackContext.success();
            return true;
        }catch(Exception e){
            Log.e(TAG, "Error setting input mode", e);
            callbackContext.error(e.toString());
            return false;
        }
    }
}
