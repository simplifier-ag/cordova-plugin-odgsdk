/*global cordova, module*/

module.exports = {
    setMouseInput: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ODG", "setMouseInput", null);
    },
    setTrackballInput: function(successCallback, errorCallback){
        cordova.exec(successCallback, errorCallback, "ODG", "setTrackballInput", null);
    }
};