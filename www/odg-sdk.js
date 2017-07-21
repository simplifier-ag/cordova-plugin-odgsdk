/*global cordova, module*/

//switch input modes with dedicated input change button
document.addEventListener("keyup", function(evt){
    if((device.model === "R7-W") && (evt.keyIdentifier === "U+0000") && (evt.keyCode === 0)){
        odg.getInputMode(function(result){
            var changeInputSuccess = function(){
                odg.getInputMode(function(result){
                    console.log("Changed input mode to: " + result)
                })
            };

            var changeInputError = function(error){
                console.error(error);
            };

            if(result === "Trackball"){
                odg.setMouseInput(changeInputSuccess, changeInputError)
            } else if(result === "Mouse"){
                odg.setTrackballInput(changeInputSuccess, changeInputError)
            }
        })
    }

}, false);

module.exports = {
    //display modes
    setDisplayBothOff: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayBothOff", null);
    },
    setDisplayBothOn: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayBothOn", null);
    },
    setDisplayLeftOffRightOn: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayLeftOffRightOn", null);
    },
    setDisplayLeftOnRightOff: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayLeftOnRightOff", null);
    },
    getDisplayMode: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "getDisplayMode", null);
    },

    //brightness
    setDisplayBright: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayBright", null);
    },
    setDisplayDim: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setDisplayDim", null);
    },
    getBrightness: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "getBrightness", null);
    },

    //input
    setMouseInput: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setMouseInput", null);
    },
    setTrackballInput: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setTrackballInput", null);
    },
    getInputMode: function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, "ODG", "getInputMode", null);
    }
};