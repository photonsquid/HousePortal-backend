FROM quay.io/wildfly/wildfly-centos7:latest
ADD target/backend.war /opt/wildfly/standalone/deployments