# Cordova LogToSD Plugin

Simple plugin that saves the logcat of your app into a file located in the internal storage parent directory of your Android device.
Currently plugin supports only Android.

Example output file location:

/internal-storage/log.txt

File is overwritten after an app relaunch.

Can be useful for debugging nasty bugs when your phone is not connected via USB.


## Using
Clone the plugin

    $ git clone https://github.com/marius-avram/com.plugin.logtosd.git
    
Install the plugin

    $ cd hello
    $ cordova plugin add ../com.plugin.logtosd
    

Edit `www/js/index.js` and add the following code inside `onDeviceReady`

```js
    var success = function() {
        console.log("LogToSD succesfully started");
    }

    var failure = function() {
        console.log("Error while calling LogToSD");
    }
    
    // First parameter is the name of the log file
    logtosd.start("log.txt", success, failure);
```
    
Run the code

    cordova run 

## More Info

For more information on setting up Cordova see [the documentation](http://cordova.apache.org/docs/en/4.0.0/guide_cli_index.md.html#The%20Command-Line%20Interface)

For more info on plugins see the [Plugin Development Guide](http://cordova.apache.org/docs/en/4.0.0/guide_hybrid_plugins_index.md.html#Plugin%20Development%20Guide)
