package com.asus.gl.androidweek9_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText edt_query;
    TextView tv_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= getApplicationContext().openOrCreateDatabase("mydb",MODE_PRIVATE,null);

        if(!isTableExist("Students")) {
            loadFromDumpFile();
        }
        edt_query = findViewById(R.id.edt_query);
        tv_res = findViewById(R.id.txtRes);

    }


    private void loadFromDumpFile(){
        Scanner scn = new Scanner(getResources().openRawResource(R.raw.db));
        String query="";

        while(scn.hasNext()){
            query+= scn.nextLine() + "\n";
            if(query.trim().endsWith(";")){
                db.execSQL(query);
                Log.d("DBDB",query);
                query="";
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase("mydb", null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
            Log.d("DBDB","Database not exist!");
        }
        return checkDB != null;
    }

    private boolean isTableExist(String tblName){
        boolean tableExists = false;

        Cursor c;
        try
        {
            c = db.query(tblName, null,
                    null, null, null, null, null);
            tableExists = true;
        }
        catch (Exception e) {
    /* fail */
            Log.d("DBDB",  tblName + " doesn't exist!");
        }

        return tableExists;
    }

    public void query(View view) {

        String query = edt_query.getText().toString();
        if(db == null){
            db= openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        }
        try {
            Cursor cr = db.rawQuery(query, null);
            if (!cr.moveToFirst()) {
                Toast.makeText(this, "DB not loaded", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder sb = new StringBuilder();
            int col_count = cr.getColumnCount();
            do {
                for (int i = 0; i < col_count; i++) {
                    sb.append(cr.getString(i));
                    sb.append(" ");
                }
                sb.append("\n");


            } while (cr.moveToNext());

            cr.close();
            tv_res.setText(sb.toString());
        }catch (SQLiteException e){
            Toast.makeText(this,"DB error:" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }








        /*String query = edt_query.getText().toString();

        if(db==null){
            Toast.makeText(this, "DB null...", Toast.LENGTH_SHORT).show();
        }
        Cursor cr = db.rawQuery(query,null);

        if(!cr.moveToFirst()){
            Toast.makeText(this,"DB not loaded", Toast.LENGTH_LONG).show();
        }

        StringBuilder sb = new StringBuilder();

        do{
            for(int i=0;i <cr.getColumnCount();i++) {
                String s = cr.getString(i);//cr.getColumnIndex("Name"));
                sb.append(s); sb.append(" ");
            }
            sb.append("\n");

        }while(cr.moveToNext());
        cr.close();
        tv_res.setText(sb.toString());*/

    }
}
