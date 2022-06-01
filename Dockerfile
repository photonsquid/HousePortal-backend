FROM quay.io/wildfly/wildfly-centos7:latest
COPY target/backend.war /opt/wildfly/standalone/deployments/ROOT.war
COPY scripts/standalone.xml /opt/wildfly/standalone/configuration/standalone.xml
# RUN mv /opt/wildfly/standalone/deployments/backend.war /opt/wildfly/standalone/deployments/ROOT.war
# RUN $JBOSS_HOME/bin/jboss-cli.sh --connect \ /subsystem=undertow/server=default-server/host=default-host/location=\/:remove
# RUN $JBOSS_HOME/bin/jboss-cli.sh --connect \ /subsystem=undertow/server=default-server/host=default-host:write-attribute(name=default-web-module, value=backend.war) \ reload

COPY scripts/change_root.sh /usr/local/bin/change_root.sh 
USER root
RUN chmod +x /usr/local/bin/change_root.sh 
# CMD ["change_root.sh"]