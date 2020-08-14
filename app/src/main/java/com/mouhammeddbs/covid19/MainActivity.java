package com.mouhammeddbs.covid19;

import android.app.*;
import android.os.*;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.*;
import java.util.*;
import com.github.mikephil.charting.formatter.*;
import com.github.mikephil.charting.interfaces.datasets.*;
import com.github.mikephil.charting.utils.*;
import android.graphics.*;
import com.github.mikephil.charting.components.*;
import android.graphics.drawable.*;
import android.view.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import com.mouhammeddbs.covid19.RecyclerView.*;
import android.widget.*;
import android.text.*;

/**
 * Created by Mouhammed Dbs on 13/8/2020
 */

public class MainActivity extends Activity implements PostView
{
	private EditText edit;
	private ArrayList<Model> arraylist;
	private Presenter pre;
	private ProgressBar prog;
	private SwipeRefreshLayout swipe;
	private RecyclerView recyclerView;
	private PostsAdapter mAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edit = (EditText)findViewById(R.id.mainEditText);
		
		prog = (ProgressBar)findViewById(R.id.progress);
		swipe = (SwipeRefreshLayout)findViewById(R.id.swipeContainerPosts);
		recyclerView = (RecyclerView) findViewById(R.id.re);	
        recyclerView.setHasFixedSize(true);
		
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL,1600));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
		arraylist = new ArrayList<Model>();
        mAdapter = new PostsAdapter(arraylist);
		recyclerView.setAdapter(mAdapter);
		
		pre = new Presenter(this,getApplicationContext());
		pre.getPostsFromDatabase();
		
		swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
				@Override
				public void onRefresh()
				{
					
					pre.getPostsFromDatabase();
				}
			});
			
		edit.addTextChangedListener(new TextWatcher() {
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {

					// TODO Auto-generated method stub
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {

					// TODO Auto-generated method stub
				}

				@Override
				public void afterTextChanged(Editable s) {

					// filter your list from your input
					filter(s.toString());
					//you can use runnable postDelayed like 500 ms to delay search text
				}

				
			});
	}
	
	private void filter(String text)
	{
		ArrayList<Model> array = new ArrayList<Model>();
		for (Model item : arraylist){
			if(item.getCountry().toLowerCase().contains(text.toLowerCase())){
				array.add(item);
			}
		}
		mAdapter.updateList(array);
		// TODO: Implement this method
	}
	
	
	@Override
	public void onGetPosts(final ArrayList<Model> array)
	{
		arraylist = array;
		mAdapter.updateList(array);
		prog.setVisibility(View.GONE);
		swipe.setVisibility(View.VISIBLE);
		if(swipe.isRefreshing()){
			swipe.setRefreshing(false);
		}

		// TODO: Implement this method
	}
	@Override
	public void onErrorGetPosts()
	{
		Toast.makeText(getApplicationContext(), "No internet connection,Please swipe down to refresh", Toast.LENGTH_LONG).show();
		prog.setVisibility(View.GONE);
		swipe.setVisibility(View.VISIBLE);
		if(swipe.isRefreshing()){
			swipe.setRefreshing(false);
		}
		// TODO: Implement this method
	}
	
}
