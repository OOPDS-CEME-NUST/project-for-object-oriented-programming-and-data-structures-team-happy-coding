package com.example.tazahgul.vehicleverification;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        TableLayout tableLayout=(TableLayout)findViewById(R.id.tablelayout) ;
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setShrinkAllColumns(true);

        TableRow rowTitle=new TableRow(this);
        rowTitle.setGravity(Gravity.CENTER);

        TableRow trow=new TableRow(this);

        TextView textView=new TextView(this);
        textView.setText("User Details....");

        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.SERIF,Typeface.BOLD);
        rowTitle.addView(textView);

        TextView t1=new TextView(this);
        TextView t2=new TextView(this);
        TextView t3=new TextView(this);
        TextView t4=new TextView(this);
        TextView t5=new TextView(this);
        TextView t6=new TextView(this);

        t1.setText("VNumber|");
        t2.setText("Name|");
        t3.setText("CNIC Number|");
        t4.setText("Age|");
        t5.setText("VModel|");
        t6.setText("VColor|");

        t1.setPadding(8,0,8,0);
        t2.setPadding(8,0,8,0);
        t3.setPadding(8,0,8,0);
        t4.setPadding(8,0,8,0);
        t5.setPadding(8,0,8,0);
        t6.setPadding(8,0,8,0);

        linearLayout.addView(t1);
        linearLayout.addView(t2);
        linearLayout.addView(t3);
        linearLayout.addView(t4);
        linearLayout.addView(t5);
        linearLayout.addView(t6);
        trow.addView(linearLayout);

        tableLayout.addView(rowTitle);
        tableLayout.addView(trow);

        sqlite mydb=Temp.getMydb();
        ArrayList<User>arrayList=mydb.viewUser();
        for(final User u:arrayList)
        {
        LinearLayout linearLayout1=new LinearLayout(this);
        TableRow tableRow=new TableRow(this);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
            TextView t7=new TextView(this);
            TextView t8=new TextView(this);
            TextView t9=new TextView(this);
            TextView t10=new TextView(this);
            TextView t11=new TextView(this);
            TextView t12=new TextView(this);


            t7.setText(u.getName());
            t8.setText(u.getCnic());
            t9.setText(u.getAge());
          //  t10.setText(u.getId());
            t11.setText(u.getVmodel());
            t12.setText(u.getVnumber());

            t7.setPadding(10,0,10,0);
            t8.setPadding(10,0,10,0);
            t9.setPadding(10,0,10,0);
            t10.setPadding(10,0,10,0);
            t11.setPadding(10,0,10,0);
            t12.setPadding(10,0,10,0);

            linearLayout1.addView(t7);
            linearLayout1.addView(t8);
            linearLayout1.addView(t9);
            linearLayout1.addView(t10);
            linearLayout1.addView(t11);
            linearLayout1.addView(t12);

            tableRow.addView(linearLayout1);
            tableLayout.addView(tableRow);
            linearLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ViewUser.this,u.getName(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
