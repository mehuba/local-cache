package com.hello;

/**
 * Created by Nico on 11/27/16 16:24.
 */
public interface Cacheable {

    /** By requiring all objects to determine their own expirations, the
    algorithm is abstracted from the caching service, thereby providing maximum
    flexibility since each object can adopt a different expiration strategy.
    */
    Object getIdentifier();
    /** This method will ensure that the caching service is not responsible for
    uniquely identifying objects placed in the cache.
    */
    boolean isExpired();
}
