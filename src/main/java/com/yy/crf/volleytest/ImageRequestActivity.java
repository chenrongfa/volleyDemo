package com.yy.crf.volleytest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class ImageRequestActivity extends AppCompatActivity {
	private ImageView iv_request;
	private static final String TAG = "ImageRequestActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_request);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		iv_request = (ImageView) findViewById(R.id.iv_request);
		init();
	}

	public void init() {

		RequestQueue requestQueue = Volley.newRequestQueue(this);

		ImageRequest imageRequest = new ImageRequest
				("http://xchihuo.cn/images/company.gif", new Response
						.Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						Log.e(TAG, "onResponse: " + "成功");


						iv_request.setImageBitmap(response);
					}
				}, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e(TAG, "onErrorResponse: " + error.getMessage());
						iv_request.setImageResource(R.mipmap.ic_launcher);
					}
				});

		requestQueue.add(imageRequest);
	}

}
