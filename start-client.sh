#!/bin/bash
sleep 7
while true
do
java Client/HelloClient -ORBInitialPort 900 -ORBInitialHost server
	sleep 1
done




