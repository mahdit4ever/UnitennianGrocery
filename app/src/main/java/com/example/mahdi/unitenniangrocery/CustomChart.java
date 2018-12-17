package com.example.mahdi.unitenniangrocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Stack;

/**
 * Created by mahdi on 9/1/2016.
 */
  class CustomChart extends BaseAdapter {

    Stack <String> result = new Stack();
    Stack <Double> amount = new Stack();

    NumberFormat nm = NumberFormat.getNumberInstance();

    Context context;

    private static LayoutInflater inflater = null;

    public CustomChart(Giant giant, Stack <String> Giant, Stack <Double> GiantQ) {
        result = Giant;
        context = giant;
        amount = GiantQ;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomChart(Mydin mydin, Stack <String> Mydin, Stack <Double> MydinQ) {
        result = Mydin;
        context = mydin;
        amount = MydinQ;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomChart(Tesco tesco, Stack <String> Tesco, Stack <Double> TescoQ) {
        result = Tesco;
        context = tesco;
        amount = TescoQ;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {

        return result.size();
    }

    @Override
    public Object getItem(int position) {

        return result.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Holder {
        TextView tv1;
        TextView tv2;
        TextView multi;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.mychart, null);

        holder.tv1=(TextView)rowView.findViewById(R.id.chart);
        holder.tv2=(TextView)rowView.findViewById(R.id.amount);
        //holder.multi=(TextView)rowView.findViewById(R.id.multi);



        holder.tv1.setText(result.get(position));
        holder.tv2.setText(nm.format(amount.get(position)));


        return rowView;
    }

}
