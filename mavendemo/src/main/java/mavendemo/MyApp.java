package mavendemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class MyApp {
	public static void main(String[] args) {
		try 
		{
			JedisShardInfo shardInfo = new JedisShardInfo("redis-14050.c54.ap-northeast-1-2.ec2.cloud.redislabs.com", 14050);
			shardInfo.setPassword("redisdb");
			
		    Jedis jedis = new Jedis(shardInfo);
			// prints out "Connection Successful" if Java successfully connects to Redis server.
			System.out.println("Connection Successful");
			System.out.println("The server is running " + jedis.ping());
			jedis.set("company-name", "500Rockets.io");
			System.out.println("Stored string in redis:: "+ jedis.get("company-name"));
		}
		catch(Exception e) {
		    System.out.println(e);
			
		}
		
	}
}
