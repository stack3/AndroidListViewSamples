package net.stack3.listviewsample;

import java.util.ArrayList;

import net.stack3.listviewsample.customlistitem.CustomListItemActivity;
import net.stack3.listviewsample.customtext.CustomTextActivity;
import net.stack3.listviewsample.multiplelistitemtype.MultipleListItemTypeActivity;
import net.stack3.listviewsample.simplelistactivity.SimpleListActivity;
import net.stack3.listviewsample.simplelistview.SimpleListViewActivity;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	private ArrayList<MenuItem> items;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		items = new ArrayList<MenuItem>();
		
		MenuItem item;

		item = new MenuItem();
		item.setTitle("SimpleListActivity");
		item.setActivityClass(SimpleListActivity.class);
		items.add(item);		
		
		item = new MenuItem();
		item.setTitle("SimpleListView");
		item.setActivityClass(SimpleListViewActivity.class);
		items.add(item);

		item = new MenuItem();
		item.setTitle("CustomText");
		item.setActivityClass(CustomTextActivity.class);
		items.add(item);
		
		item = new MenuItem();
		item.setTitle("CustomItem");
		item.setActivityClass(CustomListItemActivity.class);
		items.add(item);

		item = new MenuItem();
		item.setTitle("MultipleListItemType");
		item.setActivityClass(MultipleListItemTypeActivity.class);
		items.add(item);
		
		ArrayAdapter<MenuItem> adapter = new ArrayAdapter<MenuItem>(this, android.R.layout.simple_list_item_1, items);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		MenuItem item = items.get(position);
		Intent intent = new Intent(this, item.getActivityClass());
		startActivity(intent);
	}
}
