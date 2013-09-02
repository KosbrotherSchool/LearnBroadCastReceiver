package com.example.learnbroadcastreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	public static final String ACTION_SHOW_DIALOG = "com.example.learnbroadcastreceiver.showdialog";
	private Button sendButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendButton = (Button) findViewById (R.id.button_send);
	    
	    sendButton.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent();
        	    intent.setAction(ACTION_SHOW_DIALOG);
        	    sendBroadcast(intent);
        	    finish();
            }         
        });
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onResume() {
	    super.onResume();
	    
	    Intent mIntent = getIntent();
	    if (mIntent.getAction().equals(ACTION_SHOW_DIALOG)){
	    	new AlertDialog.Builder(MainActivity.this)
            .setMessage("收到訊息!")
            .setPositiveButton("確定", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                   
                }
            })
            .show();
	    }
	}
	
}
