package fr.quickfix.androidfoldersplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Environment;


public class AndroidFoldersPlugin extends CordovaPlugin {
	public CallbackContext callbackContext;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		if (action.equals("getDirectories")) {
			getDirectories();
			return true;
		}
		return false;
	}

	private void getDirectories(){
		JSONObject ret = new JSONObject();
		String[] directories={Environment.DIRECTORY_DCIM,Environment.DIRECTORY_DOCUMENTS,Environment.DIRECTORY_DOWNLOADS,
				Environment.DIRECTORY_MOVIES,Environment.DIRECTORY_MUSIC,Environment.DIRECTORY_NOTIFICATIONS,
				Environment.DIRECTORY_PICTURES,Environment.DIRECTORY_PODCASTS,Environment.DIRECTORY_RINGTONES};
		try{
			for (String dir: directories) {
				ret.putOpt(dir,Environment.getExternalStoragePublicDirectory(dir));
			}
			this.callbackContext.success(ret);
		}
		catch (Exception e){
			this.callbackContext.error(e.getMessage());
		}
	}


}