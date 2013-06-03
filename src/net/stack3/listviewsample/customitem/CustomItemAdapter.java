package net.stack3.listviewsample.customitem;

import java.util.List;

import net.stack3.listviewsample.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomItemAdapter extends BaseAdapter {
	private Context context;
	private List<CustomItem> items;
	
	public CustomItemAdapter(Context context, List<CustomItem> items) {
		this.context = context;
		this.items = items;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View customItemView = null; 
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			customItemView = inflater.inflate(R.layout.custom_item_activity_item, parent, false);
			Log.d(this.getClass().getName(), "created");
		} else {
			customItemView = convertView;
			Log.d(this.getClass().getName(), "recycled");
		}
		
		TextView titleTextView = (TextView)customItemView.findViewById(R.id.titleTextView);
		TextView descriptionTextView = (TextView)customItemView.findViewById(R.id.descriptionTextView);
		
		CustomItem item = items.get(position);
		titleTextView.setText(item.getTitle());
		descriptionTextView.setText(item.getDescription());
		
		return customItemView;
	}

}
