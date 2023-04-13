package redis;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class JedisSentinelTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        String mymaster = "mymaster";
        Set<String> senteinels = new HashSet<>();
        senteinels.add(new HostAndPort("192.168.206.128",26379).toString());
        senteinels.add(new HostAndPort("192.168.206.128",26380).toString());
        senteinels.add(new HostAndPort("192.168.206.128",26381).toString());
        JedisSentinelPool pool = new JedisSentinelPool(mymaster, senteinels, config, 3000, "admin");
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            System.out.println(jedis.set("shileirong", "666"));
            System.out.println(jedis.get("shileirong"));
        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }


    }

}
