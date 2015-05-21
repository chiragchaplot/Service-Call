package com.tseapp.paperbind.servicecall;

import android.provider.BaseColumns;

/**
 * Created by chiragchaplot on 5/4/15.
 */
public class engineer_contract
{
    public static final String DB_NAME = "com.tseapp.paperbind.engineers.db.entries";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "engineers";

    public class Columns
    {
        public final static String
                NAME = "name",
                EMAIL = "email",
                PHONE="phone",
                EMP_ID="emp_id";

        public static final String _ID = BaseColumns._ID;
    }
}