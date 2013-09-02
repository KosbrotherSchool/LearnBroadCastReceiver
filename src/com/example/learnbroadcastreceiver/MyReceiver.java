package com.example.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context mContext, Intent mIntent) {
		// TODO Auto-generated method stub
		if(mIntent.getAction().equals(MainActivity.ACTION_SHOW_DIALOG)){
						
			Intent newIntent = new Intent();
			newIntent.setClassName("com.example.learnbroadcastreceiver", "com.example.learnbroadcastreceiver.MainActivity");
			newIntent.setAction(MainActivity.ACTION_SHOW_DIALOG);
			newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(newIntent);
			
        }
	}
	   
}
