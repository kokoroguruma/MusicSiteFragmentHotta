package com.kokoroguruma.musicsitefragmenthotta;


import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;

import java.util.Map;

/**
 * 新規ユーザー登録が出来る。
 */
public class RegistActivity extends AppCompatActivity {
	private final static String TAG = RegistActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);


		this.onClickRegistSubmitButton();


		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				// 何もしないで戻る。
				finish();
				break;
		}

		return super.onOptionsItemSelected(item);
	}


	// ここからClick用

	private void onClickRegistSubmitButton() {
		Button button = findViewById(R.id.registSubmitButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				TextInputLayout registIdLayout = findViewById(R.id.registIdLayout);
				String userId = registIdLayout.getEditText().getText().toString();

				TextInputLayout registPassLayout = findViewById(R.id.registPassLayout);
				String userPass = registPassLayout.getEditText().getText().toString();

				TextInputLayout registMailLayout = findViewById(R.id.registMailLayout);
				String userMail = registMailLayout.getEditText().getText().toString();

				String addAccessUrl = "userRegist?user_id=" + userId + "&user_pass=" + userPass + "&user_mail=" + userMail;

				Access access = new Access(addAccessUrl);
				String jsonData = access.startAcsess();

				Map<String, Object> resultMap = access.jsonObjectParser(jsonData);
				Log.d(TAG, "onClickRegistSubmitButton(): onClick(): resultMap: " + resultMap);


				if (resultMap.get("sucsess").equals("1")) {
					Toast toast = Toast.makeText(getApplication(), userId + " で登録しました。", Toast.LENGTH_LONG);
					toast.show();

					finish();

				} else {

					String resUserId = (String) resultMap.get("user_id");
					if (resUserId.length() == 0) {
						registIdLayout.setHint("id");
					} else {
						registIdLayout.setHint("id: " + resUserId);
					}

					String resUserPass = (String) resultMap.get("user_pass");
					if (resUserPass.length() == 0) {
						registPassLayout.setHint("password");
					} else {
						registPassLayout.setHint("password: " + resUserPass);
					}

					String resUserMail = (String) resultMap.get("user_mail");
					if (resUserMail.length() == 0) {
						registMailLayout.setHint("mail");
					} else {
						registMailLayout.setHint("mail: " + resUserMail);
					}

				}

			}
		});


	}


}
