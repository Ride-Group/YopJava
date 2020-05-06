# YopJava
基于YOP开放平台的SDK

### 使用SDK
```java
BaseResultT<Map<String, AvailableService>> availableService = ToftAPI.getAvailableService(ACCESS_TOKEN);
```

### 城市数据
```
cat city.txt|awk -F',' '{print "public final static String SHORT_"toupper($8)" = \""$8"\"; // "$6}'
cat country.txt|awk -F',' '{print "public final static String COUNTRY_"toupper($1)" = \""$1"\"; // "$5}'
cat airport.txt|sort -t ',' -k 7|awk -F',,,' '{print "public final static String AIRPORT_"toupper($3)"_"toupper($1)" = \""$1"\"; // "$2}'


cat city.txt|awk -F',' '{print "put(\""$6"\", \""$8"\");"}'
```

### 机场
```
LUM,,,德宏芒市机场,,,芒市,,,0,,,0,,,,,,,,,,,,
```

### Maven 引用方式
```xml
<dependency>
    <groupId>com.github.zhangchunsheng</groupId>
    <artifactId>yop-java</artifactId>
    <version>1.0.1</version>
</dependency>
```

### 订单推送接口说明
```
格式：{第三方推送url} + yongche_order_id=易到订单号&yongche_order_status=订单状态
```

```
易到会在订单状态发生变化的时候，给第三方推送相关信息,推送是从4开始推送，即 “司机确认” 开始的
```

```
对于状态是7，即服务结束的特殊说明（注意：以下说明的订单状态都是7）：

服务结束之后，在大概5分钟之后，会推送状态7，加上一个异常状态，见下表1)

结束之后，如果有异议或者是其他原因，客服调整金额，调整金额后，会推3）

正常确认账单之后，或者是异议订单处理之后，实际扣款时，相对于企业账户，就是扣企业的信用额度，会推4）
```

以下状态会在上面的基础上，加推一些信息：

|id|订单状态| 加推字段|说明
----|----|----|----
|1)|服务结束|abnormal|异常状态 详见“异常状态说明” 表
|2)|取消|reason_id|合作方取消全部是100，易到取消为实际原因id
|3)|调整金额|adjust_flag = 1 & abnormal|
|4)|扣款|withdraw_flag = 1|

异常状态说明

|状态id| 含义|说明|
----|----|----
|1|系统设置的异常||
|2|客户设置的异常||
|3|后台操作人员设置的异常||
|-1|异常已经处理完成||
|0|没有异常||

取消原因状态码说明

|状态码| 含义|说明|
----|----|----
|63001|无车可派||
|63002|有车无人接单(无有效司机接单)||
|63003|有司机接单，用户未选车，系统自动取消||
|63004|有司机接单，用户未选车，客户端自动取消||
|100|合作方取消||

合作方返回数据格式

例子：{"code":200,"msg":"OK"}
#### 数据说明

|字段|含义| 说明|
----|----|----
|code|状态| 200：正确返回  400：发生错误|
|msg|结果信息| 失败了返回错误原因|
