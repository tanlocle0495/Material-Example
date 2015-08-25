package com.example.loc.water_body.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by loc on 10/05/2015.
 */
public class dbHeleper extends SQLiteOpenHelper {


    public dbHeleper(Context context) {
        super(context, "data.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_User = "CREATE TABLE \"UserInformation\" (\"IdUser\" INTEGER PRIMARY KEY  AUTOINCREMENT , \"NameUser\" TEXT, \"UserWeight\" DOUBLE, \"UserWater\" DOUBLE, \"IdUserUnit\" INTEGER, \"IdUserStateSport\" INTEGER, \"IdUserStateSunny\" INTEGER)";
        db.execSQL(Create_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table if exits " + "UserInformation");
        onCreate(db);

    }
}
