package net.stack3.listviewsample.multiplelistitemtype;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.model.BaseCustomListItem;
import net.stack3.listviewsample.model.CustomListItem;
import net.stack3.listviewsample.model.CustomListItem2;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MultipleListItemTypeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_list_view_activity);
		
		ListView listView = (ListView)findViewById(R.id.listView);
		
		ArrayList<BaseCustomListItem> items = new ArrayList<BaseCustomListItem>();
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				CustomListItem item = new CustomListItem();
				item.setTitle(String.format("Item %d", i));
				item.setDescription(String.format("Description %d", i));
				items.add(item);
			} else {
				CustomListItem2 item = new CustomListItem2();
				item.setLeftText(String.format("Left %d", i));
				item.setRightText(String.format("Right %d", i));
				items.add(item);
			}
		}
				
		MultipleListItemTypeAdapter adapter = new MultipleListItemTypeAdapter(this, items);
		listView.setAdapter(adapter);
	}
}