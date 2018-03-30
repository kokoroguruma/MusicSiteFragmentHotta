package com.kokoroguruma.musicsitefragmenthotta;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
	private final static String TAG = LoginFragment.class.getSimpleName();

	MyApplication application;


	public LoginFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		application = (MyApplication) getActivity().getApplication();


		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_login, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		this.onClickList();

	}

	// ここからClick用
	private void onClickList() {
		this.onClickLoginSubmitButton();
		this.onClickLoginIntentRegistButton();
	}


	private void onClickLoginSubmitButton() {
		Button button = getView().findViewById(R.id.loginSubmitButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickLoginSubmitButton(): onClick()");

				TextInputLayout loginIdLayout = getView().findViewById(R.id.loginIdLayout);
				String userId = loginIdLayout.getEditText().getText().toString();

				TextInputLayout loginPassLayout = getView().findViewById(R.id.loginPassLayout);
				String userPass = loginPassLayout.getEditText().getText().toString();

				// IMEIの確保 禁止になった。代わりにANDROID_IDを突っ込む。
				String androidId = Settings.Secure.getString(application.getContentResolver(), Settings.Secure.ANDROID_ID);
				Log.d(TAG, "onClickLoginSubmitButton(): onClick(): androidId: " + androidId);

				// アクセス準備
				String addressStr = "loginCheck?user_id=" + userId + "&user_pass=" + userPass + "&imei=" + androidId;
				Access access = new Access(addressStr);

				// アクセス開始
				String jsonData = access.startAcsess();
				Log.d(TAG, "onClickLoginSubmitButton(): onClick(): access.startAcsess: " + jsonData);

				// Parser JsonをMapに
				Map<String, Object> resultMap = access.jsonObjectParser(jsonData);
				Log.d(TAG, "onClickLoginSubmitButton(): onClick(): resultMap: " + resultMap.toString());

				if (resultMap.get("sucsess").toString().equals("1")) {
					// ログイン成功時
					Log.d(TAG, "onClickLoginSubmitButton(): onClick(): s_pass: " + resultMap.get("s_pass").toString());
					application.login(userId, resultMap.get("s_pass").toString());
				} else  {

					Toast toast = Toast.makeText(getView().getContext(), "Login失敗", Toast.LENGTH_SHORT);
					toast.show();
				}

			}
		});
	}


	private void onClickLoginIntentRegistButton() {
		Button button = getView().findViewById(R.id.loginIntentRegistButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickLoginIntentRegistButton(): onClick()");
				// Regist画面を開く
				Intent intent = new Intent(getContext(), RegistActivity.class);
				startActivity(intent);
			}
		});
	}

}
