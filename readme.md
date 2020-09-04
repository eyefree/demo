项目说明文档
本项目为springboot框架的简单应用，含有以下功能：
1、增删改查
2、批量新增、批量更新和批量删除
3.对上述接口进行访问次数统计
4.每小时对接口访问数据进行归档，并重新开始统计
备注：本项目采用了两种方法实现访问次数统计，一种为实时更新数据库，即
每次点击都去更新数据库，另一种为每小时更新一次数据库（在启动时也会更新
一次，不过皆为0），实现大概思路为采用常量类维护每小时接口访问的次数。
--------------------------------------------------------------------------------------
功能实现方法
统一的：在configuration层配置数据连接池，在zjrcu层添加程序入口，在resources中添加
application.yml文件，创建数据库和表，在resources中添加logback.xml文件，此文件一般
不用修改。

增删改查：1.在dao层实现接口，2.在entity层实现实体类，3.在mybatis的xml文件中配置，
4.在service层编写对应的接口与业务实现（添加业务逻辑，调用dao层方法），
5.在controller层实现（调用service层方法，配置映射路径）。

批量修改：1.在dao层实现接口，2.在entity层实现实体类，在vo层封装实体类集合，
3.在mybatis的xml文件中配置，4.在service层编写对应的接口与业务实现（添加业务逻辑，
调用dao层方法），5.在controller层实现（调用service层方法，配置映射路径）。

接口访问次数统计-实时更新数据库（每小时归档一次）：
1.在dao层实现接口，2.在entity层实现实体类，3.在mybatis的xml文件中配置，
4.在service层编写对应的接口与业务实现（添加业务逻辑，调用dao层方法），
5.在interceptor层实现拦截器来进行访问次数的统计（调用service层方法（除了select）），
6.在configuration层配置拦截器，7.在controller层实现（调用service层方法（只有select），
配置映射路径，实时更新界面）。

接口访问次数统计-每小时更新一次数据库（每小时归档一次）：
1.在dao层实现接口，2.在entity层实现实体类，3.在mybatis的xml文件中配置，
4.在util层实现常量类，维护每小时的接口访问数据
5.在service层编写对应的接口与业务实现（添加业务逻辑，，修改常量类的值，调用dao层方法），
6.在interceptor层实现拦截器来进行访问次数的统计（对常量类的值进行++操作），
7.在configuration层配置拦截器（其实上边的已经配置过了，逻辑上是这样）。
--------------------------------------------------------------------------------------
项目部署和运行
1.导入maven依赖、导入demo.sql（在yml文件中改成自己本地的配置）
2.启动Application.java
3.打开服务器127.0.0.1:9999/demo
4.select接口: 127.0.0.1:9999/demo/select
insert接口: 127.0.0.1:9999/demo/insert
update接口: 127.0.0.1:9999/demo/update
delete接口: 127.0.0.1:9999/demo/delete
insertBatch接口: 127.0.0.1:9999/demo/insertBatch
updateBatch接口: 127.0.0.1:9999/demo/updateBatch
deleteBatch接口: 127.0.0.1:9999/demo/deleteBatch
（除了select其它皆为true or false，因为只传了返回值）
5.实时查看接口访问次数：127.0.0.01:9999/demo/access