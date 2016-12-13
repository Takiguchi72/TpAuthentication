package com.example.tpauthentification.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.tpauthentification.R;
import com.example.tpauthentification.listener.RetourOnClickListener;

public class AccueilActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		initActivity();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		switch(item.getItemId()) {
		case R.id.menu_youtube:
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://")));
			return true;
		case R.id.menu_quitter:
			finish();
			return true;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private void initActivity() {
		((TextView)findViewById(R.id.txtViewBienvenue)).setText("Bienvenue " + getIntent().getExtras().getString("login") + " !");
		
		((TextView)findViewById(R.id.txtViewVotreMotDePasseEstValue)).setText(getIntent().getExtras().getString("password"));
	
		((Button) findViewById(R.id.btnYoutube)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://"));
				startActivity(intent);
			}
		});
		
		((Button) findViewById(R.id.btnRetour)).setOnClickListener(new RetourOnClickListener(this));
		
		((Button) findViewById(R.id.btnAngersMag)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
				intent.putExtra("url", "http://www.angersmag.info/");
				startActivity(intent);
			}
		});
		
		((Button) findViewById(R.id.btnImie)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Ouverture du site de l'imie dans le navigateur par défaut
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setData(Uri.parse("http://www.imie.fr/"));
//				startActivity(intent);
				
				// Ouverture du site de l'imie dans une webView
				Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
				intent.putExtra("url", "http://www.imie.fr/");
				startActivity(intent);
			}
		});
		
	}
}
