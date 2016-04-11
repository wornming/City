package com.zx.city;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class TopView {
	private Context mContext;
	private View mTopView;
	// 用于存放图片的ID
	private int[] imageResId;
	// 图片标题
	private String[] titles;
	// 用于存放滚动的图片
	private List<ImageView> imageViews;
	// 图片标题正文的那些点
	private List<View> dots;
	// viewpager下面的标题
	private TextView adtitle;
	// 设置当前图片索引
	private int currentItem = 0;
	private ViewPager viewPager;
	private MPagerAdapter mPagerAdapter;

	public TopView(Context context) {
		mContext = context;
	}

	// 得到第一个布局
	private View getTopView() {
		mTopView = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_viewpager, null);
		imageResId = new int[] { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };

		titles = new String[imageResId.length];
		titles[0] = "我市将建全省首家大数据区域中心";
		titles[1] = "建全省首家大数据区域中心";
		titles[2] = "我市将建全省首家大数据区域中心";
		titles[3] = "市将建全省首家大数据区域中心";

		imageViews = new ArrayList<ImageView>();
		// 初始化ImageView资源
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(mContext);
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageViews.add(imageView);
		}

		dots = new ArrayList<View>();
		dots.add(mTopView.findViewById(R.id.v_dot0));
		dots.add(mTopView.findViewById(R.id.v_dot1));
		dots.add(mTopView.findViewById(R.id.v_dot2));
		dots.add(mTopView.findViewById(R.id.v_dot3));

		adtitle = (TextView) mTopView.findViewById(R.id.city_content_newstitle);
		adtitle.setText(titles[0]);

		viewPager = (ViewPager) mTopView.findViewById(R.id.view_pager);
		viewPager.setAdapter(mPagerAdapter);
		viewPager.addOnPageChangeListener(new MyPageChangeListener());
		return mTopView;
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

	private class MyPageChangeListener implements OnPageChangeListener {
		int oldPosition = 0;

		@Override
		public void onPageSelected(int position) {
			currentItem = position;
			adtitle.setText(titles[position]);
			dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			oldPosition = position;
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
}
