package com.example.tazahgul.vehicleverification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;
import static android.icu.lang.UProperty.AGE;
import static android.os.Build.ID;
import static android.os.Build.MODEL;
import static android.provider.Contacts.SettingsColumns.KEY;
import static android.util.JsonToken.NAME;
import static java.sql.Types.INTEGER;
import static java.text.Collator.PRIMARY;
import static org.xmlpull.v1.XmlPullParser.TEXT;


public class sqlite extends SQLiteOpenHelper {
    String TABLE_NAME = "Vehicletable";
    private static String key_id = "id";
    private static String COL_1 = "Name";
    private static String COL_2 = "CNICNumber";
    private static String COL_3 = "Age";
    private static String COL_4 = "VehicleNumber";
    private static String COL_5 = "VehicleModel";
    private static String COL_6 = "VehicleColor";
    private long a;

    public sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // String create_table="CREATE TABLE "+TABLE_NAME+"("+COL_1+"TEXT,"+COL_2+"TEXT,"+COL_3+"TEXT,"+COL_4+"INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_5+"TEXT,"+COL_6+"TEXT"+")";
        String create_table = " CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_1 + " TEXT NOT NULL, " +
                COL_2 + " INTEGER NOT NULL, " +
                COL_3 + " INTEGER NOT NULL, " +
                COL_4 + " INTEGER NOT NULL, " +
                COL_5 + " INTEGER NOT NULL," +
                COL_6 + " TEXT NOT NULL)";

        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    public int insertUser(User user) {
       int i = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, user.getName());
        contentValues.put(COL_2, user.getCnic());
        contentValues.put(COL_3, user.getAge());
        contentValues.put(COL_4, user.getVnumber());
        contentValues.put(COL_5, user.getVmodel());
        contentValues.put(COL_5, user.getVnumber());
         db.insert(TABLE_NAME, null, contentValues);
        i = 1;
        return i;
    }

    public int DeleteUser(String ID) {
        int i = 0, a = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, key_id + " = ?", new String[]{ID});
        db.close();
        i = 1;
        return i;
    }

    public ArrayList<User> viewUser() {
        String st = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery(st, null);
        cursor.close();
        ArrayList<User> arrayList = new ArrayList<User>();
        if (cursor.moveToFirst()) {
            do {

                User user = new User();
                user.setName(cursor.getString(0));
                user.setCnic(cursor.getString(1));
                user.setAge(cursor.getString(2));
                // user.setId(cursor.getString(3));
                user.setVmodel(cursor.getString(4));
                user.setVnumber(cursor.getString(5));
                arrayList.add(user);
            }
            while (cursor.moveToNext());
        }
        return arrayList;
    }


    public boolean updateData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues.put(key_id,user.getId());
        contentValues.put(COL_2, user.getName());
        contentValues.put(COL_3, user.getCnic());
        contentValues.put(COL_4, user.getAge());
        contentValues.put(COL_5, user.getVmodel());
        contentValues.put(COL_6, user.getVnumber());
        // db.update(TABLE_NAME, contentValues, "id=?",new String[] { user.getId() });
        return true;
    }
}
