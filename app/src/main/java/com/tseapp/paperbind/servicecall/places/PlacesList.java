package com.tseapp.paperbind.servicecall.places;

/**
 * Created by chiragchaplot on 4/3/15.
 */

import com.google.api.client.util.Key;

import java.util.List;

public class PlacesList {

    @Key
    public String status;

    @Key
    public List<Place> results;

}