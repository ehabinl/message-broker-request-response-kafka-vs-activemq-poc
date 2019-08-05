# request/response benchmark (kafka vs activemq)
A quick POC that compares "ActiveMQ" to "Kafka" as a request/response message broker.


P.S: I've expected better performance from Kafka


# Prerequisites:

	add `127.0.0.1 kafka-1` to your /etc/hosts
	run kafka docker 
		cd kafka-docker
		docker-compose up
	


 Active MQ: embedded
 
 Kafka: Docker (Configurations available in the repo)


# Benchmarked with 100 active threads and 100 iterations per thread ( nano time )

	 Thread Active MQ Time = 2428752062
	 Thread Active MQ Time = 2429060497
	 Thread Active MQ Time = 2429507964
	 Thread Active MQ Time = 2429258212
	 Thread Active MQ Time = 2429599801
	 Thread Active MQ Time = 2430106341
	 Thread Active MQ Time = 2429810578
	 Thread Active MQ Time = 2429693313
	 Thread Active MQ Time = 2198517937
	 Thread Active MQ Time = 2198662762
	 Thread Active MQ Time = 2200078985
	 Thread Active MQ Time = 2199938155
	 Thread Active MQ Time = 2199901325
	 Thread Active MQ Time = 2200646134
	 Thread Active MQ Time = 2199806033
	 Thread Active MQ Time = 2200140479
	 Thread Active MQ Time = 2908990853
	 Thread Active MQ Time = 2910640265
	 Thread Active MQ Time = 2912693657
	 Thread Active MQ Time = 2913285830
	 Thread Active MQ Time = 2913753886
	 Thread Active MQ Time = 2916958587
	 Thread Active MQ Time = 2919218714
	 Thread Active MQ Time = 2918644098
	 Thread Active MQ Time = 2173948015
	 Thread Active MQ Time = 2173493783
	 Thread Active MQ Time = 2173395132
	 Thread Active MQ Time = 2173684778
	 Thread Active MQ Time = 2174661581
	 Thread Active MQ Time = 2173971846
	 Thread Active MQ Time = 2173001796
	 Thread Active MQ Time = 1933887173
	 Thread Active MQ Time = 1934394755
	 Thread Active MQ Time = 1933511152
	 Thread Active MQ Time = 1935561752
	 Thread Active MQ Time = 1938384495
	 Thread Active MQ Time = 1936227337
	 Thread Active MQ Time = 1938578136
	 Thread Active MQ Time = 1992569057
	 Thread Active MQ Time = 1991025557
	 Thread Active MQ Time = 1991730941
	 Thread Active MQ Time = 1993264151
	 Thread Active MQ Time = 1987364069
	 Thread Active MQ Time = 1997283268
	 Thread Active MQ Time = 1991078046
	 Thread Active MQ Time = 994259235
	 Thread Active MQ Time = 1945998952
	 Thread Active MQ Time = 1945080704
	 Thread Active MQ Time = 1946113579
	 Thread Active MQ Time = 1946486621
	 Thread Active MQ Time = 1948489000
	 Thread Active MQ Time = 1908488416
	 Thread Active MQ Time = 1902888053
	 Thread Active MQ Time = 1923752782
	 Thread Active MQ Time = 1929960809
	 Thread Active MQ Time = 1924357732
	 Thread Active MQ Time = 1924643143
	 Thread Active MQ Time = 1913180114
	 Thread Active MQ Time = 1906232345
	 Thread Active MQ Time = 1669586845
	 Thread Active MQ Time = 1895381486
	 Thread Active MQ Time = 1895006241
	 Thread Active MQ Time = 1895210090
	 Thread Active MQ Time = 1895189728
	 Thread Active MQ Time = 1888927124
	 Thread Active MQ Time = 1901292041
	 Thread Active MQ Time = 1649050034
	 Thread Active MQ Time = 1897171483
	 Thread Active MQ Time = 1897344205
	 Thread Active MQ Time = 1897097361
	 Thread Active MQ Time = 1898429454
	 Thread Active MQ Time = 1900428316
	 Thread Active MQ Time = 1946547751
	 Thread Active MQ Time = 1951159970
	 Thread Active MQ Time = 1955074881
	 Thread Active MQ Time = 1955059896
	 Thread Active MQ Time = 1955141122
	 Thread Active MQ Time = 1954944590
	 Thread Active MQ Time = 1958395585
	 Thread Active MQ Time = 1079985236
	 Thread Active MQ Time = 1425940050
	 Thread Active MQ Time = 1897001965
	 Thread Active MQ Time = 1426549953
	 Thread Active MQ Time = 1896878328
	 Thread Active MQ Time = 1898074181
	 Thread Active MQ Time = 17663328894
	 Thread Active MQ Time = 1635618358
	 Thread Active MQ Time = 1138790059
	 Thread Active MQ Time = 1213186643
	 Thread Active MQ Time = 1959027312
	 Thread Active MQ Time = 1558321393
	 Thread Active MQ Time = 1417943221
	 Thread Active MQ Time = 2110067011
	 Thread Active MQ Time = 1244878114
	 Thread Active MQ Time = 904799523
	 Thread Active MQ Time = 1317494276
	 Thread Active MQ Time = 1922607888
	 Thread Active MQ Time = 914926716
	 Thread Active MQ Time = 1356454025
	 Thread Active MQ Time = 1089682102

