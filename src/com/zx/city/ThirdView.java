package com.zx.city;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class ThirdView {
	private Context mContext;

	public ThirdView(Context context){
		mContext = context;
	}

	public View getThirdView() {
		View view = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_thirdview, null);
		return view;
	}
}
