package com.kokoroguruma.musicsitefragmenthotta.access;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 非同期アクセス用クラス
 * これを利用して、DBアクセスを行う。
 * <p>
 * Created by Kokoroguruma on 2018/03/20.
 */

public class Access {
	private final static String TAG = Access.class.getSimpleName();

	String serverAddress;

	Boolean acsessFlag = false;

	/**
	 * アクセス先のアドレス登録
	 * http://------:8080/----/まではある。
	 * @param addurl アクセス先の続き。例：login?name=aaa&pass=abc
	 */
	public Access(String addurl) {
		this.serverAddress = "http://192.168.1.100:8080/MSF_hotta/";
		this.serverAddress = this.serverAddress + addurl;
	}

	public String startAcsess() {
		this.acsessFlag = false;

		StringBuffer result = new StringBuffer();

		MyAsycTask myAsycTask = new MyAsycTask(result);
		myAsycTask.execute(this.serverAddress);


		// データが取れない場合の為にチョット待つ
		int loopCnt = 100;
		loop:for (int i=0; i<loopCnt; i++) {
			if (this.acsessFlag){
				break loop;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (!this.acsessFlag) {
			Log.d(TAG, "startAcsess(): 時間内に、データが取れなかった。アクセスできなかったよ！");
		}

		Log.d(TAG, "startAcsess(): result: " + result);

		return result.toString();
	}

	// ここからJSONのパース

	public Map<String, Object> jsonObjectParser(String jsonData) {
		Log.d(TAG, "jsonObjectParser");
		Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			JSONObject root = new JSONObject(jsonData);
			Iterator<String> rootKeys = root.keys();
			while (rootKeys.hasNext()) {
				String key = rootKeys.next();
				resultMap.put(key, root.get(key));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return resultMap;
	}


	public List<Object> jsonArrayParser(String jsonData) {
		Log.d(TAG, "jsonArrayParser");
		List<Object> resultList = new ArrayList<Object>();

		try {
			JSONArray root = new JSONArray(jsonData);
			for (int i=0; i<root.length(); i++) {
				resultList.add(root.get(i));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return resultList;
	}


	class MyAsycTask extends AsyncTask<String, Void, StringBuffer> {

		private StringBuffer resultString;
		private Boolean nonMissFlag = true;


		public MyAsycTask(StringBuffer ins_resultString) {
			this.resultString = ins_resultString;
			Log.d(TAG, "MyAsycTask(): ");
		}


		@Override
		protected StringBuffer doInBackground(String... string) {
			Log.d(TAG, "MyAsycTask(): doInBackground(): address: " + string[0]);

			StringBuffer result = new StringBuffer();
			HttpURLConnection httpURLConnection = null;
			InputStream inputStream = null;

			try {
				URL url = new URL(string[0]);
				httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.setRequestMethod("GET");
				httpURLConnection.connect();
				inputStream = httpURLConnection.getInputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
				String line;
				while ((line = br.readLine()) != null) {
					result.append(line);
				}
				br.close();



			} catch (MalformedURLException e) {
				this.nonMissFlag = false;
				e.printStackTrace();
			} catch (IOException e) {
				this.nonMissFlag = false;
				e.printStackTrace();
			} catch (Exception e) {
				this.nonMissFlag = false;
				e.printStackTrace();
			} finally {
				if (httpURLConnection != null) {
					httpURLConnection.disconnect();
				}
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}



			this.resultString.append(result);
			// 問題なく成功したら。
			if (this.nonMissFlag) {
				acsessFlag = true;
			}

			return result;
		}

		@Override
		protected void onPostExecute(StringBuffer s) {
			super.onPostExecute(s);
		}
	}







}
