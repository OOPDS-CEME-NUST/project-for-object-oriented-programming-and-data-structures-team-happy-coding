package com.example.tazahgul.vehicleverification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {
    EditText t1, t2, t3, t4, t5, t6;
    sqlite mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        t1 = (EditText) findViewById(R.id.etname);
        t2 = (EditText) findViewById(R.id.etcnic_number);
        t3 = (EditText) findViewById(R.id.etage);
        t4 = (EditText) findViewById(R.id.etnumber);
        t5 = (EditText) findViewById(R.id.etmodel);
        t6 = (EditText) findViewById(R.id.etcolor);
        mydb=Temp.getMydb();

    }

    public void Update(View view) {

        String name=t1.getText().toString();
        String cnic=t2.getText().toString();
        String age=t3.getText().toString();
        String id= t4.getText().toString();
        String vmodel=t5.getText().toString();
        String vcolor=t6.getText().toString();
        if(name.equals("")||cnic.equals("")||age.equals("")||id.equals("")||vmodel.equals("")||vcolor.equals(""))
        {
            Toast.makeText(this,"Plz fill All the Field",Toast.LENGTH_SHORT).show();
        }
        else
        {
            User user=new User();
            user.setName(name);
            user.setCnic(cnic);
            user.setAge(age);
         //   user.setId(id);
            user.setVmodel(vmodel);
            user.setVnumber(vcolor);
            boolean isupdate= mydb.updateData(user);
if(isupdate==true){
    Toast.makeText(this,"Record Updated",Toast.LENGTH_SHORT).show();
}else
{
    Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
}
        }
    }
}
