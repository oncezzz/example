## 数据结构

#### String
* key:value结构,一个key对应一个值
* get set incr decr等命令
* 计数,分布式锁,分布式会话ID等实现场景
#### Hash
* key:[["field01":value01],["field02":value02]]结构,一个key对应一个字典,字典二维数组形式 
* hset hget hexist等命令
* 缓存,描述一个object信息场景
#### List
* key:value01->value02结构,一个key对应一个有序列表
* lpush lpop rpush rpop lrang等命令
* 消息队列,有限列表更新等
#### Set
* key: field01 || field02结构,一个key对应多个field的无值散列表,无序,不重复
* sadd srem sdiff sinner sunion等命令
* 标签,事件类记录等操作,比如点赞 文章: 点赞人A || 点赞人B
#### ZSet
* key: source01:value01,source02:value02 对每个元素分配分数的有序集合(散列表+跳表)
* ZADD ZREM ZSCORE ZRANK ZRANFGE等命令
* 排序计算,比如排行榜

## 序列化

#### 串行序列化
* RedisSerializer实现
* RedisTemplate设置对应的key,value,hashKey,hashValue的序列化器

#### 响应式序列化
* RedisElementReader,RedisElementWriter控制读写

3.
