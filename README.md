write generating code.

sur hdfs : Il faut créer le dossier et donner les autorisations pour pouvoir y écrire depuis spark.
par défaut les autorisations sont 750. rwxr-x---


pour acceder a hdfs :

1\ ssh root@127.0.0.1 -p 2222 => acces root sur le host du sandbox.
2\ su hdfs => pour acceder en tant que user hdfs ( pour pouvoir changer les autorisations)
3\ créer un dossier sous hdfs. par exemple /work/lansrodTAF.
4\ changer les autorisation : hdfs dfs -chmod 777 /work/lasrodTAF. (si tu ne fait pas ça tu aura permission denied lors de l'exécution du code)



--------------------------

Kafka : 
commence par créer un topic kafka.
sudo ssh root@127.0.0.1 -p 22.
cd /usr/hdp/current/kafka-broker/bin
./kafka-topics.sh --create --zookeeper 127.0.0.1:2181 --replication-factor 1 --partitions 1 --topic lansrodTAF  (bootstrap servers is depricated you should provide zookeeper host and port instead)




