FROM centos:7

RUN yum install -y java-1.8.0-openjdk-headless \
    && yum clean all -y \
    && mkdir -p /opt/lib \
    && mkdir -p  /data/home/my-base-service/config \
    && mkdir -p  /data/home/my-base-service/lib

COPY target/my-base-service-0.0.1-SNAPSHOT.jar /opt/lib

WORKDIR  /opt/lib

CMD ["java","-jar",\
            "-server",\
            "-Xmx300m",\
            "-Xms300m",\
            "-Xmn100m",\
            "-Dspring.config.location=/data/home/my-base-service/config/application.properties",\
            "-Dlogging.config=/data/home/my-base-service/config/logback.xml",\
            "/opt/lib/my-base-service-0.0.1-SNAPSHOT.jar"]

