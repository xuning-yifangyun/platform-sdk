
#亿方云开放平台Python-SDK使用说明
##目录
###*暂未全部完成*
[TOC]

##部署
部署SDK提供两种部署方案：
###1：下载jar包，导入项目路径
```text
pip安装pip install fangcloudsdk
或者：python3 setup.py
```

##使用
###:建议参考官方文档
###获取资源只需以下几步
	只需三步：
    1：初始化自己的应用Oauth信息，即实例化Oauth
    2：接收授权码,获取token
    3：使用Token请求api资源
###最佳实践
```python
from fangcloudsdk.oauth import OAuth
from fangcloudsdk.client import Client
oauth = OAuth(
    client_id="bbe8e63d-89b0-4f31-ba07-5fd602d501d8",
    client_secret="5c179dfe-0f5a-4124-9690-42b69ec3aef7",
    redirect_url="http://121.41.52.18:8080/callback"
)
# 需要获取到请求授权的url，需要交给用户去和授权服务器去交互，如下：
# auth_url=oauth.get_authorization_url()
# 接收授权码, 获取token
oauth.authenticate(auth_code="lS92LP")
# 实例化client
client = Client(oauth)
# 请求api资源
s = client.user().info()
print(s)
```
###Authorize操作

#####获取授权url
```python
get_authorization_url(self):
```
**参数**

| 参数 | 类型 |说明|
|:----:|:----:|:--------:|
|   无|   |	|	|

**返回类型**  	：string



<hr>
<br>
#####获取Token
```python
authenticate(self, auth_code=None):
```
**参数**

| 参数 | 类型|说明|
|:----:|:----:|:--------:|
|auth_ode|String |授权码|

**返回类型**
json

| Key 名称|  字段类型  |           字段说明            |
| :-----------: | :----: | :-----------------------: |
| access_oken  | string |          接口访问标识           |
|  token_type   | string |        目前固定为bearer        |
| refresh_token | string | 用来刷新access_token，有效时间为30天 |
|  expires_in   |  int   |  access_token的有效时间，单位为s   |
|    scope     | string |        目前固定为"all"         |

<hr/>


#####刷新token
```python
update_token(self):
```
**参数**

| 参数 | 类型|说明|
|:----:|:----:|:--------:|
|无|

**返回类型**
json

|     Key 名称 |  字段类型  |           字段说明            |
| :-----------: | :----: | :-----------------------: |
| accessToken  | string |          接口访问标识           |
|  tokenType   | string |        目前固定为bearer        |
| refreshToken | string | 用来刷新access_token，有效时间为30天 |
|  expiresIn   |  int   |  access_token的有效时间，单位为s   |
|     scope     | string |        目前固定为"all"         |




###File操作
#####获取文件信息
```python
test_get_file_info(self):
```
**参数**

| 参数 | 类型|说明|
|:----:|:----:|:--------:|
|id|int|文件ID|

**返回类型**
json

|Key 名称|   类型    |      字段说明       |
| :----------------: | :-------: | :-------------: |
|   comments_count   |    int    |    评论数，目前都为0    |
|        type        |  string   |    固定为"file"    |
|         id         |   long    |      文件id       |
|        name        |  string   |      文件名称       |
| extension_category |  string   |      扩展名分类      |
|        size        |   long    |      文件大小       |
|     created_at     | timestamp |     文件创建时间      |
|    modified_at     | timestamp |     文件更新时间      |
|    description     |  string   |      文件描述       |
|        path        | folder数组  |    所有的祖先文件夹     |
|      owned_by      |   user    |       所有者       |
|       shared       |  boolean  | 是否被分享，目前都为false |
|       parent       |  folder   |      父文件夹       |
|    sequence_id     |   long    |      目前没有用      |
|      in_trash      |  boolean  |     是否在回收站中     |
|     is_deleted     |  boolean  |     是否已经被删除     |

<hr>
#####更新文件信息
```java
updateFile(long id, String newName, String newDescription)
```
**参数**

| 参数 | 类型|说明|
|:----:|:----:|:--------:|
|id|int|文件ID|

**返回类型**
FileInfo

