package com.test.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		//连接本地Redis，需要打开redis服务,获取一个实例
	    Jedis jedis = new Jedis("192.168.2.225");
	    jedis.auth("mytest");
	    System.out.println("连接redis服务成功");
	    //查看服务是否运行
	    System.out.println("Server is running: "+jedis.ping());
	    //设置 redis 字符串数据
	    jedis.set("testkey1", "Redis tutorial1");
	    jedis.set("testkey2", "Redis tutorial2");
	    jedis.set("testkey3", "25");

	    //重命名指定key，返回一个操作结果状态码，两个key相同则会抛出错误
	    String status = jedis.rename("testkey1", "rename-testkey1");
	    System.out.println("status of this operation : "+status);

	    //查看key对应value的类型
	    System.out.println("the type of the value: "+ jedis.type("testkey1"));
	    System.out.println("the type of the value: "+ jedis.type("testkey2"));
	    System.out.println("the type of the value: "+ jedis.type("testkey3"));

	    //取随机key
	    System.out.println("the random key: "+ jedis.randomKey()); 

	    //取出所有符合匹配条件的key（详解请查看API），并迭代
	    Set<String> set = jedis.keys("test*");
	    Iterator<String> item = set.iterator();
	    while (item.hasNext()) {
	        System.out.println("the key is : "+ item.next());
	    }

	    //“NX”--当此key不存在时创建. “XX”--只有此key存在时会替换value.
	    jedis.set("testkey2", "Redis tutorial2", "NX");
	    jedis.set("testkey2", "Redis tutorial3", "XX");

	    // 获取存储的数据并输出
	    System.out.println("Stored string in redis:: "+ jedis.get("testkey1"));
	    System.out.println("Stored string in redis:: "+ jedis.get("testkey2"));
	    System.out.println(jedis.exists("testkey2"));

	    //删除多个key，返回删除个数
	    long count = jedis.del("testkey1","testkey2","testkey3");
	    System.out.println(count);
	    System.out.println("Stored string in redis:: "+ jedis.get("testkey2"));
	    
	    
//	    Map<String, String> map = new HashMap<String, String>();
//        map.put("test" + 0, "value" + 0);
//        map.put("test" + 1, "value" + 1);
//        map.put("test" + 2, "value" + 2);
//        jedis.hmset("redismapTest", map);
//        
//        Map<String, String> map2 = jedis.hgetAll("redismapTest");
//        
//        System.out.println(map2);
        

	}

}
