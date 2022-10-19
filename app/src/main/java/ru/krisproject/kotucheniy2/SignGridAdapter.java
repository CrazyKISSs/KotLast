package ru.krisproject.kotucheniy2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SignGridAdapter extends BaseAdapter {

    Context context;
    String[] level_name;
    int[] image;

    LayoutInflater inflater;

    public SignGridAdapter(Context context, String[] level_name, int[] image) {
        this.context = context;
        this.level_name = level_name;
        this.image = image;
    }

    @Override
    public int getCount() {
        return level_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.grid_sign, null);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image_sign);
        TextView textView = convertView.findViewById((R.id.item_name_sign));

        imageView.setImageResource(image[position]);
        textView.setText(level_name[position]);


        return convertView;
    }
}