|Key 名称|   类型    |      字段说明       |
| :----------------: | :-------: | :-------------: |
|   comments_count   |    int    |    评论数，目前都为0    |
|        type        |  string   |    固定为"file"    |
|         id         |   long    |      文件id       |
|        name        |  string   |      文件名称       |
| extension_category |  string   |      扩展名分类      |
|        size        |   long    |      文件大小       |
|     created_at     | timestamp |     文件创建时间      |
|    modified_at     | timestamp |     文件更新时间      |
|    description     |  string   |      文件描述       |
|        path        | folder数组  |    所有的祖先文件夹     |
|      owned_by      |   user    |       所有者       |
|       shared       |  boolean  | 是否被分享，目前都为false |
|       parent       |  folder   |      父文件夹       |
|    sequence_id     |   long    |      目前没有用      |
|      in_trash      |  boolean  |     是否在回收站中     |
|     is_deleted     |  boolean  |     是否已经被删除     |

<hr>

##### 删除文件至回收站

支持批量操作
```java
deleteFile(long... fileIds)
```
**参数**


|参数字段|字段类型 | 字段说明 |
|:----:|:----:|:--------:|
| fileIds | List |文件id集合 |

**返回类型**
Result

|Key 名称| 类型 |字段说明  |
| :----------------: | :-------: | :-------------: |
|   success   |    boolean   |    删除是否成功    |

<hr>
##### 从回收站删除文件

支持批量操作
```java
deleteFileFromTrash(boolean clear_trash, long... fileIds)
```
**参数**


|  参数字段   |  字段类型  | 是否必须 | 字段说明 |
| :------: | :----: | :--: | :--: |
| fileIds | List |  是   | 文件id集合 |
| clear_trash | boolean |  否   | 清空回收站 |

**返回类型**
Result

|ResultKey 名称|   类型    |      字段说明       |
| :----------------: | :-------: | :-------------: |
|   success   |    boolean   |    删除是否成功    |

<hr>


##### 从回收站恢复文件
支持批量操作
```java
recoveryFileFromTrash(boolean restoreAll, long... fileIds)
```
**参数**


|  参数字段   |  字段类型  | 是否必须 | 字段说明 |
| :------: | :----: | :--: | :--: |
| fileIds | List |  是   | 文件id集合 |
| restoreAllh | boolean |  否   | 全部恢复|

**返回类型**
Result

|Key 名称|   类型    |      字段说明       |
| :----------------: | :-------: | :-------------: |
|   success   |    boolean   |    删除是否成功    |

<hr>


##### 移动文件
```java
moveFile(List<Long> fileIds, long target_folder_id)
```
**参数**

|       参数字段       |  字段类型  | 是否必须 |   字段说明    |
| :--------------: | :----: | :--: | :-------: |
|     file_ids     | long数组 |  是   | 被移动的文件id  |
| target_folder_id |  long  |  是   | 移动至的文件夹id |

**返回类型**
Result

|Result成员变量|   类型    |      字段说明       |
| :----------------: | :-------: | :-------------: |
|   success   |    boolean   |    删除是否成功    |

<hr>

##### 获取新文件上传地址
```java
uploadFile(long parentId, String name)
```
**参数**

|    参数字段     |  字段类型  | 是否必须 |                   字段说明                   |
| :---------: | :----: | :--: | :--------------------------------------: |
|  parent_id  |  long  |  是   |                上传至的文件夹id                 |
|    name     | string |  是   | 文件名称，文件名称必须是1到222个字符，并且不能含有/ ? : * |

**返回类型**
FilePresignUpload

|    Key 名称     |  字段类型  |                   字段说明                   |
| :---------: | :----: | :--------------------------------------: |
| presign_url | string | 上传链接，接下来往该链接上传即可上传文件，上传链接的有效时间为1个小时

<hr>

##### 获取文件上传新版本地址

```java
newVersion(long id, String name, String remark)
```
**参数**

|    参数字段     |  字段类型  | 是否必须 |                   字段说明                   |
| :---------: | :----: | :--: | :--------------------------------------: |
|  parent_id  |  long  |  是   |                上传至的文件夹id                 |
|    name     | string |  是   | 文件名称，文件名称必须是1到222个字符，并且不能含有/ ? : * |
|   remark    | string |  否   |                上传新版本的备注。                 |

