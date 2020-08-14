package com.mouhammeddbs.covid19;
import java.util.*;
import com.android.volley.toolbox.*;
import com.android.volley.*;
import android.content.*;
import org.json.*;
import android.widget.*;
import android.graphics.*;

/**
 * Created by Mouhammed Dbs on 13/8/2020
 */

public class Presenter
{
	private PostView view;
	private Context context;
	private final static String url = "https://coronavirus-19-api.herokuapp.com/countries";

	public Presenter(PostView view, Context context)
	{
		this.view = view;
		this.context = context;
	}

	public ArrayList<Model> getPostsFromDatabase()
	{
		final ArrayList<Model> array = new ArrayList<Model>();

		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
			new Response.Listener<String>(){

				@Override
				public void onResponse(String p1)
				{
					try
					{
						JSONArray ar = new JSONArray(p1);
						String country;
						float cases = 0,deaths = 0, todayCases = 0,todayDeaths = 0,recoverd = 0,active = 0 ,critical = 0,casesPerOneMillion = 0,deathsPerOneMillion = 0;
						for (int i=0; i < ar.length(); i++)
						{
							JSONObject ob = ar.getJSONObject(i);
							country = ob.getString("country");	
							try
							{
								cases = Integer.parseInt(ob.getString("cases"));
								deaths = Integer.parseInt(ob.getString("deaths"));
								recoverd = Integer.parseInt(ob.getString("recovered"));
							}
							catch (Exception e){}
							
							array.add(new Model(country, cases, deaths, todayCases, todayDeaths, recoverd, active, critical, casesPerOneMillion, deathsPerOneMillion));
						}
						onGetPosts(array);
					}
					catch (JSONException e)
					{
						onErrorGetPosts();
					}
					// TODO: Implement this method
				}
			},
			new Response.ErrorListener(){

				@Override
				public void onErrorResponse(VolleyError p1)
				{
					onErrorGetPosts();
					// TODO: Implement this method
				}
			});
		RequestQueue req = Volley.newRequestQueue(context);
		req.add(stringRequest);	
		return array;
	}
	
	
	private void onGetPosts(ArrayList<Model> array)
	{
		view.onGetPosts(array);
	}
	private void onErrorGetPosts()
	{
		view.onErrorGetPosts();
	}
	
}
