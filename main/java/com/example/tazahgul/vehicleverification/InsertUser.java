package com.example.tazahgul.vehicleverification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertUser extends AppCompatActivity {
    EditText t1, t2, t3, t4, t5, t6;
    sqlite mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
        t1 = (EditText) findViewById(R.id.name);
        t2 = (EditText) findViewById(R.id.cnic_number);
        t3 = (EditText) findViewById(R.id.etage);
        t4 = (EditText) findViewById(R.id.etvnumber);
        t5 = (EditText) findViewById(R.id.etmodel);
        t6 = (EditText) findViewById(R.id.etvcolor);
        mydb=Temp.getMydb();
    }

    public void Save(View view)
    {

                String name=t1.getText().toString();
                String cnic=t2.getText().toString();
                String age=t3.getText().toString();
                String vnumber = t4.getText().toString();
                String vmodel=t5.getText().toString();
                String vcolor=t6.getText().toString();
                if(name.equals("")||cnic.equals("")||age.equals("")||vcolor.equals("")||vmodel.equals("")||vnumber.equals(""))
                {
                    Toast.makeText(this,"Plz fill All the Field",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user=new User();
                    user.setName(name);
                    user.setCnic(cnic);
                    user.setAge(age);
                    user.setVnumber(vnumber);
                    user.setVmodel(vmodel);
                    user.setVmodel(vcolor);
                   int i= mydb.insertUser(user);
                    if(i == 1)
                        Toast.makeText(InsertUser.this,"User Data Inserted",Toast.LENGTH_LONG).show();
                   else
                       Toast.makeText(InsertUser.this,"User Data not Inserted",Toast.LENGTH_LONG).show();
    }
}
    }