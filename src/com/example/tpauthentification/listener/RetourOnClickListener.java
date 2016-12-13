package com.example.tpauthentification.listener;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class RetourOnClickListener implements OnClickListener {
	private Activity activity;
	
	public RetourOnClickListener(Activity activity) {
		super();
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		activity.finish();
	}

}
