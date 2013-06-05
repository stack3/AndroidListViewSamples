package net.stack3.listviewsample.customlistitem;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.model.CustomListItem;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustomListItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_view_activity);
        setTitle("CustomListItem");
        
        ArrayList<CustomListItem> items = new ArrayList<CustomListItem>();
        for (int i = 0; i < 100; i++) {
            CustomListItem item = new CustomListItem();
            item.setTitle(String.format("Item %d", i));
            item.setDescription(String.format("Description %d", i));
            items.add(item);
        }
        
        CustomListItemAdapter adapter = new CustomListItemAdapter(this, items);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
    }
    
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CustomListItem item = (CustomListItem)parent.getAdapter().getItem(position);
            Log.d(getClass().getName(), item.toString());
        }
    };
}