**返回类型**
FilePresignUpload

|    Key 名称     |  字段类型  |                   字段说明                   |
| :---------: | :----: | :--------------------------------------: |
| presign_url | string | 上传链接，接下来往该链接上传即可上传文件，上传链接的有效时间为1个小时

<hr>


##### 获取文件的下载地址

```java
download(long id)
```
**参数**

|    参数字段     |  字段类型  | 是否必须 |                   字段说明                   |
| :---------: | :----: | :--: | :--------------------------------------: |
|  parentId  |  long  |  是   |                上传至的文件夹id                 |
|    name     | string |  是   | 文件名称，文件名称必须是1到222个字符，并且不能含有/ ? : * |
|   remark    | string |  否   |                上传新版本的备注。                 |

**返回类型**
FilePresignDownload


|     Key 名称      |             字段类型             |                   字段说明                   |
| :-----------: | :--------------------------: | :--------------------------------------: |
| download_urls | key为file_id, value为url组成的map | 下载链接，访问该下载链接即可下载文件，下载链接的有效时间为1个小时，且只能被使用一次 |

<hr>


##### 预览文件
```java
preview(long id, boolean forceRegenerate, String kind)
```
**参数**

| 参数字段 | 字段类型 | 字段说明 |
| :--: | :--: | :--: |
|  id  | long | 文件id |
| forceRegenerate | boolean |  否   |      是否需要重新生成预览      |
|       kind       | string  |  是   | 生成的预览图类型，具体类型见该接口的描述 |

**返回类型**
FilePreviewInfo

若预览图未生成：

|     Key 名称   |  字段类型   |            字段说明                   |
| :-----------: | :-----: | :--------------------------------------: |
|   category    | string  |                  预览图的分类                  |
| exif_rotation |   int   | 表示图片的旋转，具体可参考https://beradrian.wordpress.com/2008/11/14/rotate-exif-images/ |
|    format     | string  |                 预览图的后缀名                  |
|   has_2048    | boolean |           是否能生成2048 * 2048的预览图           |
|  page_count   |   int   |             只用在office文件转图片上              |
|    status     | string  |                 预览转换的状态                  |

若预览图已经生成，则会在上面的基础上多以下字段：

|     返回字段     | 字段类型 |   字段说明   |
| :----------: | :--: | :------: |
| download_url | url  | 预览图的下载链接 |

若预览图生成失败：

|            返回字段            |  字段类型  |   字段说明    |
| :------------------------: | :----: | :-------: |
|           status           | string | 固定为failed |
| representation_fail_reason | string | 预览生成失败的原因 |

<hr>


##### 获取文件预览转换后的下载地址

```java
previewDownload(long id, int pageIndex, String kind)
```
**参数**

|    参数字段 |  字段类型  | 是否必须 | 字段说明|
| :--------: | :----: | :--: | :----------------------: |
| page_index |  int   |  否   |    分页下载，常用于预览图是多页的情况|
|    kind    | string |  是   | 生成的预览图类型，具体类型见该预览文件接口的描述|
|  id  | long | 是|文件id |

**返回类型**
FilePreviewDownload
若预览图未生成：

|  返回字段   |  字段类型   |   字段说明   |
| :-----: | :-----: | :------: |
| success | boolean | 固定为false |

若预览图已经生成，则会在上面的基础上多以下字段：

|     返回字段     | 字段类型 |   字段说明   |
| :----------: | :--: | :------: |
| download_url | url  | 预览图的下载链接 |

若预览图生成失败：

|            返回字段         | 字段类型 | 字段说明|
| :------------------------: | :----: | :-------: |
|           status           | string | 固定为failed |
| representation_fail_reason | string | 预览生成失败的原因 |


##### 预览嵌入
```java
getPreviewFrameUrl(long fileId, String fileName)
```
**参数**

|     参数字段     |  字段类型  | 是否必须 |字段说明    |
| :----------: | :----: | :--: | :---------------: |
| access_token | string |  是   | 当前用户的access_token |
|   file_id    |  long  |  是   |    需要预览的文件的id     |

**返回类型**
返回Url：String 类型，如“`<iframe src="https://open.fangcloud.com/preview/preview.html?access_token=xxx&file_id=1"></iframe>`”；

