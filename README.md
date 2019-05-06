# Cordova Plugin for ODG

Wraps the ODG SDK to enable various device depending capabilities with cordova.

## Using
Install plugin

    $ cordova plugin add https://github.com/simplifier-ag/cordova-plugin-odgsdk.git

### Input
As default applications will launch with "Mouse/Cursor" input.

#### Trackball (e.g. DPAD)
Sets the input mode to a DPAD-like behavior.

    $ odg.setTrackballInput(successCallback, errorCallback);
    
#### Mouse (e.g. Cursor)
Sets the input mode to mouse and a cursor will be shown

    $ odg.setMouseInput(successCallback, errorCallback);
    
#### Get Input Mode
Returns active input mode as string

    $ odg.getInputMode(successCallback, errorCallback);
    
Return values in success callback:

    "Mouse" - Input mode is Mouse/Cursor 
    
    "Trackball" - Input mode is DPAD/Trackball
    
    
### Display Modes
Changes settings regarding the display

#### Both Displays off
Disables both displays

    $ odg.setDisplayBothOff(successCallback, errorCallback);
    
#### Both Displays on
Enables both displays

    $ odg.setDisplayBothOn(successCallback, errorCallback);
    
#### Turn Left Display off and Right Display on
Turn off the left display and leaves the right one on

    $ odg.setDisplayLeftOffRightOn(successCallback, errorCallback);
    
#### Turn Left Display on and Right Display off
Turn on the left display and leaves the right one off

    $ odg.setDisplayLeftOnRightOff(successCallback, errorCallback);

#### Get Display mode
Returns active display mode

    $ odg.getDisplayMode(successCallback, errorCallback);
    
Return values is success callback:

    "BOTH_OFF" - both displays are off 
    "BOTH_ON" - both displays are on
    "LEFT_OFF_RIGHT_ON" - left display is off, right is on 
    "LEFT_ON_RIGHT_OFF" - left display is on, right is off 
    "unknown" - value could not be resolved (unlikely)

### Display Brightness
Changes display brightness

#### Set Display Bright
Brightens up display
 
    $ odg.setDisplayBright(successCallback, errorCallback);

#### Set Display Dim
Dims down display

**WARNING: DIMMING THE DISPLAY CANNOT BE REVERTED VIA API DUE TO A BUG IN THE ODG SDK!
TO REVERT TO BRIGHT USE CONTEXT MENU!**
 
    $ odg.setDisplayDim(successCallback, errorCallback);
    
#### Get Brightness
Returns brightness mode

    $ odg.getBrightness(successCallback, errorCallback);
    
Return values is success callback:

    "Bright" - display is bright 
    "Dim" - display is dim
    "unknown" - value could not be evaluated 

# More Info

For more information see [ODG Developer Center](https://developer.osterhoutgroup.com)

Update: ODG does not exist anymore.