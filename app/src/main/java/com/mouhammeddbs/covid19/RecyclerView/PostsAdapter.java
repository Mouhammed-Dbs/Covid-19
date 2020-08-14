package com.mouhammeddbs.covid19.RecyclerView;
import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import com.mouhammeddbs.covid19.*;
import java.util.*;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.utils.*;
import android.graphics.*;
import com.github.mikephil.charting.components.*;
import com.github.mikephil.charting.formatter.*;

/**
 * Created by Mouhammed Dbs on 13/8/2020
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder>
{
    private List<Model> postsList;

	public PostsAdapter(List<Model> PostsList)
	{
        this.postsList = PostsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
	{
        public TextView text;
		public PieChart pie;
        public MyViewHolder(View view)
		{
            super(view);
            text = (TextView) view.findViewById(R.id.text);
			pie = (PieChart) view.findViewById(R.id.piechart);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
        View itemView = LayoutInflater.from(parent.getContext()).
			inflate(R.layout.item_post, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
	{
		Model model = postsList.get(position);
		holder.text.setText("Country : " + model.getCountry() + "\nCases : " + (int)model.getCases() + "\nRecovered : " + (int)model.getRecoverd() + "\nDeaths : " + (int)model.getDeaths());
		AddChart(holder.pie, getEntries(model.getCases(), model.getDeaths(), model.getRecoverd()), model.getCountry());
    }

    @Override
    public int getItemCount()
	{
        return postsList.size();
    }

	public void updateList(ArrayList<Model> arr)
	{
		postsList = arr;
		notifyDataSetChanged();
	}

	private ArrayList<PieEntry> getEntries(float cases, float deaths, float recovered)
	{
		ArrayList<PieEntry> pieEntries = new ArrayList<>();

		PieEntry e = new PieEntry(cases);
		e.setLabel("Cases");
		pieEntries.add(e);
		e = new PieEntry(recovered);
		e.setLabel("Recovered");
		pieEntries.add(e);
		e = new PieEntry(deaths);
		e.setLabel("Deaths");
		pieEntries.add(e);


		return pieEntries;
	}


	public void AddChart(PieChart pieChart, ArrayList<PieEntry> array, String name)
	{
		PieDataSet pieDataSet = new PieDataSet(array, "");
		pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
		pieDataSet.setValueTextSize(11f);
		pieDataSet.setValueTextColor(Color.WHITE);
		pieDataSet.setSliceSpace(8f);
		PieData pieData = new PieData(pieDataSet);
		pieData.setValueFormatter(new PercentFormatter());
		pieChart.setCenterText("Covid-19");
		pieChart.setCenterTextColor(Color.BLACK);
		pieChart.setEntryLabelColor(Color.WHITE);
		pieChart.setEntryLabelTextSize(11f);
		pieChart.setData(pieData);
		pieChart.setDrawEntryLabels(false);
		Description d = new Description();
		d.setText(name);
		pieChart.setDescription(d);
	}
}
