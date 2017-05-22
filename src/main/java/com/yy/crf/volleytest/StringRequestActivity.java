package com.yy.crf.volleytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class StringRequestActivity extends AppCompatActivity {
	private TextView tv_requstString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_string_request);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		/*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});*/
		init();
	}
	public void init(){
		tv_requstString= (TextView) findViewById(R.id.tv_requestString);
		RequestQueue requestQueue = Volley.newRequestQueue(this);
		final StringRequest stringRequest = new StringRequest("https://www.baidu.com", new
				Response.Listener<String>() {


			@Override
			public void onResponse(String response) {
				tv_requstString.setText(response);
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
