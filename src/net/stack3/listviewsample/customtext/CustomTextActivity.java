package net.stack3.listviewsample.customtext;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomTextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_view_activity);
        setTitle("CustomText");

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            items.add(String.format("Item %d", i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_text_list_item, items);
        listView.setAdapter(adapter);
    }
}
