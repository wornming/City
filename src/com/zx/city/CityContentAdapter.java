package com.zx.city;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class CityContentAdapter extends BaseAdapter {

	public Context mContext;
	private MPagerAdapter mPagerAdapter;
	private View mTopView;

	private ViewPager viewPager;
	// ���ڴ�Ź�����ͼƬ
	private List<ImageView> imageViews;
	// ���ڴ��ͼƬ��ID
	private int[] imageResId;
	// ���õ�ǰͼƬ����
	private int currentItem = 0;
	// ͼƬ�������ĵ���Щ��
	private List<View> dots;
	// viewpager����ı���
	private TextView adtitle;
	// ͼƬ����
	private String[] titles;

	public CityContentAdapter(Context context) {
		mContext = context;
		mPagerAdapter = new MPagerAdapter();
	}

	@Override
	public int getCount() {
		// ���ڲ���ֻ��ʾ5������
		return 30;
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
		if (position == 0) {
			return getTopView();
		}
		return getSecondView();
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

	// �õ���һ������
	private View getTopView() {
		mTopView = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_viewpager, null);
		imageResId = new int[] { R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e };

		titles = new String[imageResId.length];
		titles[0] = "���н���ȫʡ�׼Ҵ�������������";
		titles[1] = "�����ֻ��������ٳ������ϸ������˴�ϳ�";
		titles[2] = "���ر�����Ӱ�������";
		titles[3] = "������TV�������";
		titles[4] = "��Ѫ��˿�ķ�ɱ";

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
		dots.add(mTopView.findViewById(R.id.v_dot4));

		adtitle = (TextView) mTopView.findViewById(R.id.city_content_newstitle);
		adtitle.setText(titles[0]);

		viewPager = (ViewPager) mTopView.findViewById(R.id.view_pager);
		viewPager.setAdapter(mPagerAdapter);
		viewPager.addOnPageChangeListener(new OnPageChangeListener() {
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
		});
		return mTopView;
	}

	// �õ��ڶ�������view
	private View getSecondView() {

		return LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
	}
}
