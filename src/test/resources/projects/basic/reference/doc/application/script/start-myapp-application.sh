#!/bin/bash
# Start application

JAVA_HOME=/apps/JRE8/jdk1.8.0_40

APP_SCRIPT=myapp-application
APP_HOME=/apps/myapp/application
APP_JAR=$APP_HOME/service/myapp-application.jar
APP_MAIN=com.oryam.maven.myapp.application.boot.ApplicationBoot
APP_STATIC_RES=file:$APP_HOME/front/

JAVA_OPTS=
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDetails"
JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDateStamps"
JAVA_OPTS="$JAVA_OPTS -Xloggc:$APP_HOME/logs/gc-$APP_SCRIPT.log"
JAVA_OPTS="$JAVA_OPTS -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=3 -XX:GCLogFileSize=50M"
JAVA_OPTS="$JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.port=9210"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.local.only=false"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false"
JAVA_OPTS="$JAVA_OPTS -XX:+UnlockCommercialFeatures"
JAVA_OPTS="$JAVA_OPTS -XX:+FlightRecorder"

# 0. local mem db
APP_OPTS="--app.static.location=$APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web"

# 1. env-dev oracle db
#APP_OPTS="--app.static.location=$APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web,oracle,env-dev"

# 2. env-rec oracle db
#APP_OPTS="--app.static.location=$APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web,oracle,env-rec"

cd $APP_HOME
nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar $APP_JAR $APP_MAIN $APP_OPTS </dev/null >/dev/null 2>&1 & echo $! >$APP_HOME/pid/$APP_SCRIPT.pid

exit 0
