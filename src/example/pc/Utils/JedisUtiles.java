package example.pc.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtiles {
//    private static JedisPool pool = new JedisPool("127.0.0.1",6379);

    public static Jedis getJedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
//        Jedis jedis = pool.getResource();
        return jedis;
    }


}
