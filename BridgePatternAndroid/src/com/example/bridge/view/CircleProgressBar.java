package com.example.bridge.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.view.View;

public class CircleProgressBar extends BaseProgressBar{

	@Override
	public int getMeasureHeight() {
		return 500;
	}

	@Override
	public int getMeasureWidth() {
		return 500;
	}

	@Override
	public void draw(View view, Canvas canvas) {
		mPaint.setColor(Color.RED);
		mPaint.setStyle(Style.STROKE);
		mPaint.setStrokeWidth(3);
		canvas.drawCircle(view.getWidth()/2, view.getHeight()/2, Math.min(view.getWidth(), view.getHeight())/4, mPaint);
	}

}
