package com.tunisair.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteTextView extends AutoCompleteTextView{
	
	public MyAutoCompleteTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	public MyAutoCompleteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	

	public MyAutoCompleteTextView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean enoughToFilter() {
		// TODO Auto-generated method stub
		return true;
	}

}
