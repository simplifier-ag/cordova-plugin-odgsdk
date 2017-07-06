/*global cordova, module*/

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