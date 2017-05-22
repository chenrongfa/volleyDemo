package com.yy.crf.volleytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=new ListView(this);
		String data[]=new String[]{"Stringrequest","imagesRequest","jsonRequest","imageLoader","gsonActivity"};
		listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));
		setContentView(listView);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long
					id) {
				Intent intent=new Intent();
				if(position==0){
					intent.setClass(getApplicationContext(),StringRequestActivity.class);

				}else if(position==2){
					intent.setClass(getApplicationContext(),JsonRequestActivity.class);

				}else if(position==1){
					intent.setClass(getApplicationContext(),ImageRequestActivity.class);
				}else if(position==3){
					intent.setClass(getApplicationContext(),ImageLoaderActivity.class);
				}else if(position==4){
					intent.setClass(getApplicationContext(),GsonActivity.class);
				}
				startActivity(intent);
			}
		});

	}
}
