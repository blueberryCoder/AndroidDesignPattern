package com.example.adapterandroid.view;

import com.example.adapterandroid.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CircleMenuLayout extends ViewGroup {

	private static final String TAG = "CircleMenuLayout";

	private static final double RADIO_DEFAULT_CHILD_DIMENSION = 0.9;

	private int mMenuItemCount;

	private int mRadius;
	private float mPadding;

	public Adapter mAdapter ;

	private int mStartAngle = 90;

	public CircleMenuLayout(Context context) {
		super(context);
		setPadding(0, 0, 0, 0);
	}

	public CircleMenuLayout(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
	}
	
	public void setAdapter(Adapter adapter){
		this.mAdapter = adapter ;
		mMenuItemCount = adapter.getCount();
		buildMenuItems(); 
	}
	private void buildMenuItems() {
		for (int i = 0; i < mMenuItemCount; i++) {
			View itemView  =null ;
			itemView = mAdapter.getView(i, itemView,null);
			addView(itemView);
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		measureMySelf(widthMeasureSpec, heightMeasureSpec);
		measureChildViews();
	}

	private void measureChildViews() {
		// 获得半径
		mRadius = Math.max(getMeasuredWidth(), getMeasuredHeight()) / 2;
		final int count = getChildCount();
		int childSize = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
		int childMode = MeasureSpec.EXACTLY;
		// 迭代测量
		for (int i = 0; i < count; i++) {
			final View child = getChildAt(i);
			if (child.getVisibility() == GONE)
				continue;
			int makeMeasureSpec = -1;
			makeMeasureSpec = MeasureSpec.makeMeasureSpec(childSize, childMode);
			child.measure(makeMeasureSpec, makeMeasureSpec);
		}
		// mPadding = (float) (RADIO_DEFAULT_CHILD_DIMENSION * mRadius) ;
	}

	private void measureMySelf(int widthMeasureSpec, int heightMeasureSpec) {
		int resWidth = 0;
		int resHeight = 0;
		// 根据传入的参数,分别获取测量模式和测量值
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		if (widthMode != MeasureSpec.EXACTLY
				|| heightMode != MeasureSpec.EXACTLY) {
			resWidth = getSuggestedMinimumWidth();
			resWidth = resWidth == 0 ? getDefaultWidth() : resWidth;
			resHeight = getSuggestedMinimumHeight();
			resHeight = resHeight == 0 ? getDefaultHeight() : resHeight;
		} else {
			resWidth = resHeight = Math.min(width, height);
		}
		setMeasuredDimension(resWidth, resHeight);
	}

	private int getDefaultHeight() {
		WindowManager wm = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	private int getDefaultWidth() {
		WindowManager wm = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		final int childCount = getChildCount();
		int left, top;
		int itemWidth = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
		float angleDelay = 360 / childCount;
		for (int i = 0; i < childCount; i++) {
			final View child = getChildAt(i);
			if (child.getVisibility() == GONE)
				continue;
			// 菜单的起始角度
			mStartAngle %= 360;
			float distanceFromCeneter = mRadius - itemWidth / 2 - mPadding;
			left = (int) (mRadius
					+ Math.round(distanceFromCeneter
							* Math.cos(Math.toRadians(mStartAngle))) - 1 / 2f * itemWidth);
			top = (int) (mRadius + Math.round(distanceFromCeneter
					* Math.sin(Math.toRadians(mStartAngle)) - 1 / 2f
					* itemWidth));
			// 布局child view
			child.layout(left, top, left + itemWidth, top + itemWidth);
			mStartAngle += angleDelay;
		}

	}

	public static interface OnMenuItemClickListener {
		void onClick(View v, int childIndex);
	}
}
