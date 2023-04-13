package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

import java.sql.SQLOutput;
import java.util.List;

public class JedisSingleTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        JedisPool jedisPool = new JedisPool(config, "192.168.206.128",6379, 3000, "admin");
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            System.out.println(jedis.set("zhouming2", "88887"));
            System.out.println(jedis.get("zhouming2"));

            // 获取管道 --无法保证原子性
            Pipeline pl = jedis.pipelined(); // 获取管道
            for (int i = 0; i < 10; i ++) {
                pl.incr("leirongKey");
                pl.set("zhou"+i, "key"+i);
            }
            List<Object> results = pl.syncAndReturnAll(); // 发送命令
            System.out.println(results);

        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
