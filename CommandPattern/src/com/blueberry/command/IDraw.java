package com.blueberry.command;

import android.graphics.Canvas;

public interface IDraw {
	/**
	 * 绘制指令
	 * 
	 * @param vanvas 画布对象
	 */
	void draw(Canvas canvas);
	
	/**
	 * 撤销指令
	 * 
	 */
	void undo();
}
