# Dockerfile multisatge
FROM maven:3.5.4-jdk-8-alpine AS build

WORKDIR myApp/

COPY pom.xml .

ADD settings.xml /tmp

RUN mvn -s /tmp/settings.xml -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.1.1:go-offline
COPY src ./src
RUN mvn -s /tmp/settings.xml -B -e -C -T 1C package

#######################################################################

FROM payara/server-full:5.193.1

#Allows autodeploy
RUN chown payara:payara /opt/payara/appserver/glassfish/domains/production/autodeploy/
#installs postgresql jdbc driver
#and adds a jdbc connection pool and ressource

ENV ASADMIN=/opt/payara/appserver/bin/asadmin

RUN wget https://jdbc.postgresql.org/download/postgresql-42.2.8.jar \
         -O /opt/payara/appserver/glassfish/domains/production/lib/postgresql.jar && \
    ${ASADMIN} start-domain && \
    ${ASADMIN} --user admin \
    			      --passwordfile=${PASSWORD_FILE} \
    			      set-hazelcast-configuration --enabled=true --dynamic=true && \
    ${ASADMIN} --user admin \
                              --passwordfile=${PASSWORD_FILE} \
			       create-jdbc-connection-pool \
			        --datasourceclassname org.postgresql.ds.PGConnectionPoolDataSource  \
			        --restype javax.sql.ConnectionPoolDataSource \
				--property portNumber=5432:password=glassfishdbpassword:user=glassfish:serverName=db:databaseName=glassfish \
				postgres-pool && \
    ${ASADMIN} --user admin \
                              --passwordfile=${PASSWORD_FILE} \
			       create-jdbc-resource --connectionpoolid postgres-pool jdbc/postgres-pool && \
    ${ASADMIN} stop-domain

COPY --from=build --chown=payara:payara /myApp/target/*-SNAPSHOT.war /opt/payara/deployments/server.war