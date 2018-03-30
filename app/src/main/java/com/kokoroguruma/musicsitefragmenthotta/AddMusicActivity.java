package com.kokoroguruma.musicsitefragmenthotta;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;

import java.util.Map;


/**
 * 音声の追加用アクティビティ
 */
public class AddMusicActivity extends AppCompatActivity {
	private final static String TAG = AddMusicActivity.class.getSimpleName();

	MyApplication application;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_music);

		application = (MyApplication) this.getApplication();

		this.onClickAddMusicSubmitButton();


		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);


	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menuLogout:
				// ログアウト
				application.logout();
				finish();
				break;
			case android.R.id.home:
				// 何もしないで戻る。
				finish();
				break;
		}

		return super.onOptionsItemSelected(item);
	}


	// ここからmenu管理
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_add_music, menu);
		return super.onCreateOptionsMenu(menu);
	}


	// ここからClick用


	private void onClickAddMusicSubmitButton() {
		Button button = findViewById(R.id.addMusicSubmitButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String sPass = application.getSPass();

				TextInputLayout addMusicNameLayout = findViewById(R.id.addMusicNameLayout);
				String addName = addMusicNameLayout.getEditText().getText().toString();

				TextInputLayout addMusicUrlLayout = findViewById(R.id.addMusicUrlLayout);
				String addUrl = addMusicUrlLayout.getEditText().getText().toString();

				TextInputLayout addMusicCommentLayout = findViewById(R.id.addMusicCommentLayout);
				String addComment = addMusicCommentLayout.getEditText().getText().toString();

				String addAccessUrl = "addMusic?s_pass=" + sPass + "&music_name=" + addName + "&music_url=" + addUrl + "&music_comment=" + addComment;

				Access access = new Access(addAccessUrl);
				String jsonData = access.startAcsess();

				Map<String, Object> resultMap = access.jsonObjectParser(jsonData);
				Log.d(TAG, "onClickAddMusicSubmitButton(): onClick(): resultMap: " + resultMap);


				if (resultMap.get("sucsess").equals("1")) {

					String showToastText = "追加しました！\n" + addName + "\n" + addUrl + "\n" + addComment;
					Toast toast = Toast.makeText(getApplication(), showToastText, Toast.LENGTH_LONG);
					toast.show();

					addMusicNameLayout.getEditText().setText("");
					addMusicUrlLayout.getEditText().setText("");
					addMusicCommentLayout.getEditText().setText("");

				} else {

					if (((String) resultMap.get("s_pass")).length() != 0) {
						application.logout();
					}

				}


				String resMusicName = (String) resultMap.get("music_name");
				String musicNameHint = getString(R.string.addMusicNameTextHint);
				if (resMusicName.length() == 0) {
					addMusicNameLayout.setHint(musicNameHint);
				} else {
					addMusicNameLayout.setHint(musicNameHint + ": " + resMusicName);
				}

				String resMusicUrl = (String) resultMap.get("music_url");
				String musicUrlHint = getString(R.string.addMusicUrlTextHint);
				if (resMusicUrl.length() == 0) {
					addMusicUrlLayout.setHint(musicUrlHint);
				} else {
					addMusicUrlLayout.setHint(musicUrlHint + ": " + resMusicUrl);
				}

				String resMusicComment = (String) resultMap.get("music_comment");
				String musicCommentHint = getString(R.string.addMusicCommentTextHint);
				if (resMusicComment.length() == 0) {
					addMusicCommentLayout.setHint(musicCommentHint);
				} else {
					addMusicCommentLayout.setHint(musicCommentHint + ": " + resMusicComment);
				}

			}
		});
	}


}
