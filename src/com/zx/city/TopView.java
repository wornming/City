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
	// ���ڴ��ͼƬ��ID
	private int[] imageResId;
	// ͼƬ����
	private String[] titles;
	// ���ڴ�Ź�����ͼƬ
	private List<ImageView> imageViews;
	// ͼƬ�������ĵ���Щ��
	private List<View> dots;
	// viewpager����ı���
	private TextView adtitle;
	// ���õ�ǰͼƬ����
	private int currentItem = 0;
	private ViewPager viewPager;
	private MPagerAdapter mPagerAdapter;

	public TopView(Context context) {
		mContext = context;
	}

	// �õ���һ������
	private View getTopView() {
		mTopView = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_viewpager, null);
		imageResId = new int[] { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };

		titles = new String[imageResId.length];
		titles[0] = "���н���ȫʡ�׼Ҵ�������������";
		titles[1] = "��ȫʡ�׼Ҵ�������������";
		titles[2] = "���н���ȫʡ�׼Ҵ�������������";
		titles[3] = "�н���ȫʡ�׼Ҵ�������������";

		imageViews = new ArrayList<ImageView>();
		// ��ʼ��ImageView��Դ
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

	// ListView��ʵ��PageAdapter
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
