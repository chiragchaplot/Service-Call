package com.tseapp.paperbind.servicecall;

/**
 * Created by chiragchaplot on 3/27/15.
 */
<<<<<<< HEAD
public class job_list
{
    public String name, line1, area, city, state, pincode,phone,poc,ticket;

    public job_list(String name, String line1, String area, String city, String state, String pincode, String phone, String poc, String ticket)
    {
=======
public class job_list {
    public String name, line1, area, city, state, pincode, phone, poc, machine_code;

    public job_list(String name, String line1, String area, String city, String state, String pincode, String phone, String poc) {
>>>>>>> 41a668f5b63b191977a24f0e6903f563ee82a839
        this.name = name;
        this.line1 = line1;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.poc = poc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }


}
