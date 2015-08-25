package com.example.loc.water_body.Dao_Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.loc.water_body.Database.dbHeleper;
import com.example.loc.water_body.Model.UserInformation_Model;

import java.util.ArrayList;

/**
 * Created by loc on 10/05/2015.
 */
public class Dao_UserInfomation {
    SQLiteDatabase db;

    public Dao_UserInfomation(Context context) {
        dbHeleper hp = new dbHeleper(context);
        db = hp.getWritableDatabase();
    }
    //  return "id" + IduserInfomation + ", name " + UserInformation_name + ", weight " + UserInformationWeight + ", water " + userInformationWater + ", unit " + IduserUnit + ", state   " + IduserState;
    //        String Create_User = "CREATE TABLE \"UserInformation\" (\"IdUser\" INTEGER PRIMARY KEY  AUTOINCREMENT , \"NameUser\" TEXT, \"UserWeight\" DOUBLE, \"UserWater\" DOUBLE, \"IdUserUnit\" INTEGER, \"IdUserState\" INTEGER)";

    public void InserDb(UserInformation_Model md) {
        ContentValues values = new ContentValues();
        values.put("NameUser", md.getUserInformation_name());
        values.put("UserWeight", md.getUserInformationWeight());
        values.put("UserWater", md.getUserInformationWater());
        values.put("IdUserUnit", md.getIduserUnit());
        values.put("IdUserStateSport", md.getIduserStateSport());
        values.put("IdUserStateSunny", md.getIduserStateSunny());
        db.insert("UserInformation", null, values);
//        db.close();
    }

    public ArrayList<UserInformation_Model> getAllUserInformation() {
        ArrayList<UserInformation_Model> list = new ArrayList<UserInformation_Model>();
        String SelecAll = " select * from  UserInformation  ";
        Cursor cursor = db.rawQuery(SelecAll, null);
        if (cursor.moveToFirst()) {
            do {
                UserInformation_Model md = new UserInformation_Model();

                md.setIduserInfomation(cursor.getInt(cursor.getColumnIndex("IdUser")));

                md.setUserInformation_name(cursor.getString(cursor.getColumnIndex("NameUser")));

                md.setIduserStateSunny(cursor.getInt(cursor.getColumnIndex("IdUserStateSunny")));

                md.setIduserStateSport(cursor.getInt(cursor.getColumnIndex("IdUserStateSport")));

                md.setUserInformationWeight(cursor.getDouble(cursor.getColumnIndex("UserWeight")));

                md.setUserInformationWater(cursor.getDouble(cursor.getColumnIndex("UserWater")));

                md.setIduserUnit(cursor.getInt(cursor.getColumnIndex("IdUserUnit")));
                list.add(md);
            } while (cursor.moveToNext());


        }


        return list;
    }
//    public ArrayList<>

}
