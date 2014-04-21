package com.assignment.weatherforecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class CustomAdapterForGridView extends BaseAdapter{

	Context mContext;
	LayoutInflater inflater;
	ArrayList<Bitmap> icon;
	
	ArrayList<String> date, maxTemp,  minTemp, windSpeed, description ;

	public CustomAdapterForGridView(Context context,ArrayList<String> dateS,ArrayList<Bitmap> iconS,
			ArrayList<String> descriptionS,	ArrayList<String> maxTempS,ArrayList<String> minTempS, ArrayList<String> windSpeedS)
	{
		this.mContext = context;
		inflater = LayoutInflater.from(mContext);
		this.date = dateS;
		this.icon = iconS;
		this.maxTemp = maxTempS;
		this.minTemp = minTempS;
		this.windSpeed = windSpeedS;
		this.description = descriptionS;
	}

	

	public class ViewHolder {
		LinearLayout layout;
		ImageView icon;
		TextView date;
		TextView maxTemp;
		TextView minTemp;
		TextView description;
		TextView windSpeed;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.date.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}



	@Override
	public View getView(final int position, View row, ViewGroup parent) {
		ViewHolder holder = null;
		View view  = row;

		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.custom_grid_item, null);
			holder.layout = (LinearLayout)view.findViewById(R.id.linearCustomItem);
			holder.date = (TextView)view.findViewById(R.id.textViewDateCustomGrid);
			holder.icon = (ImageView)view.findViewById(R.id.imageViewIconCustomGrid);
			holder.description = (TextView)view.findViewById(R.id.textViewDescriptionCustomGrid);
			holder.maxTemp = (TextView)view.findViewById(R.id.textViewValueTempMax);
			holder.minTemp = (TextView)view.findViewById(R.id.textViewValueTempMin);
			holder.windSpeed = (TextView)view.findViewById(R.id.textViewValueWindSpeed);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		long unixseconds = Long.parseLong(date.get(position));
		Date date= new Date(unixseconds * 1000L);
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT04"));
		String formatedDate = sdf.format(date);
		
		holder.date.setText(formatedDate);
		holder.description.setText(description.get(position).toUpperCase());
		holder.maxTemp.setText(maxTemp.get(position));
		holder.minTemp.setText(minTemp.get(position));
		holder.windSpeed.setText(windSpeed.get(position));
		holder.icon.setImageBitmap(icon.get(position));
		return view;
	}

}
