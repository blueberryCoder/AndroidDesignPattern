package com.blueberry.command;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private DrawCanvas mCanvas; //绘制画布
	private DrawPath mPath;	//路径绘制命令
	private Paint mPaint;	//画笔对象
	private IBrush mBrush;	//笔触对象
	
	
	private Button btnRedo,btnUndo;//重做，撤销按钮
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPaint = new Paint();
		mPaint.setColor(0xFFFFFFFF);
		mPaint.setStrokeWidth(3);
		
		mBrush = new NormalBrush();
		
		mCanvas= (DrawCanvas)findViewById(R.id.ac_draw_canvas);
		mCanvas.setOnTouchListener(new DrawTouchListener());
		
		btnRedo = (Button)findViewById(R.id.btn_redo);
		btnUndo = (Button)findViewById(R.id.btn_undo);
	}

	public void onClick(View view){
		switch (view.getId()) {
		case R.id.btn_red:
			mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			mPaint.setStrokeWidth(3);
			mPaint.setColor(Color.RED);
			break;
		case R.id.btn_green:
			mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			mPaint.setStrokeWidth(3);
			mPaint.setColor(Color.GREEN);
			break;
		case R.id.btn_blue:
			mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			mPaint.setStrokeWidth(3);
			mPaint.setColor(Color.BLUE);
			break;
		case R.id.normal_brush:
			mBrush = new NormalBrush();
			break;
		case R.id.circle_brush:
			mBrush = new CircleBrush();
			break;
		case R.id.btn_undo:
			mCanvas.undo();
			if(!mCanvas.canUndo()){
				btnUndo.setEnabled(false);
			}
			btnRedo.setEnabled(true);
			break;
		case R.id.btn_redo:
			mCanvas.redo();
			if(!mCanvas.canRedo()){
				btnRedo.setEnabled(false);
			}
			btnUndo.setEnabled(true);
			break;

		default:
			break;
		}
	}
	
	private class DrawTouchListener implements View.OnTouchListener{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction() == MotionEvent.ACTION_DOWN){
				mPath = new DrawPath();
				mPath.paint = mPaint;
				mPath.path = new Path();
				mBrush.down(mPath.path, event.getX(), event.getY());
			}else if(event.getAction() == MotionEvent.ACTION_MOVE){
				mBrush.move(mPath.path, event.getX(), event.getY());
			}else if(event.getAction() == MotionEvent.ACTION_UP){
				mBrush.up(mPath.path, event.getX(), event.getY());
				mCanvas.add(mPath);
				mCanvas.isDrawing = true;
				btnUndo.setEnabled(true);
				btnRedo.setEnabled(false);
			}
			
			return true;
		}
		
	}
	
}
