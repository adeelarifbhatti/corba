FROM ubuntu:latest
LABEL maintainer="adeelarifbhatti@gmail.com"
WORKDIR /app
RUN apt-get update && apt-get install -y openjdk-8-jdk
COPY Client Client
COPY idl idl
# COPY HelloApp HelloApp
COPY Server Server
COPY start.sh ./
EXPOSE 900
RUN idlj -fall idl/Hello.idl
RUN javac HelloApp/*.java
RUN javac  Server/*.java
RUN chmod +x ./start.sh
ENTRYPOINT ["./start.sh"]
