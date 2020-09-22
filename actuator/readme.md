### spring boot actuator
## 配置
* 除了shutdown端点以外其他都默认开启,management.endpoints.enabled-by-default=false可关闭默认开启配置,management.endpoint.name.enabled=true指定某一单独端点开启
* management.endpoint.name.cache.time-to-live=10s 配置端点缓存时间
* management.endpoints.web.base-path 控制端点访问前置,默认/actuator,配置'/'会关闭展示所有可访问端点
## endpoints
* httptrace 默认开启,但是需要自己注入一个HttpTraceRepository,不然HttpTraceAutoConfiguration无效