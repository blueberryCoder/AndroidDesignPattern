package com.blueberry.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.graphics.Canvas;


public class DrawInvoker {
	//�����б�
	private List<DrawPath> drawList = Collections.synchronizedList(new ArrayList<DrawPath>());
	
	//�����б�
	private List<DrawPath> redoList = Collections.synchronizedList(new ArrayList<DrawPath>());
	
	/**
	 * ����һ������
	 * 
	 * @param command
	 */
	public void add(DrawPath command){
		redoList.add(command);
		drawList.add(command);
	}
	
	/**
	 * ������һ��������
	 * 
	 */
	public void undo(){
		if(drawList.size()>0){
			DrawPath undo  = drawList.get(drawList.size()-1);
			drawList.remove(drawList.size()-1);
			undo.undo();
			redoList.add(undo);
		}
	}
	
	/**
	 * ������һ���ĳ���������
	 */
	public void redo(){
		if(redoList.size()>0){
			DrawPath redoCommand  = redoList.get(redoList.size()-1);
			redoList.remove(redoList.size()-1);
			drawList.add(redoCommand);
		}
	}
	
	/**
	 * �Ƿ��������
	 * @param canvas
	 */
	public void execute(Canvas canvas){
		if(drawList!=null){
			for(DrawPath tmp:drawList){
				tmp.draw(canvas);
			}
		}
	}
	
	/**
	 * �Ƿ��������
	 * @return
	 */
	public boolean canRedo(){
		return redoList.size()>0;
	}
	
	/**
	 * �Ƿ���Գ���
	 * @return
	 */
	public boolean canUndo(){
		return drawList.size()>0;
	}
}
