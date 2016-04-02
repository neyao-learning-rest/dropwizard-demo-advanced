Project Overview
----------------
This project show some advanced usages of dropwizard REST framework.

Created by neyao(hastin@163.com), 2016-04-02

How to build 
------------
mvn package
java -jar target/dropwizard-1.0.0.jar server target\classes\config.yml


Examples
--------
- show the configuration of logging  
-- see the **logging** section in config.yml

- show hibernate supports  
-- pom.xml: declares dropwizard-hibernate dependency
-- org.oursight.dropwizard.demo.MyConfiguration.getDataSourceFactory: shows how to get the configurations of hibernate
-- hibernate configurations: see the "database" section in config.yml/config-mysql.yml/config-oracle.yml
-- org/oursight/dropwizard/demo/entity: the entity beans
-- org.oursight.dropwizard.demo.MyApplication.initialize: shows how to scan a package which contains entity beans
-- org/oursight/dropwizard/demo/dao the DAO layer

- show java validation
-- org.oursight.dropwizard.demo.entity.User: declares some javax validation annotations
-- org.oursight.dropwizard.demo.resources.example.HelloWorldResource.addUser: the @Valid shows how to use it
