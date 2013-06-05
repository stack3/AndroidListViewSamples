package net.stack3.listviewsample.choicesingle;

import java.util.List;

import net.stack3.listviewsample.R;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChoiceSingleListItemAdapter extends ArrayAdapter<String> {
    public ChoiceSingleListItemAdapter(Context context, List<String> items) {
        super(context, 0, items);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.choice_single_list_item,  parent, false); 
        }
        
        String item = getItem(position);
        
        TextView textView = (TextView)convertView.findViewById(R.id.textView);
        textView.setText(item);
        
        ListView listView = (ListView)parent;
        Resources resources = context.getResources();
        if (listView.getCheckedItemPosition() == position) {
            convertView.setBackgroundColor(resources.getColor(R.color.green));
        } else {
            convertView.setBackgroundColor(resources.getColor(R.color.white));
        }
        
        return convertView;
    }
}
