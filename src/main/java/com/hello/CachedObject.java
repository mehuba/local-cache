package com.hello;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nico on 11/27/16 16:28.
 */
public class CachedObject implements Cacheable {

    private Object identifier = null;
    private Date dateOfExpiration = null;
    public Object object = null;

    public CachedObject(Object identifier, Object object, int minutesToLive) {
        this.identifier = identifier;
        this.object = object;
        if(minutesToLive != 0) {
            this.dateOfExpiration = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOfExpiration);
            calendar.add(Calendar.MINUTE, minutesToLive);
            dateOfExpiration = calendar.getTime();
        }
    }

    public Object getIdentifier() {
        return identifier;
    }

    public boolean isExpired() {
        if (dateOfExpiration != null) {
            if(dateOfExpiration.before(new Date())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
