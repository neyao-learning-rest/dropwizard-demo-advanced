项目说明
----
微信的后端服务，对要推送的企业风险进行计算，供前端应用读取。

构建方式
----
标准的maven工程构建方式

运行方式
----
**在开发环境中，以Jar包的方式运行**  
java -jar target/weixin-backend-1.0.0.jar server target\classes\wenxin-backend.yml

启动之后，在浏览器中访问以下地址，即可访问 HelloWorldResource中定义的资源：
- http://localhost:8080/hello/v1/say 
- http://localhost:8080/hello/v2/say 

关键代码
----
**核心类**
- cn.com.deepdata.infra.InfraApiApplication：启动类
- cn.com.deepdata.infra.InfraApiConfiguration：配置类，由框架根据 infra-api.yml自动解析
- infra-api.yml：配置文件


**示例代码**
- cn.com.deepdata.infra.resources.example.HelloWorldResource：示例代码


