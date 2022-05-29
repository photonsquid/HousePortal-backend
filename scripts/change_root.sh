#!/bin/bash

# remove the default Welcome application 
echo "/subsystem=undertow/server=default-server/host=default-host/location=\/:remove
reload
" | /opt/wildfly/bin/jboss-cli.sh --connect


# set the default-web-module of your undertow host 
echo "/subsystem=undertow/server=default-server/host=default-host:write-attribute(name=default-web-module, value=backend.war)
reload
" | /opt/wildfly/bin/jboss-cli.sh --connect
