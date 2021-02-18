#!/bin/bash
java -javaagent:/opt/newrelic/newrelic.jar -Xms1g -Xmx2g -Djava.security.egd=file:/dev/./urandom -jar target/postcode-suggestion-0.0.1-SNAPSHOT.jar \
--spring.profiles.active=nz \
--server.port=9598 \
& echo $! > ./pid_nz.file &

