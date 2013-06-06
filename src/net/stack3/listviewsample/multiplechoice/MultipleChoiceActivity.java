package net.stack3.listviewsample.multiplechoice;

import java.util.ArrayList;

import net.stack3.listviewsample.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MultipleChoiceActivity extends Activity {
    private ArrayAdapter<String> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_choice_activity);
        setTitle("MultipleChoice");
        
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            items.add(String.format("Item %d", i));
        }
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);
        
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewOnItemClickListener);
        
        Button infoButton = (Button)findViewById(R.id.infoButton);
        infoButton.setOnClickListener(infoButtonOnClickListener);
    }
    
    private OnItemClickListener listViewOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            ListView listView = (ListView)adapterView;
            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
            Log.d("", String.format("position:%d checked:%b", position, checkedItemPositions.get(position)));
        }
    };
    
    private OnClickListener infoButtonOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ListView listView = (ListView)findViewById(R.id.listView);
            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checkedItemPositions.size(); i++) {
                int itemIndex = checkedItemPositions.keyAt(i);
                sb.append(String.format("index:%d value:%b\n", itemIndex, checkedItemPositions.get(itemIndex)));
            }
            Log.d("", sb.toString());
            Log.d("", "---");
            sb.setLength(0);
            for (int position = 0; position < adapter.getCount(); position++) {
                sb.append(String.format("position:%d checked:%b\n", position, checkedItemPositions.get(position)));
            }
            Log.d("", sb.toString());
        }
    };
}
