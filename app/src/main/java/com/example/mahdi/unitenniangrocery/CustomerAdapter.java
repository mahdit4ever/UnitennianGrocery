package com.example.mahdi.unitenniangrocery;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by mahdi on 7/28/2016.
 */
class CustomAdapter extends BaseAdapter {

    String [] result;
    Context context;
    String [] amount;

    Double [] g_price;
    Double [] m_price;
    Double [] t_price;

    NumberFormat nm = NumberFormat.getNumberInstance();


    private static LayoutInflater inflater=null;

    public CustomAdapter(FreshVegetables freshVegetables, String[] Vegetables, String [] Amount, Double [] G_vegetable_price, Double [] M_vegetable_price, Double [] T_vegetable_price ) {
        result=Vegetables;
        context=freshVegetables;
        amount=Amount;

        g_price= G_vegetable_price;
        m_price =M_vegetable_price;
        t_price =T_vegetable_price;


        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public CustomAdapter(FreshFruits freshFruits, String[] Fruits, String [] Amount, Double [] G_fruit_price, Double [] M_fruit_price, Double [] T_fruit_price) {
        result=Fruits;
        context=freshFruits;
        amount=Amount;
        g_price=G_fruit_price;
        m_price=M_fruit_price;
        t_price=T_fruit_price;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomAdapter(BackedGoods backedGoods, String[] Backed_goods, String [] Amount, Double [] G_backed_price, Double [] M_backed_price, Double [] T_backed_price) {
        result = Backed_goods;
        context = backedGoods;
        amount = Amount;
        g_price = G_backed_price;
        m_price = M_backed_price;
        t_price = T_backed_price;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public CustomAdapter(OtherStuff otherStuff, String[] Other_stuff, String [] Amount, Double [] G_other_price, Double [] M_other_price, Double [] T_other_price) {
        result = Other_stuff;
        context = otherStuff;
        amount = Amount;
        g_price = G_other_price;
        m_price = M_other_price;
        t_price = T_other_price;

        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        return result.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;

        TextView giant;
        TextView mydin;
        TextView tesco;

        EditText quantity;
        Double quant;
        Button bt;
        CheckBox check;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list, null);



        holder.tv1=(TextView) rowView.findViewById(R.id.textView1);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);
        holder.bt=(Button) rowView.findViewById(R.id.addButton);

        holder.check=(CheckBox)rowView.findViewById(R.id.checkBox);

        holder.giant=(TextView)rowView.findViewById(R.id.gg_total);
        holder.mydin=(TextView)rowView.findViewById(R.id.mm_total);
        holder.tesco=(TextView)rowView.findViewById(R.id.tt_total);
        holder.quantity=(EditText)rowView.findViewById(R.id.quantity);

        holder.tv1.setText(result[position]);
        holder.tv2.setText(amount[position]);

        holder.giant.setText(nm.format(g_price[position]));
        holder.mydin.setText(nm.format(m_price[position]));
        holder.tesco.setText(nm.format(t_price[position]));


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Toast.makeText(context, "Giant:  RM  "+g_price[position]+"\n"+"Mydin: RM "+m_price[position]+"\n"+"Tesco: RM "+t_price[position], Toast.LENGTH_LONG).show();
            }
        });
             holder.bt.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (holder.check.isChecked()) {

                        holder.quant=Double.parseDouble(holder.quantity.getText().toString());

                        if (holder.quant<=0.9){

                            Toast.makeText(context, "this amount is not allowed", Toast.LENGTH_LONG).show();
                        }
                       else if (holder.quant==null){
                            Toast.makeText(context, "this amount is not allowed", Toast.LENGTH_LONG).show();
                        }

                        else {

                            Giant.Giant.push(result[position]);
                            Mydin.Mydin.push(result[position]);
                            Tesco.Tesco.push(result[position]);
                            Giant.GiantQ.push(holder.quant);
                            Mydin.MydinQ.push(holder.quant);
                            Tesco.TescoQ.push(holder.quant);

                            MainActivity.G_total = MainActivity.G_total + g_price[position] * holder.quant;
                            MainActivity.M_total = MainActivity.M_total + m_price[position] * holder.quant;
                            MainActivity.T_total = MainActivity.T_total + t_price[position] * holder.quant;

                            DecimalFormat format_2Places = new DecimalFormat("0.00");
                            MainActivity.G_total = Double.valueOf(format_2Places.format(MainActivity.G_total));

                            DecimalFormat format_3Places = new DecimalFormat("0.00");
                            MainActivity.M_total = Double.valueOf(format_2Places.format(MainActivity.M_total));

                            DecimalFormat format_1Places = new DecimalFormat("0.00");
                            MainActivity.T_total = Double.valueOf(format_2Places.format(MainActivity.T_total));

                            Toast.makeText(context, "Your total prices in the three markets are:" + "\n\n" + "Giant:  RM " + MainActivity.G_total + "\n\n" + "Mydin: RM " + MainActivity.M_total + "\n\n" + "Tesco: RM " + MainActivity.T_total, Toast.LENGTH_LONG).show();

                        }

                   }
                    else
                        Toast.makeText(context, "Please select item(s) first", Toast.LENGTH_LONG).show();
                }
            });

        return rowView;
    }
}

