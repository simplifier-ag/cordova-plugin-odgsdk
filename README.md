# Cordova Plugin for ODG

Implements the ODG SDK to enable various device depending capabilities.

## Using

### Change Input modes
As default applications will launch with "Mouse/Cursor" input.

#### Trackball (e.g. DPAD)
This will set the input mode to a DPAD-like behavior.

    $ odg.setTrackballInput(successCallback, errorCallback);
    
#### Mouse (e.g. Cursor)
This will set the input mode to mouse and a cursor will be shown

    $ odg.setMouseInput(successCallback, errorCallback);

# More Info

For more information see [ODG Developer Center](https://developer.osterhoutgroup.com)
