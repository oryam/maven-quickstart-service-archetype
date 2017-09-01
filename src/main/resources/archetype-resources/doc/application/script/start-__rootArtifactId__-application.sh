#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
${symbol_pound}!/bin/bash
${symbol_pound} Start application

JAVA_HOME=/apps/JRE8/jdk1.8.0_40

APP_SCRIPT=${rootArtifactId}-application
APP_HOME=/apps/${rootArtifactId}/application
APP_JAR=${symbol_dollar}APP_HOME/service/${rootArtifactId}-application.jar
APP_MAIN=com.oryam.maven.${rootArtifactId}.application.boot.ApplicationBoot
APP_STATIC_RES=file:${symbol_dollar}APP_HOME/front/

JAVA_OPTS=
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+PrintGCDetails"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+PrintGCDateStamps"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Xloggc:${symbol_dollar}APP_HOME/logs/gc-${symbol_dollar}APP_SCRIPT.log"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=3 -XX:GCLogFileSize=50M"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Dcom.sun.management.jmxremote"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Dcom.sun.management.jmxremote.port=9210"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Dcom.sun.management.jmxremote.local.only=false"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Dcom.sun.management.jmxremote.authenticate=false"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -Dcom.sun.management.jmxremote.ssl=false"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+UnlockCommercialFeatures"
JAVA_OPTS="${symbol_dollar}JAVA_OPTS -XX:+FlightRecorder"

${symbol_pound} 0. local mem db
APP_OPTS="--app.static.location=${symbol_dollar}APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web"

${symbol_pound} 1. env-dev oracle db
${symbol_pound}APP_OPTS="--app.static.location=${symbol_dollar}APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web,oracle,env-dev"

${symbol_pound} 2. env-rec oracle db
${symbol_pound}APP_OPTS="--app.static.location=${symbol_dollar}APP_STATIC_RES --spring.profiles.active=module-domain,module-persistence,module-web,oracle,env-rec"

cd ${symbol_dollar}APP_HOME
nohup ${symbol_dollar}JAVA_HOME/bin/java ${symbol_dollar}JAVA_OPTS -jar ${symbol_dollar}APP_JAR ${symbol_dollar}APP_MAIN ${symbol_dollar}APP_OPTS </dev/null >/dev/null 2>&1 & echo ${symbol_dollar}! >${symbol_dollar}APP_HOME/pid/${symbol_dollar}APP_SCRIPT.pid

exit 0
