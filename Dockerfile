FROM adoptopenjdk/openjdk11
RUN mkdir /app
ADD target/nginx-load-balancer-0.0.1-SNAPSHOT.jar /app/nginx-load-balancer-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app/nginx-load-balancer-0.0.1-SNAPSHOT.jar"]