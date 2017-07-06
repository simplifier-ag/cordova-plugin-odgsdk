package com.osterhoutgroup.sdk;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.view.InputDevice;

import com.osterhoutgroup.api.ext.OdgHardwareExt;


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
        if (action.equals("setDisplayBothOff")) {
            return setDisplayBothOff(callbackContext);
        } else if (action.equals("setDisplayBothOn")) {
            return setDisplayBothOn(callbackContext);
        } else if (action.equals("setDisplayLeftOffRightOn")) {
            return setDisplayLeftOffRightOn(callbackContext);
        } else if (action.equals("setDisplayLeftOnRightOff")) {
            return setDisplayLeftOnRightOff(callbackContext);
        } else if (action.equals("getDisplayMode")) {
            return getDisplayMode(callbackContext);
        } else if (action.equals("setDisplayBright")) {
            return setDisplayBright(callbackContext);
        } else if (action.equals("setDisplayDim")) {
            return setDisplayDim(callbackContext);
        } else if (action.equals("getBrightness")) {
            return getBrightness(callbackContext);
        } else if (action.equals("setMouseInput")) {
            return setMouseInput(callbackContext);
        } else if (action.equals("setTrackballInput")) {
            return setTrackballInput(callbackContext);
        } else if (action.equals("getInputMode")) {
            return getInputMode(callbackContext);
        } else {
            return false;
        }
    }

    private boolean setDisplayBothOff(CallbackContext callbackContext) {
        return setDualDisplay(OdgHardwareExt.DISPLAY_BOTH_OFF, callbackContext);
    }

    private boolean setDisplayBothOn(CallbackContext callbackContext) {
        return setDualDisplay(OdgHardwareExt.DISPLAY_BOTH_ON, callbackContext);
    }

    private boolean setDisplayLeftOffRightOn(CallbackContext callbackContext) {
        return setDualDisplay(OdgHardwareExt.DISPLAY_LEFT_OFF_RIGHT_ON, callbackContext);
    }

    private boolean setDisplayLeftOnRightOff(CallbackContext callbackContext) {
        return setDualDisplay(OdgHardwareExt.DISPLAY_LEFT_ON_RIGHT_OFF, callbackContext);
    }

    private boolean setDualDisplay(int display, CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            odghardware.setDualDisplay(display);
            callbackContext.success();
            return true;
        } catch (Exception e) {
            callbackContext.error(e.toString());
            Log.e(TAG, "", e);
            return false;
        }
    }

    private boolean getDisplayMode(CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            int mode = odghardware.getDualDisplay();
            String result;
            switch (mode) {
                case OdgHardwareExt.DISPLAY_BOTH_OFF:
                    result = "BOTH_OFF";
                    break;
                case OdgHardwareExt.DISPLAY_BOTH_ON:
                    result = "BOTH_ON";
                    break;
                case OdgHardwareExt.DISPLAY_LEFT_OFF_RIGHT_ON:
                    result = "LEFT_OFF_RIGHT_ON";
                    break;
                case OdgHardwareExt.DISPLAY_LEFT_ON_RIGHT_OFF:
                    result = "LEFT_ON_RIGHT_OFF";
                    break;
                default:
                    result = "unknown";
            }
            callbackContext.success(result);
            return true;
        } catch (Exception e) {
            callbackContext.error(e.toString());
            Log.e(TAG, "", e);
            return false;
        }
    }

    private boolean setDisplayBright(CallbackContext callbackContext) {
        return setBrightnessLevel(OdgHardwareExt.BRIGHTNESS_LEVEL_BRIGHT, callbackContext);
    }

    private boolean setDisplayDim(CallbackContext callbackContext) {
        return setBrightnessLevel(OdgHardwareExt.BRIGHTNESS_LEVEL_DIM, callbackContext);
    }

    private boolean setBrightnessLevel(int level, CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            odghardware.setBrightnessLevel(level);
            callbackContext.success();
            return true;
        } catch (Exception e) {
            callbackContext.error(e.toString());
            Log.e(TAG, "", e);
            return false;
        }
    }

    private boolean getBrightness(CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            int level = odghardware.getBrightnessLevel();
            String result;
            switch (level) {
                case OdgHardwareExt.BRIGHTNESS_LEVEL_BRIGHT:
                    result = "Bright";
                    break;
                case OdgHardwareExt.BRIGHTNESS_LEVEL_DIM:
                    result = "Dim";
                    break;
                default:
                    result = "unknown";
            }
            callbackContext.success(result);
            return true;
        } catch (Exception e) {
            callbackContext.error(e.toString());
            Log.e(TAG, "", e);
            return false;
        }
    }

    private boolean getInputMode(CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            int mode = odghardware.getTrackpadMode();
            if (mode == InputDevice.SOURCE_TRACKBALL) {
                callbackContext.success("Trackball");
            } else if (mode == InputDevice.SOURCE_MOUSE) {
                callbackContext.success("Mouse");
            }
            return true;
        } catch (Exception e) {
            callbackContext.error(e.toString());
            Log.e(TAG, "", e);
            return false;
        }
    }

    private boolean setMouseInput(CallbackContext callbackContext) {
        return setInputMode(InputDevice.SOURCE_MOUSE, callbackContext);
    }

    private boolean setTrackballInput(CallbackContext callbackContext) {
        return setInputMode(InputDevice.SOURCE_TRACKBALL, callbackContext);
    }

    private boolean setInputMode(int mode, CallbackContext callbackContext) {
        try {
            OdgHardwareExt odghardware = new OdgHardwareExt(cordova.getActivity());
            odghardware.setTrackpadMode(mode);
            callbackContext.success();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error setting input mode", e);
            callbackContext.error(e.toString());
            return false;
        }
    }
}