Total Active MQ Time	= 28712521766

	 Thread Kafka Time 	= 801267112
	 Thread Kafka Time 	= 817573997
	 Thread Kafka Time 	= 825632792
	 Thread Kafka Time 	= 825637849
	 Thread Kafka Time 	= 830864446
	 Thread Kafka Time 	= 830857397
	 Thread Kafka Time 	= 840976566
	 Thread Kafka Time 	= 843676116
	 Thread Kafka Time 	= 938689324
	 Thread Kafka Time 	= 946502167
	 Thread Kafka Time 	= 942798425
	 Thread Kafka Time 	= 949470259
	 Thread Kafka Time 	= 953500508
	 Thread Kafka Time 	= 966933258
	 Thread Kafka Time 	= 955531043
	 Thread Kafka Time 	= 979338699
	 Thread Kafka Time 	= 1174657762
	 Thread Kafka Time 	= 1168007672
	 Thread Kafka Time 	= 1163946385
	 Thread Kafka Time 	= 1177169036
	 Thread Kafka Time 	= 1165592718
	 Thread Kafka Time 	= 1153963609
	 Thread Kafka Time 	= 1152536652
	 Thread Kafka Time 	= 1154531934
	 Thread Kafka Time 	= 1024975537
	 Thread Kafka Time 	= 1011541778
	 Thread Kafka Time 	= 1026310742
	 Thread Kafka Time 	= 1021549355
	 Thread Kafka Time 	= 1023381328
	 Thread Kafka Time 	= 1029833996
	 Thread Kafka Time 	= 1028304004
	 Thread Kafka Time 	= 1021554432
	 Thread Kafka Time 	= 978438549
	 Thread Kafka Time 	= 998193914
	 Thread Kafka Time 	= 983536970
	 Thread Kafka Time 	= 975542835
	 Thread Kafka Time 	= 980558968
	 Thread Kafka Time 	= 973882038
	 Thread Kafka Time 	= 981453360
	 Thread Kafka Time 	= 966674216
	 Thread Kafka Time 	= 973154946
	 Thread Kafka Time 	= 953961207
	 Thread Kafka Time 	= 963286431
	 Thread Kafka Time 	= 964911172
	 Thread Kafka Time 	= 972009410
	 Thread Kafka Time 	= 962072169
	 Thread Kafka Time 	= 971189658
	 Thread Kafka Time 	= 968184814
	 Thread Kafka Time 	= 1084530403
	 Thread Kafka Time 	= 1091050514
	 Thread Kafka Time 	= 1090695382
	 Thread Kafka Time 	= 1093504676
	 Thread Kafka Time 	= 1100708398
	 Thread Kafka Time 	= 1105847464
	 Thread Kafka Time 	= 1110882693
	 Thread Kafka Time 	= 1110873312
	 Thread Kafka Time 	= 1109383720
	 Thread Kafka Time 	= 1086011522
	 Thread Kafka Time 	= 1092718753
	 Thread Kafka Time 	= 1084201393
	 Thread Kafka Time 	= 1096083912
	 Thread Kafka Time 	= 1075496786
	 Thread Kafka Time 	= 1086209256
	 Thread Kafka Time 	= 1097839449
	 Thread Kafka Time 	= 1011472732
	 Thread Kafka Time 	= 1018773316
	 Thread Kafka Time 	= 1006456778
	 Thread Kafka Time 	= 1017759110
	 Thread Kafka Time 	= 1022637809
	 Thread Kafka Time 	= 1022388611
	 Thread Kafka Time 	= 1014981209
	 Thread Kafka Time 	= 1031526000
	 Thread Kafka Time 	= 1688467277
	 Thread Kafka Time 	= 1697499716
	 Thread Kafka Time 	= 1701133494
	 Thread Kafka Time 	= 1699697450
	 Thread Kafka Time 	= 1683482506
	 Thread Kafka Time 	= 1699680586
	 Thread Kafka Time 	= 1738826742
	 Thread Kafka Time 	= 1737858027
	 Thread Kafka Time 	= 666755382
	 Thread Kafka Time 	= 1246107344
	 Thread Kafka Time 	= 1247002454
	 Thread Kafka Time 	= 1253468773
	 Thread Kafka Time 	= 1269902179
	 Thread Kafka Time 	= 1218155477
	 Thread Kafka Time 	= 1220074898
	 Thread Kafka Time 	= 1211282057
	 Thread Kafka Time 	= 1227104962
	 Thread Kafka Time 	= 1213026162
	 Thread Kafka Time 	= 1238908608
	 Thread Kafka Time 	= 1235566424
	 Thread Kafka Time 	= 1218136487
	 Thread Kafka Time 	= 1222321794
	 Thread Kafka Time 	= 1024692646
	 Thread Kafka Time 	= 1065696905
	 Thread Kafka Time 	= 810878173
	 Thread Kafka Time 	= 711431372
	 Thread Kafka Time 	= 660207220
	 Thread Kafka Time 	= 738847661

Total Kafka Time = 14219167969

