package com.example.hereshem.collegeapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hereshem on 2/12/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String dbName = "students";
    private static final int dbVersion = 1;

    public DbHelper(Context context){
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "cReATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "password TEXT," +
                "email TEXT," +
                "address TEXT," +
                "phone TEXT" +
                ")";
        Log.i("DEBUG", "Table onCreate Sql = " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS users"; // write drop syntax
        db.execSQL(sql);
        onCreate(db);
    }

    public void addUsers(Users user){
        String sql = "INSERT INTO users (name,email,password,address,phone) VALUES (" +
                "'" + user.getName() + "'," +
                "'" + user.getEmail() + "'," +
                "'" + user.getPass() + "'," +
                "'" + user.getAddress() + "'," +
                "'" + user.getPhone() + "'" +
                ")";

        Log.i("DEBUG", "Insert sql = " + sql);
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateUser(Users user){
        //do yourself
    }
    public void deleteUsers(){
        //do yourself
    }
    public void deleteUserByID(int id){
        //do yourself
    }

    public List<Users> getUsers(){
        List<Users> usersList = new ArrayList<>();

        String sql = "select * from users";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(1);
                String pass = cursor.getString(2);
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String address = cursor.getString(4);
                String phone = cursor.getString(5);
                Users u = new Users(name, pass, email, address, phone);
                usersList.add(u);

            }while (cursor.moveToNext());
        }


        return usersList;
    }


}
