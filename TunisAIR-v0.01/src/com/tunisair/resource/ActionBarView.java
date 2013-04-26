package com.tunisair.resource;


import android.content.Context;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.esprit.main.R;


public class ActionBarView extends LinearLayout implements OnClickListener{
	private View mconvertView;
	
	private ImageButton mButtonHome;
	
	//private OnDispatchClickListener mListenerClick;
	
	public interface OnDispatchClickListener{
		public void onDispatchClick(int id);
	}
	
	

	public ActionBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mconvertView = LayoutInflater.from(context).inflate(R.layout.action_bar, this);
		mButtonHome = (ImageButton) mconvertView.findViewById(R.id.ab_home);
		
		mButtonHome.setOnClickListener(this);
		
		
	}


	@Override
	public void onClick(View v) {
		
		
		
	}
	
	public void setOnDispatchClickListener(OnDispatchClickListener v){
		//mListenerClick = v;
		
	}

}
