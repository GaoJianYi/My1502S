package application.cartoon.com.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class BanZhangFragmeLayout extends FrameLayout {

	private static final String TAG = "MainActivity";

	public BanZhangFragmeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
//	com.example.toucheventdemo.BanZhangFragmeLayout
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(TAG, "班长接收到了打扫卫生的消息....");
		return super.dispatchTouchEvent(ev);
		
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean flag=true;
		if(flag==false){
			Log.i(TAG, "班长没有阻断消息");
		}else{
			Log.i(TAG, "班长把消息阻断了");
		}
		//true 代表阻断 false 代表向下传递
		return flag;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//消费触摸事件
		boolean flag =true;
		if (flag == false) {
			Log.i(TAG, "班长把打扫卫生的事情向上传递");
		} else {
			Log.i(TAG, "班长把卫生打扫了.....");
		}
		return flag;
	}
}
