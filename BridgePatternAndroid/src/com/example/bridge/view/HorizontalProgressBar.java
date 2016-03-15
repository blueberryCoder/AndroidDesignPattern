package com.example.bridge.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;

public class HorizontalProgressBar extends BaseProgressBar{

	@Override
	public int getMeasureHeight() {
		return 50;
	}

	@Override
	public int getMeasureWidth() {
		return 1000;
	}

	@Override
	public void draw(View view, Canvas canvas) {
		mPaint.setColor(Color.RED);
		canvas.drawRect(new Rect(0, 0, view.getWidth(), view.getHeight()), mPaint);
	}

}
