package com.tunisair.utils;

import android.content.Context;
import android.content.Intent;

public class CommonUtilities {
	 static String ip = "192.168.1.5";
	
	 static final public String SERVER_URL_GCM = "http://"+ip+"/TunisAIR/include/register.php"; 
	 static final public String SERVER_URL 	= "http://"+ip+"/TunisAIR/Index.php";
	 static final public String SERVER_URL_PN 	= "http://"+ip+"/TunisAIR/progPn.php?tlc=";
	 // Google project id
	 static final public String SENDER_ID = "686049352777"; 
	 static final public String DISPLAY_MESSAGE_ACTION =
	            "com.androidhive.pushnotifications.DISPLAY_MESSAGE";
	    /**
	     * Tag used on log messages.
	     */
	    static final public String TAG = "AndroidHive GCM";

	    

	    static final public String EXTRA_MESSAGE = "message";

	    /**
	     * Notifies UI to display a message.
	     * <p>
	     * This method is defined in the common helper because it's used both by
	     * the UI and the background service.
	     *
	     * @param context application's context.
	     * @param message message to be displayed.
	     */
	    public  static void displayMessage(Context context, String message) {
	        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
	        intent.putExtra(EXTRA_MESSAGE, message);
	        context.sendBroadcast(intent);
	    }
	
}
