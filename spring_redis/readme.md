## 数据结构

#### key-value
* redis都是基于key-value结构存储的,key,value并非简单的string类型,而是object对象
* redis object对象结构由 type:对象类型 encoding:编码格式 pre:底层实现数据结构指针 组成

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

## 过期策略

* 惰性删除+定期删除结合
* 定期删除:定时间隔时间对过期键进行删除,配置参数hz(默认10,即为每秒执行10次)
* 惰性删除:获取时候进行判断,过期删除

## 内存淘汰
* 过期策略无法满足清除要求,可以设置内存最大使用量(maxmemory bytes,64机器默认不设置,32机器3G),执行内存淘汰策略(配置maxmemory-policy,默认noeviction)
* noeviction：写入操作会报错
* allkeys-lru：移除最近最少使用的key
* allkeys-random：随机移除某个key
* volatile-lru：在设置了过期时间的键空间中，移除最近最少使用的key
* volatile-random：在设置了过期时间的键空间中，随机移除某个key
* volatile-ttl：在设置了过期时间的键空间中，有更早过期时间的key优先移

## 持久化

### RDB
* 快照持久化,RDB是一个二进制持久化文件,redis可以通过它来恢复数据(恢复期间,处于阻塞状态)
* SAVE,BGSAVE命令执行持久化操作,save阻塞,bgsave子线程执行不阻塞
* 参数配置 save 9000 1 (900之后,存在1个key发生了变化),执行bgsave


### AOF
* 文件追加,通过保存redis执行的命令记录来持久化数据
* AOF实现,命令追加写入aof_buf缓冲区,flushAppendOnlyFile判断是否写入AOF文件(appendfsync 参数配置决定,默认everysec每秒同步一次),最后同步AOF
* 数据恢复,RDB,AOF会优先使用AOF,创建本地伪客户端循环执行AOF存的命令
* AOF重写,redis会根据当前数据库存在数据对AOF文件进行重写,减少多余命令,创建子线程,执行AOF重写(缓冲区)