##### 复制文件


```java
copyFile(long fileId, long targetFolderId, boolean checkConflict)
```

**参数**

| 参数字段 | 字段类型 | 是否必须 |   字段说明|
| :--------------: | :--: | :--: | :-------: |
|     file_id      | long |  是   | 被拷贝的文件id  |
| target_folder_id | long |  是   | 拷贝至的文件夹id |


**返回类型**

|   返回字段   | 字段类型 |    字段说明     |
| :------: | :--: | :---------: |
| new_file | file | 复制产生的新的file |

<hr>



### 文件夹（FOLDER）操作

##### 获取文件夹信息
```java
getFolderInfo(long id)
```

**参数**

| 参数字段 | 字段类型 | 字段说明  |
| :--: | :--: | :---: |
|  id  | long | 文件夹id |


**返回类型**
**返回字段说明**
FolderInfo

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| item_count  |    int    |    包含item的数量    |
| folder_type |  string   |      文件夹类型      |
|    type     |  string   |   固定为"folder"   |
|     id      |   long    |      文件夹id      |
|    name     |  string   |      文件夹名称      |
|    size     |   long    |      文件夹大小      |
| created_at  | timestamp |  文件夹创建时间，单位为秒   |
| modified_at | timestamp |  文件夹更新时间，单位为秒   |
| description |  string   |      文件夹描述      |
|    path     | folder数组  |    所有的祖先文件夹     |
|  owned_by   |   user    |       所有者       |
|   shared    |  boolean  | 是否被分享，目前都为false |
|   parent    |  folder   |      父文件夹       |
| sequence_id |   long    |      目前没有用      |
|  in_trash   |  boolean  |     是否在回收站中     |
| is_deleted  |  boolean  |     是否已经被删除     |

<hr>
##### 创建文件夹
```java
createFolder(String name, long parentId)
```

**参数**

|   参数字段    |  字段类型  | 是否必须 |  字段说明  |
| :-------: | :----: | :--: | :----: |
|   name    | string |  是   |  文件夹名  |
| parentId |  long  |  是   | 父文件夹id |

**返回类型**
CreateFolder

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| item_count  |    int    |    包含item的数量    |
| folder_type |  string   |      文件夹类型      |
|    type     |  string   |   固定为"folder"   |
|     id      |   long    |      文件夹id      |
|    name     |  string   |      文件夹名称      |
|    size     |   long    |      文件夹大小      |
| created_at  | timestamp |  文件夹创建时间，单位为秒   |
| modified_at | timestamp |  文件夹更新时间，单位为秒   |
| description |  string   |      文件夹描述      |
|    path     | folder数组  |    所有的祖先文件夹     |
|  owned_by   |   user    |       所有者       |
|   shared    |  boolean  | 是否被分享，目前都为false |
|   parent    |  folder   |      父文件夹       |
| sequence_id |   long    |      目前没有用      |
|  in_trash   |  boolean  |     是否在回收站中     |
| is_deleted  |  boolean  |     是否已经被删除     |


<hr>
##### 更新文件夹
```java
updateFolder(long id, String newName)
```

**参数**

| 参数字段 |  字段类型  | 是否必须 | 字段说明 |
|:----:|:----:|:--------:|:--------:|
| id | long | 是 | 文件夹ID |
| name | string |  是   | 文件夹名 |

**返回类型**
UpdateFolder

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| item_count  |    int    |    包含item的数量    |
| folder_type |  string   |      文件夹类型      |
|    type     |  string   |   固定为"folder"   |
|     id      |   long    |      文件夹id      |
|    name     |  string   |      文件夹名称      |
|    size     |   long    |      文件夹大小      |
| created_at  | timestamp |  文件夹创建时间，单位为秒   |
| modified_at | timestamp |  文件夹更新时间，单位为秒   |
| description |  string   |      文件夹描述      |
|    path     | folder数组  |    所有的祖先文件夹     |
|  owned_by   |   user    |       所有者       |
|   shared    |  boolean  | 是否被分享，目前都为false |
|   parent    |  folder   |      父文件夹       |
| sequence_id |   long    |      目前没有用      |
|  in_trash   |  boolean  |     是否在回收站中     |
| is_deleted  |  boolean  |     是否已经被删除     |

