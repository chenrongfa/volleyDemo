package com.yy.crf.volleytest;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class ImageLoaderActivity extends AppCompatActivity {
	private ImageView iv_request;
	private static final String TAG = "ImageRequestActivity";
	private ActivityManager activityManager ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_request);
		activityManager = (ActivityManager) getSystemService
				(ACTIVITY_SERVICE);


		iv_request = (ImageView) findViewById(R.id.iv_request);
		init();
	}

	public void init() {

		RequestQueue requestQueue = Volley.newRequestQueue(this);
		/* 图片加载方法 */
		ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader
				.ImageCache() {

			private int size = activityManager.getMemoryClass() * 1024 * 1024 / 8;
			private LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>
					(size) {
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return value.getByteCount() / 1024;
				}
			};


			@Override
			public Bitmap getBitmap(String url) {

				if (url != null) {
					Log.e(TAG, "getBitmap: "+"获取缓存" );
					return lruCache.get(url);
				}
				return null;
			}

			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				Bitmap isCache = lruCache.get(url);

				if (isCache == null) {
					lruCache.put(url, bitmap);
					Log.e(TAG, "getBitmap: "+"缓存了" );
				}
			}
		});
/*监听*/
		ImageLoader.ImageListener imageListener = ImageLoader.getImageListener
				(iv_request, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
		imageLoader.get("http://www.xchihuo.cn/images/company.gif", imageListener);


	}

}
