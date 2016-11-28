package com.hello;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nico on 11/27/16 16:40.
 */
public class CacheManager {
    public static Map cachedMap = new HashMap();

    static {
        Thread cleanerThread = new Thread(new Runnable() {
            int milliSecondToSleep = 5000;
            public void run() {
                try {
                    while (true) {
                        Set keySet = cachedMap.keySet();
                        Iterator keys = keySet.iterator();
                        while (keys.hasNext()) {
                            Object key = keys.next();
                            Cacheable value = (Cacheable) cachedMap.get(key);
                            if (value.isExpired()) {
                                cachedMap.remove(key);
                                System.out.println("remove cache");
                            }
                        }
                        Thread.sleep(milliSecondToSleep);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        cleanerThread.setPriority(Thread.MIN_PRIORITY);
        cleanerThread.start();
    }

    public static void putCache(Cacheable object) {
        cachedMap.put(object.getIdentifier(), object);
    }

    public static Cacheable getCache(Object id) {
        Cacheable object = (Cacheable) cachedMap.get(id);
        if (object == null) {
            return null;
        }
        if (object.isExpired()) {
            cachedMap.remove(object.getIdentifier());
            return null;
        } else {
            return object;
        }
    }
}
