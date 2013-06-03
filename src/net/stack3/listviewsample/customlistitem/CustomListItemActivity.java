package net.stack3.listviewsample.customlistitem;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomListItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.custom_list_item_activity);
		
		ListView listView = (ListView)findViewById(R.id.listView);
		
		ArrayList<CustomListItem> items = new ArrayList<CustomListItem>();
		for (int i = 0; i < 100; i++) {
			CustomListItem item = new CustomListItem();
			item.setTitle(String.format("Item %d", i));
			item.setDescription(String.format("Description %d", i));
			items.add(item);
		}
		
		CustomListItemAdapter adapter = new CustomListItemAdapter(this, items);
		listView.setAdapter(adapter);
	}
}
