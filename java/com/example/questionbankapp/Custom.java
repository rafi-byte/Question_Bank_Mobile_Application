package com.example.questionbankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom extends BaseAdapter {

    private ArrayList<Model>modelArrayList;
    private Context context;

    private int layout;

    //Generate constructor


    public Custom(ArrayList<Model> modelArrayList, Context context, int layout) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
  //create view holder inter class
    private class ViewHolder{
        TextView idtxt1,titletxt1,bodytxt1;
  }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder=new ViewHolder();
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(layout,null);
        viewHolder.idtxt1=convertView.findViewById(R.id.idtxt);
        viewHolder.titletxt1=convertView.findViewById(R.id.titletxt);
        viewHolder.bodytxt1=convertView.findViewById(R.id.bodyTxt);

        Model model=modelArrayList.get(position);
        viewHolder.idtxt1.setText("No:"+model.getId());
        viewHolder.titletxt1.setText("Question:"+model.getTitle());
        viewHolder.bodytxt1.setText("Answer:"+model.getBody());

        return convertView;
    }
}
