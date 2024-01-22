#!/bin/bash
orbd -ORBInitialPort 900 -ORBInitialHost 0.0.0.0 &
sleep 5
echo "ORBD started on localhost and 900"
# javac  Client/*.java
java Server/HelloServer  -ORBInitialPort 900 -ORBInitialHost localhost
# java Client/HelloClient 



