package com.blueberry.command;

import android.graphics.Canvas;

public interface IDraw {
	/**
	 * ����ָ��
	 * 
	 * @param vanvas ��������
	 */
	void draw(Canvas canvas);
	
	/**
	 * ����ָ��
	 * 
	 */
	void undo();
}
