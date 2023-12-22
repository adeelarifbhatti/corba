How to run the Server

Navigate in the Docker directory, there are two files for the docker-compose, one is docker-
compose.yml file and the other is docker-compose-AllInOne.yml file. If you execute following

“#docker-compose up”
then two container will run, one will run the key/value server and the other will run the tomcat server
for api along with the orbd server. The key/value server will work when it get connected with the orbd
service running on the container which runs the tomcat server for api.
If you run the following
“#docker-compose -f docker-compose-AllInOne.yml up”
then it will run all the three service i.e. key/value server, orbd service and the api service on one
container.
