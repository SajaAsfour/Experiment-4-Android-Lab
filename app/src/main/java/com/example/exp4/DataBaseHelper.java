package com.example.exp4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
public class DataBaseHelper extends SQLiteOpenHelper{
    private static final String name = "myDataBase.db";
    private static final int DataBase_version =1;

    public DataBaseHelper(Context contex , String name , SQLiteDatabase.CursorFactory factory , int dataBase_version){
        super(contex, name,factory,dataBase_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("Create Table Customer(ID LONG PRIMARY KEY , NAME TEXT" +
                ",PHONE TEXT , GENDER TEXT ,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCustomer (Customer customer){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID" , customer.getmCustomerID());
        contentValues.put("Name" , customer.getmName());
        contentValues.put("Email" , customer.getmEmail());
        contentValues.put("Phone" ,customer.getmPhone());
        contentValues.put("Gender" , customer.getmGender());
        sqLiteDatabase.insert("CUSTOMER" , null , contentValues);
    }

    public Cursor getAllCustomers(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER", null);
    }

    public Cursor getCustomersById(String id){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER WHERE id =?" ,new String[]{id});
    }
}
