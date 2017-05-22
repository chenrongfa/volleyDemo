package com.yy.crf.volleytest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class GsonActivity extends AppCompatActivity {
	private static final String TAG = "GsonActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gson);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
		init();
	}
	public void init() {

		RequestQueue requestQueue = Volley.newRequestQueue(this);
		/* 图片加载方法 */
		 GsonRequest<Citylocation> gsonRequest=new GsonRequest<Citylocation>(Citylocation.class,
				 "http://gc.ditu.aliyun.com/geocoding?a=%E8%8B%8F%E5%B7%9E%E5%B8%82",
				 new Response.Listener<Citylocation>() {
					 @Override
					 public void onResponse(Citylocation response) {
						 Log.e(TAG, "onResponse: "+response.toString() );
					 }
				 }, new Response.ErrorListener() {
			 @Override
			 public void onErrorResponse(VolleyError error) {
				 Log.e(TAG, "onErrorResponse: "+error.getMessage() );
			 }
		 });
		requestQueue.add(gsonRequest);
	}

}
