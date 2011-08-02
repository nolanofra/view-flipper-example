package com.nolanofra.app.sample.ViewFlipperOne;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class ViewFlipperOneActivity extends Activity{
	
	private ViewFlipper vf;  
    private float oldTouchValue;
	private boolean searchOk;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        vf = (ViewFlipper) findViewById(R.id.layoutswitcher);
        
        
    }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                oldTouchValue = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                //if(this.searchOk==false) return false;
                float currentX = touchevent.getX();
                if (oldTouchValue < currentX)
                {
                    vf.setInAnimation(AnimationHelper.inFromLeftAnimation());
                    vf.setOutAnimation(AnimationHelper.outToRightAnimation());
                    vf.showNext();
                }
                if (oldTouchValue > currentX)
                {
                    vf.setInAnimation(AnimationHelper.inFromRightAnimation());
                    vf.setOutAnimation(AnimationHelper.outToLeftAnimation());
                    vf.showPrevious();
                }
            break;
            }
        }
        return false;
    }
}
