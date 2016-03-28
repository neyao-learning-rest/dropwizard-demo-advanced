项目说明
----
数据中心的API服务，对外提供REST API服务

构建方式
----
标准的maven工程构建方式

运行方式
----
**在开发环境中，以Jar包的方式运行**
java -jar target/datacenter-api-1.0.0.jar server target\classes\datacenter-api.yml

关键代码
----
- cn.com.deepdata.infra.resources.example.HelloWorldResource：示例代码

- cn.com.deepdata.infra.InfraApiApplication：启动类
- cn.com.deepdata.infra.InfraApiConfiguration：配置类，由框架根据 infra-api.yml自动解析
- infra-api.yml：配置文件
