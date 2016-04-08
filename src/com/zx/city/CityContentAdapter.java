package com.zx.city;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CityContentAdapter extends BaseAdapter {

	public Context mContext;
	private MPagerAdapter mPagerAdapter;
	private View mTopView;

	private ViewPager viewPager;
	// 用于存放滚动的图片
	private List<ImageView> imageViews;
	// 用于存放图片的ID
	private int[] imageResId;

	public CityContentAdapter(Context context) {
		mContext = context;
		mPagerAdapter = new MPagerAdapter();
	}

	@Override
	public int getCount() {
		// 用于测试只显示5行数据
		return 5;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position == 0) {
			return getTopView();
		}
		return null;
	}

	// ListView中实现PageAdapter
	public class MPagerAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return imageResId.length;
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(imageViews.get(arg1));
			return imageViews.get(arg1);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
	}

	private View getTopView() {

		imageResId = new int[] { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e };
		imageViews = new ArrayList<ImageView>();
		// 初始化ImageView资源

		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(mContext);
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageViews.add(imageView);
		}
		mTopView = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_viewpager, null);
		viewPager = (ViewPager) mTopView.findViewById(R.id.view_pager);
		viewPager.setAdapter(mPagerAdapter);
		return viewPager;
	}
}
