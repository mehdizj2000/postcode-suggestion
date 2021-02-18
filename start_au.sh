#!/bin/bash
java -javaagent:/opt/newrelic/newrelic.jar -Xms1g -Xmx2g -Djava.security.egd=file:/dev/./urandom -jar target/postcode-suggestion-0.0.1-SNAPSHOT.jar \
--spring.profiles.active=au \
--server.port=9596 \
& echo $! > ./pid_au.file &

