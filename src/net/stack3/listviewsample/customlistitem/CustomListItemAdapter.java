package net.stack3.listviewsample.customlistitem;

import java.util.List;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.model.CustomListItem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListItemAdapter extends BaseAdapter {
	private Context context;
	private List<CustomListItem> items;
	
	public CustomListItemAdapter(Context context, List<CustomListItem> items) {
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
			customItemView = inflater.inflate(R.layout.custom_list_item, parent, false);
			Log.d(this.getClass().getName(), "created");
		} else {
			customItemView = convertView;
			Log.d(this.getClass().getName(), "recycled");
		}
		
		TextView titleTextView = (TextView)customItemView.findViewById(R.id.titleTextView);
		TextView descriptionTextView = (TextView)customItemView.findViewById(R.id.descriptionTextView);
		
		CustomListItem item = items.get(position);
		titleTextView.setText(item.getTitle());
		descriptionTextView.setText(item.getDescription());
		
		return customItemView;
	}

}
