# Corba "Hello world"

It uses openjdk-8-jdk, later versions have discontinued the Corba support. The docker image is created by installing openjdk-8-jdk in ubuntu-latest, running idlj -fall idl/Hello.idl to get HelloApp generated.

In the client image following commands are run

###### javac  Client/*.java
###### javac  HelloApp/*.java

 In the server image 900 is exposed and following commands are run

###### javac  Server/*.java
###### javac  HelloApp/*.java

To run the app, just clone it and execute following command 
#### docker-compose up