<hr>
##### 删除文件夹至回收站

支持批量操作

```java
deleteFolder(long... folderIds)
```

**参数**

|    参数字段    | 字段类型 | 是否必须 |  字段说明   |
| :--------: | :--: | :--: | :-----: |
| folderIds | list |  是   | 文件夹id列表 |

**返回参数**
DeleteFolder

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| success |    boolean   |    删除是否成功    |

<hr>
##### 从回收站删除文件夹
支持批量操作

```java
deleteFolderFromTrash(List<Long> folderIds, boolean clearTrash)
```

**参数**

|    参数字段    | 字段类型 | 是否必须 |  字段说明   |
| :---------: | :-------: | :-------------: |
| folderIds | list |  是   | 文件夹id列表 |
| clearTrash | boolean |  否   | 是否清空回收站 |

**返回参数**

DeleteFolder

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| success |    boolean   |    删除是否成功    |

<hr>
##### 从回收站恢复文件夹

支持批量操作
```java
recoveryFolderFromTrash(List<Long> folderIds, boolean restoreAll)
```

**参数**

|    参数字段    | 字段类型 | 是否必须 |  字段说明   |
| :---------: | :-------: | :-------------: |
| folderIds | list |  是   | 文件夹id列表 |
| restoreAll | boolean |  否   | 是否恢复所有文件 |

**返回参数**
RestoreFolderFromTrash

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| success |    boolean   |    删除是否成功    |
| folder_ids  | list |     文件夹id列表     |

<hr>
##### 移动文件夹

支持批量操作

```java
moveFolder(List<Long> folderIds, long targetFolderId)
```

**参数**

|     参数字段  | 字段类型 | 是否必须 |  字段说明   |
| :-----------: | :--: | :--: | :-----: |
|  folderIds   | list |  是   | 文件夹id列表 |
| targetFolderId | long |  是   | 目标文件夹id |

**返回参数**
MoveFolder

|    返回字段     |   字段类型    |      字段说明       |
| :---------: | :-------: | :-------------: |
| success |    boolean   |    移动是否成功    |


<hr>
##### 获取单层子文件和文件夹列表

```java
getChildren(long folderId, int pageId, int pageCapacity, String type)
```

**参数**

|     参数字段      |  字段类型  |  字段说明  |
| :-----------: | :----: | :----: |
|   folder_id   |  long  | 文件夹id  |
|    page_id    |  int   |   页号   |
| page_capacity |  int   |  页容量   |
|     type      | string | item类型 |

**返回参数**
ItemList

|     返回字段      | 字段类型 |      字段说明      |
| :-----------: | :--: | :------------: |
|    folders    | list | 包含的folder的list |
|     files     | list |  包含的file的list  |
|  total_count  | int  |   所有item的数量    |
|    page_id    | int  |       页号       |
| page_capacity | int  |      页容量       |


**返回字段说明**


### 文件或文件夹（ITEM）操作

##### 搜索

```java
search(String queryWords, String type, int pageNumber, int searchInFolder)
```

**参数**

|       参数字段       |  字段类型  | 是否必须 |              字段说明 |
| :--------------: | :----: | :--: | :-----------------------------: |
|   query_words    | string |  是   |              搜索关键词              |
|       type       | string |  否   | 搜索类型，分为file，folder，all三种，默认为all |
|   page_number    |  int   |  否   |        第几页，每页默认20，默认为第0页        |
| search_in_folder |  int   |  否   |   指定父文件夹，匹配的结果都是该文件夹的子文件或子文件夹   |

**返回参数**
ItemList

|     返回字段      | 字段类型 |      字段说明      |
| :-----------: | :--: | :------------: |
|    folders    | list | 包含的folder的list |
|     files     | list |  包含的file的list  |
|  total_count  | int  |   所有item的数量    |
|    page_id    | int  |       页号       |
| page_capacity | int  |      页容量       |

<hr/>


### 用户（User）操作

##### 获取用户的as_user码

*此接口为高级接口，常用于跨用户传输文件，若需使用需联系客服*

<hr>

#####获取自己的信息
```java
getOwnInfo()
```

**参数**
无
**返回类型**
GetUserInfo

