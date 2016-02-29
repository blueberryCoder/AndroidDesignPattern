package com.blueberry.command;

import android.graphics.Path;

public interface IBrush {
	/**
	 * ����Ӵ�ʱ
	 * @param path ·������
	 * @param x		��ǰλ�õ�x������
	 * @param y		��ǰλ��λ�õ�y������
	 */
	void down(Path path,float x,float y);
	
	/**
	 * �����ƶ�ʱ
	 * @param path ·������
	 * @param x		��ǰλ�õ�x����
	 * @param y		��ǰλ�õ�y����
	 */
	void move(Path path,float x,float y);
	
	/**
	 * �����뿪ʱ
	 * @param path ·������
	 * @param x		��ǰλ�õ�x����
	 * @param y		��ǰλ�õ�y����
	 */
	void up(Path path,float x,float y);
}
