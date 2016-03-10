package com.example.adapterandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapterandroid.view.CircleMenuLayout;

public class MainActivity extends Activity {

	private CircleMenuLayout mCircleMenuLayout;
	private ListView lv;
	private BaseAdapter mAdapter = new BaseAdapter() {

		int[] imgs = new int[] { R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher };
		String[] strs = new String[] { "String#1", "String#2", "String#3",
				"String#4", "String#5" };

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = MainActivity.this.getLayoutInflater().inflate(
					R.layout.circle_menu_item, null);
			initMenuItem(convertView, position);

			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
			return convertView;
		}

		@Override
		public long getItemId(int position) {
			return imgs.length;
		}

		@Override
		public Object getItem(int position) {
			return imgs[position];
		}

		@Override
		public int getCount() {
			return imgs.length;
		}

		private void initMenuItem(View itemView, int i) {
			ImageView iv = (ImageView) itemView.findViewById(R.id.iv_item);
			TextView tv = (TextView) itemView.findViewById(R.id.tv_item);
			iv.setVisibility(View.VISIBLE);
			iv.setImageResource(imgs[i]);
			tv.setVisibility(View.VISIBLE);
			tv.setText(strs[i]);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.circle_menu_layout);
		lv = (ListView) findViewById(R.id.listView);
		mCircleMenuLayout.setAdapter(mAdapter);
		lv.setAdapter(mAdapter);
	}
}
