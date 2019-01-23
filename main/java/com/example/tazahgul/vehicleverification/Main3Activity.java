package com.example.tazahgul.vehicleverification;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {
    sqlite mydb;
    EditText editName, editcnic, editage, editvnumber, editvmodel, editvcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mydb=new sqlite(getApplicationContext(),"TazahGul.db",null,1);
        Temp.setMydb(mydb);
        Button btnDelete=(Button)findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick (View v){
                                           startActivity(new Intent(Main3Activity.this, Delete.class));

                                       }
                                   }
        );
        Button btnviewAll=(Button)findViewById(R.id.button_viewAll);
        btnviewAll.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick (View v){
                                           startActivity(new Intent(Main3Activity.this, ViewUser.class));

                                       }
                                   }
        );
        Button btnviewUpdate=(Button)findViewById(R.id.button_update);
        btnviewUpdate.setOnClickListener(new View.OnClickListener()

                                   {
                                       @Override
                                       public void onClick (View v){
                                           startActivity(new Intent(Main3Activity.this, UpdateUser.class));

                                       }
                                   }
        );


        Button btnAddData=(Button)findViewById(R.id.button_adddata);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this,InsertUser.class));

            }
        });
    }

}