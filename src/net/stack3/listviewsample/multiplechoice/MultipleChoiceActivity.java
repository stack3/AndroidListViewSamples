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
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);
        
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setItemChecked(0, true);
        listView.setOnItemClickListener(listViewOnItemClickListener);
        
        Button infoButton = (Button)findViewById(R.id.infoButton);
        infoButton.setOnClickListener(infoButtonOnClickListener);
    }
    
    private OnItemClickListener listViewOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Log.d("", String.format("Checked position:%d", position));
        }
    };
    
    private OnClickListener infoButtonOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ListView listView = (ListView)findViewById(R.id.listView);
            SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
            for (int i = 0; i < checkedItemPositions.size(); i++) {
                Log.d("", String.format("Checked position:%d %b", i, checkedItemPositions.valueAt(i)));
            }
        }
    };
}
