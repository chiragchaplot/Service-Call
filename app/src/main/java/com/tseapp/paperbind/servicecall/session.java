package com.tseapp.paperbind.servicecall;

import android.graphics.Bitmap;
import android.text.format.Time;

/**
 * Created by chiragchaplot on 3/27/15.
 */
public class session
{
    //Jobs List and details
    public static job_list job;

    //Machine Details
    public static String machine_code;
    public static String barcode;

    //Employee Details
    public static String emp_id, emp_name,emp_phone, emp_email;
    public static boolean login;

    //Session Details
    public static boolean start_pressed;
    public static boolean started_home;
    public static boolean continue_pressed;
    public static boolean loggedin;

    //On Site Job Details
    public static String person_in_charge, phone_in_charge;
    public static String end_time;

    //ENd of Shift Person in charge
    public static Bitmap end_shift_sign;
    public static String end_person_in_charge, end_person_phone;

    //Knowledge Base
    public static String ans1,ans2,ans3;
    public static String status;
}
