package net.stack3.listviewsample.simplelistactivity;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_activity);
        setTitle("SimpleListActivity");

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            items.add(String.format("Item %d", i));
        }		
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        String item = (String)listView.getAdapter().getItem(position);
        Log.d(getClass().getName(), item);
    };
}
