
#亿方云开放平台JAVA-SDK使用说明
##目录
[TOC]

##部署
部署SDK提供两种部署方案：
###1：下载jar包，导入项目路径
```xml
java-sdk1.0.jar

1: httpclient4.4.1.jar
2: httpcore.4.4.1.jar
3: gson2.2.4.jar
4: org.json.jar
```
###2：添加maven配置，配置如下
```xml
<dependency>
    <groupId>com.fangcloud.sdk</groupId>
    <artifactId>java-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```


##使用
###最佳实践
	只需四步：
    1：初始化自己的Client信息，构建Connection
    2：发起授权请求
    3：获取到授权码之后获取Token
    4：使用SDK操作
*注意*
建议Connection使用单例模式，发起授权请求之后，授权码回调给redirectURL，在这里需要调用AuthApi.getTokenByAuthCode("you's authcode")传入您获取到的授权码，会自动处理Connection的，无需手动添加，现在为止，connection已经已经具备了操作权限，直接使用SDK就可以了，下面是具体的代码示例：
```java
public class QuickStart {
    public static Connection connection=null;
    public static void main(String[] args) {
        connection = Connection.getConnection().buildConnection("clientId", "clientSecret", "rediectUrl");
        AuthApi.getTokenByAuthCode("you authcode");
        FileApi.getFileInfo(0);
    }
}
```
###Authorize操作

#####发起授权请求
```java
Authorize()
```

**参数**

| 参数 | 类型 |说明|
|--------|--------|
|   无|   |	||


**返回类型**  	：Void



<hr>
<br>
#####获取Token
```java
getTokenByAuthCode(String... authCode)
```
**参数**

| 参数 | 类型|说明|
|--------|--------|
|authCode|String |授权码|

**返回类型**
TokenInfo

|     TokenInfo字段 |  字段类型  |           字段说明            |
| :-----------: | :----: | :-----------------------: |
| accessToken  | string |          接口访问标识           |
|  tokenType   | string |        目前固定为bearer        |
| refreshToken | string | 用来刷新access_token，有效时间为30天 |
|  expiresIn   |  int   |  access_token的有效时间，单位为s   |
|     scope     | string |        目前固定为"all"         |

<hr/>


#####刷新token
```java
getTokenByRefreshToken(String... refreshtokens)
```
**参数**

| 参数 | 类型|说明|
|--------|--------|
|refreshToken|String |刷新Token|

**返回类型**
TokenInfo

|     TokenInfo字段 |  字段类型  |           字段说明            |
| :-----------: | :----: | :-----------------------: |
| accessToken  | string |          接口访问标识           |
|  tokenType   | string |        目前固定为bearer        |
| refreshToken | string | 用来刷新access_token，有效时间为30天 |
|  expiresIn   |  int   |  access_token的有效时间，单位为s   |
|     scope     | string |        目前固定为"all"         |
*注意：这里仅仅调用本方法就自动完成了Token刷新，无需set，
另外提供了：rebuildAccessToken()方法进行自动刷新。都可使用*
<hr/>



###File操作
#####获取文件信息
```java
getFileInfo(long id)
```
**参数**

| 参数 | 类型|说明|
|--------|--------|
|id|int|文件ID|


###Folder操作

###Item操作

###User操作


##异常与日志

##日志