package com.yy.crf.volleytest;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by crf on 2017/5/22.
 * company:逸辰
 * qq:952786280
 * feature:volloey返回bean
 */

public class GsonRequest<T> extends Request<T> {
	Response.Listener listener;
	private Class<T> tClass;
	private Gson gson;

	public GsonRequest(Class<T> tClass,String url,Response.Listener listener,Response.ErrorListener error){

		this(Method.GET,tClass,url,listener,error);

	}

	public GsonRequest(int method, Class<T> tClass ,String url, Response.Listener listener,Response.ErrorListener errorListener) {
		super(method, url, errorListener);
		this.tClass=tClass;
		this.listener=listener;
		gson=new Gson();
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String json=new String(response.data, HttpHeaderParser.parseCharset(response.headers));

			T fromJson = gson.fromJson(json, tClass);
			return Response.success(fromJson,HttpHeaderParser.parseCacheHeaders(response));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Response.error(new VolleyError(e.getMessage()));

		}

	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}
}
