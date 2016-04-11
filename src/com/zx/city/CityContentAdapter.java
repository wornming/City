package com.zx.city;

import java.util.Random;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CityContentAdapter extends BaseAdapter {

	public Context mContext;
	private TopView topView;

	public CityContentAdapter(Context context) {
		mContext = context;
		topView = new TopView(context);
	}

	@Override
	public int getCount() {
		// 用于测试只显示5行数据
		return 7;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		switch (position) {
		case 0:
			return topView.getTopView();
		case 1:
			return new SecondView(mContext).getSecondView();
		case 2:
			return new ThirdView(mContext).getThirdView();
		case 3:
			return new SecondView(mContext).getSecondView();
		default:
			if ((int)(1+Math.random()*(2)) == 2) {
				return new SecondView(mContext).getSecondView();
			} else
				return new ThirdView(mContext).getThirdView();
		}
	}
}
