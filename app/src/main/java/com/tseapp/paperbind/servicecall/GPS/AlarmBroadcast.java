package com.tseapp.paperbind.servicecall.GPS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by chiragchaplot on 4/7/15.
 */
public class AlarmBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
		/* we now have a wake lock until we return */

        if (TrackerService.service != null &&
                TrackerService.service.isRunning())
            TrackerService.service.findAndSendLocation();
    }
}