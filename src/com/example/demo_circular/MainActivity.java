package com.example.demo_circular;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnTouchListener{

	ProgressBar circleview;
	float X, Y;
	private AudioManager audioManager;
	int maxVolume ,curVolume;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("progressbar", "getting the volume");
		circleview = (ProgressBar)findViewById(R.id.progressBar1);
		audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		circleview.setMax(maxVolume);
		
		circleview.setProgress(curVolume);
		
		
		// by using touch events we are controlling the progress bar
		circleview.setOnTouchListener(new OnTouchListener(){
		    @Override public boolean onTouch( View v, MotionEvent event){
		    ProgressBar circleview = (ProgressBar) v;
		    int action =  event.getAction();
		    
		    
		    switch(action){
		    case MotionEvent.ACTION_DOWN:
		    	Log.d("progressbar", "Action was DOWN");
		         if(curVolume!=0)
			    	{
			    		circleview.setProgress(--curVolume);
				    
			    	}
		         break;
		    
		    case MotionEvent.ACTION_UP:
		    	Log.d("progressbar", "Action was UP");
		         if(curVolume!=0)
			    	{
			    		circleview.setProgress(++curVolume);
				    
			    	}
		         break;
		    }
			return true;
			
		    
		    
		    
		    
		    /*if(action == MotionEvent.ACTION_DOWN){ 
		    	X = event.getX();
	            Y = event.getY();
				//circleview.setBackgroundColor(color );
		         Log.d("progressbar", "Action was DOWN");
		         if(curVolume!=0)
			    	{
			    		circleview.setProgress(--curVolume);
				    
			    	}
			    return true;
		    }
		    else(action == MotionEvent.ACTION_UP){ 
				    	X = event.getX();
			            Y = event.getY();
						//circleview.setBackgroundColor(color );
				         Log.d("progressbar", "Action was up");
				         if(curVolume!=0)
					    	{
					    		circleview.setProgress(++curVolume);
						    
					    	}
					    return true;
				    } */
		    
		    }
		  } 
		);
		
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
	}
}
	
	
	

/*public boolean onTouch(View v, MotionEvent event) {

		return false;
	}
	

	
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	circleview = (ProgressBar) findViewById(R.id.progressBar1);
	
	circleview.setOnTouchListener(new OnTouchListener(){
	    @Override public boolean onTouch( View v, MotionEvent event){
	    ProgressBar circleview = (ProgressBar) v;
	    int action =  event.getAction();
	    
	    if(action == MotionEvent.ACTION_DOWN){ 
	    	X = event.getX();
            Y = event.getY();
			//circleview.setBackgroundColor(color );
	         Log.d("progressbar", "Action was DOWN");
	    	  
	    
	      return true;
	    }
	    return false;
	    }
	  }
	);
}*/
