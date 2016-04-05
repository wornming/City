package com.zx.city;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainCity extends Activity implements OnClickListener {

	private LinearLayout cityBottomNavCity;
	private LinearLayout cityBottomNavFind;
	private LinearLayout cityBottomNavServece;
	private LinearLayout cityBottomNavMine;
	private ImageView cityBottomNavCityImg;
	private ImageView cityBottomNavFindImg;
	private ImageView cityBottomNavServeceImg;
	private ImageView cityBottomNavMineImg;
	private TextView cityBottomNavCityText;
	private TextView cityBottomNavFindText;
	private TextView cityBottomNavServeceText;
	private TextView cityBottomNavMineText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_city);

		cityBottomNavCity = (LinearLayout) findViewById(R.id.city_bottomnav_city_btn);
		cityBottomNavFind = (LinearLayout) findViewById(R.id.city_bottomnav_find_btn);
		cityBottomNavServece = (LinearLayout) findViewById(R.id.city_bottomnav_serve_btn);
		cityBottomNavMine = (LinearLayout) findViewById(R.id.city_bottomnav_me_btn);
		cityBottomNavCityImg = (ImageView) findViewById(R.id.city_bottomnav_city_img);
		cityBottomNavFindImg = (ImageView) findViewById(R.id.city_bottomnav_find_img);
		cityBottomNavServeceImg = (ImageView) findViewById(R.id.city_bottomnav_serve_img);
		cityBottomNavMineImg = (ImageView) findViewById(R.id.city_bottomnav_me_img);
		cityBottomNavCityText = (TextView) findViewById(R.id.city_bottomnav_city_text);
		cityBottomNavFindText = (TextView) findViewById(R.id.city_bottomnav_find_text);
		cityBottomNavServeceText = (TextView) findViewById(R.id.city_bottomnav_serve_text);
		cityBottomNavMineText = (TextView) findViewById(R.id.city_bottomnav_me_text);

		cityBottomNavCity.setOnClickListener(this);
		cityBottomNavFind.setOnClickListener(this);
		cityBottomNavMine.setOnClickListener(this);
		cityBottomNavServece.setOnClickListener(this);
		
	}

	/**
	 * 初始化底部导航栏的布局
	 */
	public void initCityBottomNav() {
		cityBottomNavCityImg.setImageResource(R.drawable.city);
		cityBottomNavCityText.setTextColor(getResources().getColor(R.color.city_bottomnav_text));
		cityBottomNavFindImg.setImageResource(R.drawable.find);
		cityBottomNavFindText.setTextColor(getResources().getColor(R.color.city_bottomnav_text));
		cityBottomNavServeceImg.setImageResource(R.drawable.servece);
		cityBottomNavServeceText.setTextColor(getResources().getColor(R.color.city_bottomnav_text));
		cityBottomNavMineImg.setImageResource(R.drawable.me);
		cityBottomNavMineText.setTextColor(getResources().getColor(R.color.city_bottomnav_text));
	}

	@Override
	public void onClick(View v) {
		initCityBottomNav();
		switch (v.getId()) {
		case R.id.city_bottomnav_city_btn:
			cityBottomNavCityImg.setImageResource(R.drawable.city_sel);
			cityBottomNavCityText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_find_btn:
			cityBottomNavFindImg.setImageResource(R.drawable.find_sel);
			cityBottomNavFindText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_serve_btn:
			cityBottomNavServeceImg.setImageResource(R.drawable.service_sel);
			cityBottomNavServeceText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_me_btn:
			cityBottomNavMineImg.setImageResource(R.drawable.me_sel);
			cityBottomNavMineText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		default:
			break;
		}
	}

}
