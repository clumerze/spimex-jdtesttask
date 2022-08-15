#!/bin/bash

DEBUG_PORT=5005

for i in {1..10}; do
  pg_isready -t 10 -h postgres -p 5432

  READY_CODE=$?
  echo "READY_CODE:$READY_CODE"

  if [ $READY_CODE == 0 ];
    then
      echo "JAVA_OPTS:$JAVA_OPTS"
      java -agentlib:jdwp=transport=dt_socket,address=*:$DEBUG_PORT,server=y,suspend=n -jar api.jar
    break
  fi
  sleep 5s
done