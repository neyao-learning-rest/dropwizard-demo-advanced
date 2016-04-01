项目说明
----
前端应用的REST API服务，提供一些计算密集型的服务。

构建方式
----
标准的maven工程构建方式

运行方式
----
**在开发环境中，以Jar包的方式运行**  
java -jar target/frontend-api-1.0.0.jar server target\classes\frontend-api.yml

启动之后，在浏览器中访问以下地址，即可访问 HelloWorldResource中定义的资源：
- http://localhost:8080/hello/v1/say 
- http://localhost:8080/hello/v2/say 

关键代码
----
**核心类**
- cn.com.deepdata.frontend.WeixinApplication：启动类
- cn.com.deepdata.frontend.WeixinConfiguration：配置类，由框架自动解析配置文件weixin-backend.yml并获得实例
- weixin-backend.yml：配置文件


**示例代码**
- cn.com.deepdata.frontend.resources.example.HelloWorldResource：示例代码


