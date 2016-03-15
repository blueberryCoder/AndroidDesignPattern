package com.example.bridge.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public abstract class BaseProgressBar {
	public static final int HORIZONTAL =0 ;//水平进度条标示
	public static final int VERTICAL = 1 ;//垂直进度条标示
	public static final int CIRCLE =2 ;//环形进度条标示
	
	protected Paint mPaint ;
	
	protected BaseProgressBar(){
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
	}
	
	public abstract int getMeasureHeight() ;
	
	public abstract int getMeasureWidth();
	
	public abstract void draw(View view,Canvas canvas);
	
}
