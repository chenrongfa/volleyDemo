package com.yy.crf.volleytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class JsonRequestActivity extends AppCompatActivity {

	private TextView tv_requstString;
	private JSONObject object=new JSONObject();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_request);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		init();

	}
/*  不是json格式请求出错*/
	public void init() {
		tv_requstString = (TextView) findViewById(R.id.tv_requestString);
		RequestQueue requestQueue = Volley.newRequestQueue(this);
		final JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method
				.GET, "http://gc.ditu.aliyun.com/geocoding?a=%E8%8B%8F%E5%B7%9E%E5%B8%82", object, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				tv_requstString.setText(response.toString());
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				tv_requstString.setText(error.getMessage());
			}
		});
		requestQueue.add(stringRequest);
	}

}
