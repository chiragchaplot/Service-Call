package com.tseapp.paperbind.servicecall;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chiragchaplot on 5/4/15.
 */
public class engineer_helper extends SQLiteOpenHelper
{
    public engineer_helper(Context context)
    {
        super(context,engineer_contract.DB_NAME,null,engineer_contract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sqlQuery =
                String.format("CREATE TABLE %s(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "%s TEXT," +
                "%s TEXT," +
                "%s TEXT," +
                "%s TEXT,",
                engineer_contract.Columns.NAME,
                engineer_contract.Columns.PHONE,
                engineer_contract.Columns.EMAIL,
                engineer_contract.Columns.EMP_ID
                );

        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}
