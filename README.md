��Ŀ˵��
----
�������ĵ�API���񣬶����ṩREST API����

������ʽ
----
��׼��maven���̹�����ʽ

���з�ʽ
----
**�ڿ��������У���Jar���ķ�ʽ����**
java -jar target/infra-api-1.0.0.jar server target\classes\infra-api.yml

����֮����������з������µ�ַ�����ɷ��� HelloWorldResource�ж������Դ��
- http://localhost:8080/hello/v1/say 
- http://localhost:8080/hello/v2/say 

�ؼ�����
----
**������**
- cn.com.deepdata.infra.InfraApiApplication��������
- cn.com.deepdata.infra.InfraApiConfiguration�������࣬�ɿ�ܸ��� infra-api.yml�Զ�����
- infra-api.yml�������ļ�


**ʾ������**
- cn.com.deepdata.infra.resources.example.HelloWorldResource��ʾ������


