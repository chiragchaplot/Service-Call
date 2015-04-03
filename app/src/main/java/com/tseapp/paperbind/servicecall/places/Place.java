package com.tseapp.paperbind.servicecall.places;

/**
 * Created by chiragchaplot on 4/3/15.
 */

import com.google.api.client.util.Key;

import java.util.List;

public class Place {

    @Key
    public String id;

    @Key
    public String name;

    @Key
    public List<String> types;

    @Key
    public String formatted_address;

    @Key
    public String reference;

    @Override
    public String toString() {
        return name + " - " + id + " - " + reference;
    }

}
