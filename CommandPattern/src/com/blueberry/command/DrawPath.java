package com.blueberry.command;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class DrawPath implements IDraw{

	public Path path; //需要绘制的路径
	public Paint paint; //画笔
	@Override
	public void draw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}

	@Override
	public void undo() {
		
	}

}
