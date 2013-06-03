package net.stack3.listviewsample.customitem;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.custom_item_activity);
		
		ListView listView = (ListView)findViewById(R.id.listView);
		
		ArrayList<CustomItem> items = new ArrayList<CustomItem>();
		for (int i = 0; i < 100; i++) {
			CustomItem item = new CustomItem();
			item.setTitle(String.format("Item %d", i));
			item.setDescription(String.format("Description %d", i));
			items.add(item);
		}
		
		CustomItemAdapter adapter = new CustomItemAdapter(this, items);
		listView.setAdapter(adapter);
	}
}
