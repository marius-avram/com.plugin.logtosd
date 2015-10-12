package com.plugin.logtosd;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.os.Environment;
import java.io.File;
import java.lang.Runtime;
import java.io.IOException;

public class LogToSd extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("start")) {
            String filename = data.getString(0);
            String fullpath = Environment.getExternalStorageDirectory() + "/" + filename;

            try {
                File file = new File(fullpath);
                file.createNewFile();
                System.out.println("absolutePath=" + file.getAbsolutePath());
                String cmd = "logcat -f " + file.getAbsolutePath();
                Runtime.getRuntime().exec(cmd);
                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
