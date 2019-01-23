package com.example.tazahgul.vehicleverification;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Delete extends AppCompatActivity {
    Button btnDelete;
    sqlite mydb;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        btnDelete = (Button) findViewById(R.id.button_delete2);
        id = (EditText) findViewById(R.id.etid2);

    }

    public void delete(View view) {
        String ID=id.getText().toString();
        if(ID.equals(""))
        {
            Toast.makeText(this,"Enter Your Unique ID First",Toast.LENGTH_SHORT).show();
        }
        else
        {
        mydb=Temp.getMydb();
          int  i= mydb.DeleteUser(ID);
            if(i == 1)
                Toast.makeText(Delete.this,"User Info Delete",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(Delete.this,"Something went wrong",Toast.LENGTH_SHORT).show();
        }
    }
}
