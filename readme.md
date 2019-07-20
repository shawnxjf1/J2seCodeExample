## 工程结构
如果一个api有多个版本那么工程或者module那里最好带上版本，比如springboot2.0_apache(apache是组织名字表示springboot2.0样例中使用的jar是哪里开源的)
parent
  springBoot
    springBoot2.0
    springBoot3.0
  Json
    fastJson
    jackson

## 背景
由于java 类库多 版本多，所以用好是一个很大问题。
也许我们经常使用了一些api踩了一些坑，但是下次还是不知道如何正确的用好它，或者用错了。
所以这里对使用过得组件记录下来，记录彩过得坑也便于各个组件各个版本比较。  
   
## 持续维护
如果工作中有比较好的apicopy过来，但是还没有来的及把api完善那么打上标注 @apiTodo
如果api样例完善了但是没有写上文档那么打上标注@apiDoc
有时没有那么多时间一直完善可能做了一半那么最好把当前进度记录在旁边，描述下一步应该怎么办？可以打上标注@next
 

## api描述细节
根据如下模块：
1. 什么场景下触发你写下api
2. 对于api自身来说，使用场景是什么？解决了什么问题？
3. api中标注版本号等其他一些信息。
4. api 多个版本请在方法上或者class上加上版本号V02XXXX(后面XXX为大概功能描述)
5. 比如工作中用到了mybatis/mybatisPlus 且mybatisplus也有很多版本，但是应该单独建立module应该他们的jar可能冲突。

## 基础的组件
对于lombok\slf4j等可以放在父工程里且定义好版本

