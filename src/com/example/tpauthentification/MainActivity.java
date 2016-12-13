package com.example.tpauthentification;

import javax.xml.datatype.Duration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void initButtons() {
		((Button) findViewById(R.id.btnValider)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String loginSaisi = ((EditText) findViewById(R.id.edtTxtLogin)).getText().toString();
				String passwordSaisi = ((EditText) findViewById(R.id.edtTxtPassword)).getText().toString();
				if(loginSaisi.isEmpty()) {
					Toast.makeText(getApplicationContext(), "Veuillez saisir votre login !", Toast.LENGTH_SHORT).show();
				} else if(passwordSaisi.isEmpty()) {
					Toast.makeText(getApplicationContext(), "Veuillez saisir votre mot de passe !", Toast.LENGTH_SHORT).show();
				} else if(getString(R.string.login).equals(loginSaisi) && getString(R.string.password).equals(passwordSaisi)) {
					Intent i = new Intent(getApplicationContext(), AccueilActivity.class);
					i.putExtra("login", loginSaisi);
					i.putExtra("password", passwordSaisi);
					startActivity(i);
				} else {
					Toast.makeText(getApplicationContext(), "Login ou Password incorrect !", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		((Button) findViewById(R.id.btnEffacer)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((EditText)findViewById(R.id.edtTxtLogin)).setText("");
				((EditText)findViewById(R.id.edtTxtPassword)).setText("");
			}
		});
		
		((Button) findViewById(R.id.btnRetour)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
