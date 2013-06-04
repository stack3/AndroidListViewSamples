package net.stack3.listviewsample.multiplelistitemtype;

import java.util.ArrayList;
import java.util.List;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.model.CustomListItem;
import net.stack3.listviewsample.model.CustomListItem2;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MultipleListItemTypeAdapter extends BaseAdapter {

	private Context context;
	private List<Object> items;
	private List<Object> viewTypes;
	
	public MultipleListItemTypeAdapter(Context context, List<Object> items) {
		this.context = context;
		this.items = items;
		this.viewTypes = new ArrayList<Object>();
		this.viewTypes.add(CustomListItem.class);
		this.viewTypes.add(CustomListItem2.class);
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
		
		Object baseItem = items.get(position);
		if (baseItem instanceof CustomListItem) {
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				customItemView = inflater.inflate(R.layout.custom_list_item, parent, false);
				Log.d(this.getClass().getName(), "custom 1 created");
			} else {
				customItemView = convertView;
				Log.d(this.getClass().getName(), "custom 1 recycled");
			}
			
			CustomListItem item = (CustomListItem)baseItem;
			TextView titleTextView = (TextView)customItemView.findViewById(R.id.titleTextView);
			TextView descriptionTextView = (TextView)customItemView.findViewById(R.id.descriptionTextView);
			titleTextView.setText(item.getTitle());
			descriptionTextView.setText(item.getDescription());
		} else { // CustomListItem2
			if (convertView == null) {
				LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				customItemView = inflater.inflate(R.layout.custom_list_item_2, parent, false);
				Log.d(this.getClass().getName(), "custom 2 created");
			} else {
				customItemView = convertView;
				Log.d(this.getClass().getName(), "custom 2 recycled");
			}
			
			CustomListItem2 item = (CustomListItem2)baseItem;
			TextView leftTextView = (TextView)customItemView.findViewById(R.id.leftTextView);
			TextView rightTextView = (TextView)customItemView.findViewById(R.id.rightTextView);
			leftTextView.setText(item.getLeftText());
			rightTextView.setText(item.getRightText());
		}
		
		return customItemView;
	}

	@Override
	public int getViewTypeCount() {
		return viewTypes.size();
	}
	
	@Override
	public int getItemViewType(int position) {
		Object item = items.get(position);
		return viewTypes.indexOf(item.getClass());
	}
}
