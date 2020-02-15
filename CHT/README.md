# 《分散式系統常用技術及案例分析》

我一直想寫一本關於分散式系統方面的書。一方面是想把個人多年工作中涉及的分散式技術做一下複習，另一方面也想把個人的經驗分享給廣大的讀者朋友。由於我的開發工作大都以Java為主，所以一開始的主旨設想是“分散式Java”，書也以開放原始碼模式發布在網際網路上（網址為<https://github.com/waylau/distributed-java>）。

## 本書與開放原始碼的關系

本書所列之技術多為開放原始碼技術，本書所撰寫的大部分內容也多取材自我個人的部落格以及個人撰寫的開放原始碼書（也算是為開放原始碼事業貢獻微薄之力吧），符合“取自開放原始碼，反應開放原始碼”之宗旨。不想看本書的也可以直接關心我部落格（<https://waylau.com>）或是開放原始碼書（<https://waylau.com/books>）的內容。當然，部落格相對來說比較零散，沒有這本書來的嚴謹。

詳細的書的章節與開放原始碼的關系，可以[對照目錄](SUMMARY.md)。

當然，本書不單只是涉及Java領域中的分散式技術，主要內容如下。

## 內容介紹

本書分為三大部分，即分散式系統基礎理論、分散式系統常用技術以及經典的分散式系統案例分析。第一部分為第1章和第2章，主要介紹分散式系統基礎理論知識，複習一些在設計分散式系統時需要考慮的范式、知識點以及可能會面臨的問題。 第二部分為第3章到第8章，主要列出了在分散式系統套用中經常用到的一些主流技術，並介紹這些技術的作用和用法。第三部分為第9章和第10章，選取了以淘寶網和Twitter為代表的中國外知名網際網路企業的大型分散式系統案例，分析其架構設計以及演變過程。

* 第1章介紹分散式系統基礎理論知識，複習一些在設計分散式系統時需要考慮的范式、知識點以及可能會面臨的問題，其中內含執行緒、通訊、一致性、容錯性、CAP理論、安全性和平行等關聯內容。
* 第2章詳細介紹分散式系統的架構系統，內含傳統的基於物件的系統結構、SOA，也內含最近比較火的RESTful風格架構、微服務、容器技術、Serverless架構等。
* 第3章介紹常用的分散式訊息服務框架，內含Apache ActiveMQ、RabbitMQ、RocketMQ、Apache Kafka等。
* 第4章介紹分散式計算理論和套用框架方面的內容，內含MapReduce、Apache Hadoop、Apache Spark、Apache Mesos 等。
* 第5章介紹分散式儲存理論和套用框架方面的內容，內含Bigtable、Apache HBase、Apache Cassandra、Memcached、Redis、MongoDB等。
* 第6章介紹分散式監控方面常用的技術，內含Nagios、Zabbix、Consul、ZooKeeper等。
* 第7章介紹常用的分散式版本控制工具，內含Bazaar、Mercurial、Git等。
* 第8章介紹RESTful API、微服務及容器關聯的技術，著重介紹Jersey、Spring Boot、Docker等技術的套用。
* 第9章和第10章分別介紹以淘寶網和Twitter為代表的中國外知名網際網路企業的大型分散式系統案例，分析其架構設計以及演變過程。

您可以檢視詳細的書籍[目錄](SUMMARY.md)。

本書涉及面相當之廣，可以說涵蓋了在設計分散式系統時，所要考慮的大部分問題及解決專案。

![《分散式系統常用技術及案例分析》封面](https://cloud.githubusercontent.com/assets/3233966/23100754/bb13b9a2-f6c3-11e6-874c-7a2a0cb50958.jpg)
## 源程式碼

本書提供源程式碼下載，位址位於[本專案](https://github.com/waylau/distributed-systems-technologies-and-cases-analysis)下的`samples`目錄。

## 勘誤和交流

本書如有勘誤，會在<https://github.com/waylau/distributed-systems-technologies-and-cases-analysis/issues>上進行發布。由於筆者能力有限，時間倉促，難免錯漏，歡迎讀者批評指正。

讀者也可以到博文視點官網的本書頁面進行交流（<http://www.broadview.com.cn/30771>）。

您也可以上[豆瓣](https://book.douban.com/subject/26975204/)進行評論。

## 聯繫作者

您也可以直接聯繫我：

* 部落格：https://waylau.com
* 信箱：[waylau521(at)gmail.com](mailto:waylau521@gmail.com)
* 微網誌：http://weibo.com/waylau521
* 開放原始碼：https://github.com/waylau

## 如何取得本書

實體店及部分網店有售，據我所知有如下網站供應：

* [亞馬遜](https://www.amazon.cn/dp/B06X3RJMGC)
* [當當](http://product.dangdang.com/24183821.html)
* [京東](https://item.jd.com/12124492.html)
* [china-pub](http://product.china-pub.com/5173118)
* [淘寶](https://s.taobao.com/search?q=%E5%88%86%E5%B8%83%E5%BC%8F%E7%B3%BB%E7%BB%9F%E5%B8%B8%E7%94%A8%E6%8A%80%E6%9C%AF%E5%8F%8A%E6%A1%88%E4%BE%8B%E5%88%86%E6%9E%90)

也可以直接關心我部落格（<https://waylau.com>）或是我的開放原始碼書（<https://waylau.com/books>）。

## 其他書籍

若您對本書不感冒，筆者還寫了其他方面的超過一打的書籍（可見<https://waylau.com/books/>），多是開放原始碼電子書。

本人也維護了一個[books-collection](https://github.com/waylau/books-collection)專案，裡面提供了優質的專門給程式設計師的開放原始碼、免費圖書集合。

## 開放原始碼捐贈


![開放原始碼捐贈](https://waylau.com/images/showmethemoney-sm.jpg)

捐贈所得所有款項將用於開放原始碼事業！
