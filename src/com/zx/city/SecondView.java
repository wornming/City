package com.zx.city;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class SecondView {
	private Context mContext;
	public SecondView(Context context){
		mContext = context;
	}
	public View getSecondView(){
		View view = LayoutInflater.from(mContext).inflate(R.layout.city_contentlist_secondview, null);
		return view;
	}
}
