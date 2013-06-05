package net.stack3.listviewsample.choicesingle;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ChoiceSingleActivity extends Activity {
    private ArrayAdapter<String> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_single_activity);
        setTitle("ChoiceSingle");
        
        ArrayList<String> items = new ArrayList<String>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(listViewOnItemClickListener);
        
        Button addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(addButtonOnClickLisetenr);
        
        Button removeButton = (Button)findViewById(R.id.removeButton);
        removeButton.setOnClickListener(removeButtonOnClickLisetenr);
    }
    
    private OnItemClickListener listViewOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            ListView listView = (ListView)findViewById(R.id.listView);
            Log.d("", String.format("position:%d", listView.getCheckedItemPosition()));
        }
    };
    
    private OnClickListener addButtonOnClickLisetenr = new OnClickListener() {
        @Override
        public void onClick(View view) {
            ListView listView = (ListView)findViewById(R.id.listView);
            int position = listView.getCheckedItemPosition();
            if (position >= 0) {
                adapter.insert("New Item", position + 1);
            } else {
                adapter.add("New Item");
            }
        }
    };

    private OnClickListener removeButtonOnClickLisetenr = new OnClickListener() {
        @Override
        public void onClick(View view) {
            ListView listView = (ListView)findViewById(R.id.listView);
            int position = listView.getCheckedItemPosition();
            if (position >= 0) {
                String item = adapter.getItem(position);
                adapter.remove(item);
            }
        }
    };    
}
