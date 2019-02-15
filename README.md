spring-boot spring-cloud 通用架构测试搭建

..-service:
作为eu注册中心启动

..-gateway:
项目网关

..-core:
核心业务功能设计

..-worker:
大型工厂模式存放区
缓存存储策略

涉及架构模块：
redis, mongodb, mysql （docker, jenkens）

数据库结构：
springjpa + mybatis
多数据源+多事务管理

添加额外功能：
百度测试