|参数字段  |  字段类型  |   字段说明   |
| :--------------: | :----: | :----------------: |
|id| long |用户id |
|enterprise_id | long| 企业id |
|name | string |用户姓名|
|phone|	string	|用户手机|
|email|	string|	用户邮箱|
|profile_pic_key|string|	用户头像下载所需的key|
|active|boolean|用户是否激活|
|full_name_pinyin|string|用户姓名的拼音字母|
|pinyin_first_letters|string|用户姓名的拼音首字母|

#####获取他人的信息
```java
getUserInfo(long id)
```

**参数**

| 参数| 类型 |	说明|
|:----:|:----:|:--------:|
| id |long|用户ID|

**返回类型**
GetUserInfo


|参数字段  |  字段类型  |   字段说明   |
| :--------------: | :----: | :----------------: |
|id| long |用户id |
|enterprise_id | long| 企业id |
|name | string |用户姓名|
|phone|	string	|用户手机|
|email|	string|	用户邮箱|
|profile_pic_key|string|	用户头像下载所需的key|
|active|boolean|用户是否激活|
|full_name_pinyin|string|用户姓名的拼音字母|
|pinyin_first_letters|string|用户姓名的拼音首字母|


##### 获取用户头像
```java
getPrifilePicDowload(long userId, String profilePicKey)
```
**参数**

| 参数| 类型 |	说明|
|:----:|:----:|:--------:|
| id |long|用户ID|
| profilePicKey |String|用户头像的Key|

**返回类型**
InputStream



### 通用对象

#### File

| 字段                 | 类型        | 说明              |
| ------------------ | --------- | --------------- |
| id                 | long      | 文件id            |
| user_id            | long      | 所有者id           |
| size               | long      | 文件大小            |
| parent_folder_id   | long      | 父文件夹id          |
| name               | string    | 文件名             |
| extension          | string    | 文件扩展名           |
| extension_category | string    | 文件扩展名的分类        |
| description        | string    | 文件描述            |
| remark             | string    | 文件备注            |
| typed_id           | string    | file + "_" + id |
| in_trash           | boolean   | 是否在回收站          |
| is_deleted         | boolean   | 是否被删除           |
| owned_by           | user      | 所有者对象           |
| created_at         | timestamp | 文件创建时间          |
| modified_at        | timestamp | 文件修改时间          |


#### Folder

| 字段   | 类型     | 说明        |
|:----:|:----:|:--------:|
| id   | long   | 文件夹id     |
| type | string | 固定为folder |
| name | string | 文件夹名称     |

#### User

| 字段            | 类型     | 说明        |
|:----:|:---------:|:-----------:|
| id            | long   | 用户id      |
| name          | string | 用户名称      |
| login         | string | 用户账号      |
| enterprise_id | long   | 用户所在的企业id |


###日志
######配置
	
    用户可以进行自定义配置，如果用户不自定义指定配置文件，那么会默认使用sdk包下的conf/logback.xml文件作为日志配置文件，
    自定义指定的java代码如下,配置可以参考logback.xml配置文件:
```java
Config.customLogPath("your log config path");
```

### 异常错误码

| code                          | message         |
|:------------------------------:|:-------------------------------------------:|
| permission_denied             | 权限不足            |
| file_not_found                | 文件不存在           |
| folder_not_found              | 文件夹不存在          |
| file_deleted                  | 文件已删除           |
| folder_deleted                | 文件夹已删除          |
| file_in_trash_not_found       | 文件不在回收站         |
| folder_in_trash_not_found     | 文件夹不在回收站        |
| file_name_conflict            | 文件命名冲突          |
| folder_name_conflict          | 文件夹命名冲突         |
| folder_empty_in_trash         | 回收站无文件夹         |
| folder_parent_deleted         | 父文件夹已被删除        |
| item_name_invalid             | 文件或文件夹名称不合法     |
| item_name_size_incorrect      | 文件或文件夹名称长度错误    |
| request_data_invalid          | 请求参数错误          |
| exceed_enterprise_space_limit | 超过企业空间限制        |
| exceed_user_space_limit       | 超过用户空间限制        |
| folder_is_descendant          | 目标文件夹是移动文件夹的子目录 |