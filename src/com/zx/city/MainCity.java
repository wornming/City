package com.zx.city;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainCity extends Activity implements OnClickListener {

	private LinearLayout cityBottomNavCity;
	private LinearLayout cityBottomNavFind;
	private LinearLayout cityBottomNavServece;
	private LinearLayout cityBottomNavMine;
	private LinearLayout cityTopNavLocal;
	private LinearLayout cityTopNavHot;
	private LinearLayout cityTopNavTui;
	private ImageView cityBottomNavCityImg;
	private ImageView cityBottomNavFindImg;
	private ImageView cityBottomNavServeceImg;
	private ImageView cityBottomNavMineImg;
	private View cityTopNavLocalImg;
	private View cityTopNavHotImg;
	private View cityTopNavTuiImg;
	private TextView cityBottomNavCityText;
	private TextView cityBottomNavFindText;
	private TextView cityBottomNavServeceText;
	private TextView cityBottomNavMineText;
	private TextView cityTopNavLocalText;
	private TextView cityTopNavHotText;
	private TextView cityTopNavTuiText;
	
	//关于ListView
	private ListView mContentListView;
	private CityContentAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_city);

		initID();

		cityBottomNavCity.setOnClickListener(this);
		cityBottomNavFind.setOnClickListener(this);
		cityBottomNavMine.setOnClickListener(this);
		cityBottomNavServece.setOnClickListener(this);
		cityTopNavLocal.setOnClickListener(this);
		cityTopNavHot.setOnClickListener(this);
		cityTopNavTui.setOnClickListener(this);
		
		//对Listview进行处理
		mContentListView = (ListView) findViewById(R.id.city_content_list);
		mAdapter = new CityContentAdapter(this);
		mContentListView.setAdapter(mAdapter);
	}

	/**
	 * 初始化ID
	 */
	public void initID() {
		cityBottomNavCity = (LinearLayout) findViewById(R.id.city_bottomnav_city_btn);
		cityBottomNavFind = (LinearLayout) findViewById(R.id.city_bottomnav_find_btn);
		cityBottomNavServece = (LinearLayout) findViewById(R.id.city_bottomnav_serve_btn);
		cityBottomNavMine = (LinearLayout) findViewById(R.id.city_bottomnav_me_btn);
		cityTopNavLocal = (LinearLayout) findViewById(R.id.city_topnav_local_btn);
		cityTopNavHot = (LinearLayout) findViewById(R.id.city_topnav_hot_btn);
		cityTopNavTui = (LinearLayout) findViewById(R.id.city_topnav_tui_btn);
		cityBottomNavCityImg = (ImageView) findViewById(R.id.city_bottomnav_city_img);
		cityBottomNavFindImg = (ImageView) findViewById(R.id.city_bottomnav_find_img);
		cityBottomNavServeceImg = (ImageView) findViewById(R.id.city_bottomnav_serve_img);
		cityBottomNavMineImg = (ImageView) findViewById(R.id.city_bottomnav_me_img);
		cityTopNavLocalImg = findViewById(R.id.city_topnav_local_img);
		cityTopNavHotImg = findViewById(R.id.city_topnav_hot_img);
		cityTopNavTuiImg = findViewById(R.id.city_topnav_tui_img);
		cityBottomNavCityText = (TextView) findViewById(R.id.city_bottomnav_city_text);
		cityBottomNavFindText = (TextView) findViewById(R.id.city_bottomnav_find_text);
		cityBottomNavServeceText = (TextView) findViewById(R.id.city_bottomnav_serve_text);
		cityBottomNavMineText = (TextView) findViewById(R.id.city_bottomnav_me_text);
		cityTopNavLocalText = (TextView) findViewById(R.id.city_topnav_local_text);
		cityTopNavHotText = (TextView) findViewById(R.id.city_topnav_hot_text);
		cityTopNavTuiText = (TextView) findViewById(R.id.city_topnav_tui_text);
	}

	/**
	 * 初始化顶部导航栏
	 */
	public void initCityTopNav() {
		cityTopNavLocalImg.setVisibility(View.INVISIBLE);
		cityTopNavHotImg.setVisibility(View.INVISIBLE);
		cityTopNavTuiImg.setVisibility(View.INVISIBLE);
		cityTopNavLocalText.setTextColor(getResources().getColor(R.color.city_topnav_text));
		cityTopNavHotText.setTextColor(getResources().getColor(R.color.city_topnav_text));
		cityTopNavTuiText.setTextColor(getResources().getColor(R.color.city_topnav_text));
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
		switch (v.getId()) {
		case R.id.city_bottomnav_city_btn:
			initCityBottomNav();
			cityBottomNavCityImg.setImageResource(R.drawable.city_sel);
			cityBottomNavCityText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_find_btn:
			initCityBottomNav();
			cityBottomNavFindImg.setImageResource(R.drawable.find_sel);
			cityBottomNavFindText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_serve_btn:
			initCityBottomNav();
			cityBottomNavServeceImg.setImageResource(R.drawable.service_sel);
			cityBottomNavServeceText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_bottomnav_me_btn:
			initCityBottomNav();
			cityBottomNavMineImg.setImageResource(R.drawable.me_sel);
			cityBottomNavMineText.setTextColor(getResources().getColor(R.color.city_bottomnav_text_sel));
			break;
		case R.id.city_topnav_local_btn:
			initCityTopNav();
			cityTopNavLocalImg.setVisibility(View.VISIBLE);
			cityTopNavLocalText.setTextColor(getResources().getColor(R.color.city_topnav_text_sel));
			break;
		case R.id.city_topnav_hot_btn:
			initCityTopNav();
			cityTopNavHotImg.setVisibility(View.VISIBLE);
			cityTopNavHotText.setTextColor(getResources().getColor(R.color.city_topnav_text_sel));
			break;
		case R.id.city_topnav_tui_btn:
			initCityTopNav();
			cityTopNavTuiImg.setVisibility(View.VISIBLE);
			cityTopNavTuiText.setTextColor(getResources().getColor(R.color.city_topnav_text_sel));
			break;
		default:
			break;
		}
	}

}
