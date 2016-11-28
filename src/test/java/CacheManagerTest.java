import com.hello.CacheManager;
import com.hello.Cacheable;
import com.hello.CachedObject;

/**
 * Created by Nico on 11/28/16 10:13.
 */
public class CacheManagerTest {

    public static void main(String[] args) {

        String s = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        CachedObject cachedObject = new CachedObject(new Long(1234), s, 1);
        CacheManager.putCache(cachedObject);
        Cacheable cache = CacheManager.getCache(new Long(1234));
        if(cache == null) {
            System.out.println("CacheManagerTestProgram.Main:  FAILURE!  Object not Found.");
        }
        else {
            System.out.println("CacheManagerTestProgram.Main:  SUCCESS! " +
                    ((String) cachedObject.object).toString());
        }
    }
}
