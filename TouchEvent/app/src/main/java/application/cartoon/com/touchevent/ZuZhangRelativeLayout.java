package application.cartoon.com.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class ZuZhangRelativeLayout extends RelativeLayout {

	private static final String TAG = "MainActivity";

	public ZuZhangRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.i(TAG, "组长接收到了打扫卫生的消息....");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		boolean flag = false;
		if (flag == false) {
			Log.i(TAG, "组长没有阻断消息");
		} else {
			Log.i(TAG, "组长把消息阻断了");
		}
		return flag;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean flag = false;
		if (flag == false) {
			Log.i(TAG, "组长把打扫卫生的事情向上传递");
		} else {
			Log.i(TAG, "组长把卫生打扫了....");
		}
		return flag;
	}
}
