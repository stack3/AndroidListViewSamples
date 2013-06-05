package net.stack3.listviewsample.multipletype;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import net.stack3.listviewsample.model.CustomListItem;
import net.stack3.listviewsample.model.CustomListItem2;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MultipleTypeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_view_activity);
        setTitle("MultipleType");

        ArrayList<Object> items = new ArrayList<Object>();
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

        MultipleTypeAdapter adapter = new MultipleTypeAdapter(this, items);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
