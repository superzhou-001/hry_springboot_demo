package redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JedisClusterTest {
    public static void main(String[] args) throws IOException {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);
        Set<HostAndPort> clusterNodes = new HashSet<>();
        clusterNodes.add(new HostAndPort("192.168.206.120",8001));
        clusterNodes.add(new HostAndPort("192.168.206.120",8002));
        clusterNodes.add(new HostAndPort("192.168.206.124",8005));
        clusterNodes.add(new HostAndPort("192.168.206.124",8006));
        clusterNodes.add(new HostAndPort("192.168.206.128",8003));
        clusterNodes.add(new HostAndPort("192.168.206.128",8004));
        JedisCluster cluster = null;
        try {
            // connectionTimeOut 连接url超时时间
            // soTimeout 返回结果时间
            cluster = new JedisCluster(clusterNodes, 6000, 5000, 10, "admin", config);
            System.out.println(cluster.set("zhouming666", "66666"));
            System.out.println(cluster.get("zhouming666"));
        } catch (Exception e) {
            e.getLocalizedMessage();
        } finally {
            if (cluster != null) {
                cluster.close();
            }
        }
    }
}
