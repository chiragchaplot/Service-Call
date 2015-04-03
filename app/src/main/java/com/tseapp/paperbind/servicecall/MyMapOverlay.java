package com.tseapp.paperbind.servicecall;

/**
 * Created by chiragchaplot on 4/3/15.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.OverlayItem;

import java.util.ArrayList;

public class MyMapOverlay extends ItemizedOverlay {
    private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    private Context mContext;

    public MyMapOverlay(Drawable defaultMarker) {
        super(boundCenterBottom(de.faultMarker));
        // TODO Auto-generated constructor stub
    }

    public MyMapOverlay(Drawable defaultMarker, Context context) {
        super(boundCenterBottom(defaultMarker));
        mContext = context;
    }

    @Override
    protected OverlayItem createItem(int i) {
        // TODO Auto-generated method stub
        return mOverlays.get(i);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return mOverlays.size();
    }

    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    @Override
    protected boolean onTap(int index) {
        OverlayItem item = mOverlays.get(index);
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle(item.getTitle());
        dialog.setMessage(item.getSnippet());
        dialog.show();
        return true;
    }
}
