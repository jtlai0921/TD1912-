# Summary

本書的大部分內容取材自我個人的部落格以及個人撰寫的開放原始碼書（也算是為開放原始碼事業貢獻微薄之力吧），不想看本書的也可以直接關注我部落格（<https://waylau.com>）或開放原始碼書（<https://waylau.com/books>）的內容。當然，部落格相對來說比較零散，沒有這本書來的嚴謹。

* [內容簡介](docs/Introduction.md)
* [前言](docs/Preface.md)
* 第一部分分散式系統基礎理論
* 第1章分散式系統基礎知識
	* 1.1 概述-> [用大白話聊聊分散式系統](https://waylau.com/talk-about-distributed-system/)、[分散式Java](https://github.com/waylau/distributed-java)
	* 1.2 執行緒-> [Java 程式設計要點](https://github.com/waylau/essential-java)
	* 1.3 通訊-> [遠端程序呼叫(RPC)詳解](https://waylau.com/remote-procedure-calls/)、[TCP 協定的三次驗證、四次分手](https://waylau.com/tcp-connect-and-close/)、[AS3使用thrift的與JHava servlet伺服器端通訊](https://waylau.com/as3-using-thrift-and-java-servlet-server-side-communication/)
	* 1.4 一致性-> [分散式系統常見的交易處理機制](https://waylau.com/distributed-system-transaction/)
	* 1.5 容錯性
	* 1.6 CAP 理論-> [淺談CAP 理論](https://waylau.com/cap-theorem/)
	* 1.7 安全性->  [校園網資訊網路安全問題以及對策整體說明](https://waylau.com/campus-network-security-problems-and-countermeasures/)
	* 1.8 平行處理-> [Java I/O 模型的演進](https://waylau.com/java-io-model-evolution/)、[Golang-簡潔的平行處理](https://waylau.com/golang-clear-concurreny/)、[Netty 實戰(精髓)](http://waylau.com/essential-netty-in-action)
* 第2章分散式系系統架構系統
	* 2.1 以物件為基礎的系統結構
	* 2.2 針對服務的架構（SOA）
	* 2.3 RESTful 風格的架構-> [REST 實戰](https://github.com/waylau/rest-in-action)、[RESTful API 設計最佳做法](https://waylau.com/best-practices-for-better-restful-api/)
	* 2.4 微服務架構（MSA）-> [簡述Microservices（微服務）](https://waylau.com/ahout-microservices/)
	* 2.5 容器技術
	* 2.6 Serverless 架構
* 第二部分分散式系統常用技術
* 第3章分散式訊息服務
	* 3.1 Apache ActiveMQ
	* 3.2 RabbitMQ
	* 3.3 RocketMQ
	* 3.4 Apache Kafka
* 第4章分散式運算
	* 4.1 MapReduce
	* 4.2 Apache Hadoop  -> [Apache Hadoop 入門教學](https://waylau.com/about-hadoop/) 
	* 4.3 Apache Spark
	* 4.4 Apache Mesos  -> [Apache Mesos 在不同平台下的安裝](https://waylau.com/mesos-installation/)
* 第5章分散式儲存
	* 5.1 Bigtable
	* 5.2 Apache HBase -> [Apache HBase 入門教學](https://waylau.com/about-hbase/)
	* 5.3 Apache Cassandra
	* 5.4 Memcached
	* 5.5 Redis  -> [Redis 資料類型及抽象](https://waylau.com/redis-data-type/)
	* 5.6 MongoDB
* 第6章分散式監控系統
	* 6.1 Nagios	-> [Nagios 在不同平台下的安裝](https://waylau.com/nagios-installation/)
	* 6.2 Zabbix	-> [Zabbix 在不同平台下的安裝](https://waylau.com/zabbix-installation/)
	* 6.3 Consul
	* 6.4 ZooKeeper
* 第7章分散式版本控制系統
	* 7.1 Bazaar
	* 7.2 Mercurial
	* 7.3 Git	-> [如何在GitHub 上傳程式、分享專案](https://waylau.com/share-how-to-upload-code-github-project/)
* 第8章RESTful API、微服務及容器技術
	* 8.1 Jersey    ->  [Jersey 2.x 使用者指南](https://github.com/waylau/Jersey-2.x-User-Guide)、[用Jersey建置RESTful服務](http://blog.csdn.net/column/details/jersey-rest.html)
	* 8.2 Spring Boot  -> [Spring Boot 教學](https://github.com/waylau/spring-boot-tutorial)
	* 8.3 Docker  -> [簡述Docker](https://waylau.com/ahout-docker/)
* 第三部分分散式系統案例分析
* 第9章淘寶網：“雙十一”神話的締造者
	* 9.1 從LAMP 到Java 平台的轉變
	* 9.2 堅定不移的走“去IOE”的道路
	* 9.3 打造雲端運算，決戰“雙十一”
* 第10章Twitter：即時資訊傳遞的王者
	* 10.1 快取，讓回應更快
	* 10.2 服務拆分與治理
	* 10.3 抗擊流量的洪流
