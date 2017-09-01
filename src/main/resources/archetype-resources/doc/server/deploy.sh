#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
${symbol_pound}!/bin/bash
${symbol_pound} Deploy application
${symbol_pound} - stop application
${symbol_pound} - backup conf, script, binaries, static resources
${symbol_pound} - clean logs
${symbol_pound} - TODO update script
${symbol_pound} - TODO update conf
${symbol_pound} - update binaries (.jar)
${symbol_pound} - TODO update static resources (.html, .js, ...)
${symbol_pound} - start application

APP_NAME=${rootArtifactId}-application
APP_ROOT=/apps/${rootArtifactId}
APP_HOME=${symbol_dollar}APP_ROOT/application
APP_SCRIPT=${symbol_dollar}APP_HOME/bin
APP_BACKEND=${symbol_dollar}APP_HOME/service
APP_HTML=${symbol_dollar}APP_HOME/front
APP_LOG=${symbol_dollar}APP_HOME/logs

NEXUS_URL=http://127.0.0.1:8081

APP_MAVEN_REPO_ID_SNAPSHOT=app-snapshots
APP_MAVEN_REPO_ID_RELEASE=app-releases
APP_MAVEN_GROUP_ID=com.oryam.maven.${rootArtifactId}
APP_MAVEN_ARTEFACT_ID=${rootArtifactId}-application
APP_MAVEN_CURRENT_VERSION=0.0.1-SNAPSHOT
APP_MAVEN_PACKAGE=jar
APP_MAVEN_BIN_NAME=${rootArtifactId}-application.jar
APP_MAVEN_BIN_DEST=${symbol_dollar}APP_BACKEND/${symbol_dollar}APP_MAVEN_BIN_NAME



${symbol_pound} Use user account
echo Connect as ${rootArtifactId} to run this script
read -p "Press any key to continue..."

cd ${symbol_dollar}APP_ROOT


${symbol_pound} === Stop application ===
echo Stopping application...
${symbol_dollar}APP_SCRIPT/stop-${symbol_dollar}APP_NAME.sh
read -p "Press any key to continue..."
${symbol_dollar}APP_SCRIPT/check-${symbol_dollar}APP_NAME.sh


${symbol_pound} === Backup application ===
echo Archiving application folder...
datepattern=${symbol_dollar}(date '+%Y%m%d%H%M')
zip -r "archive/application_${symbol_dollar}datepattern.zip" application
read -p "Press any key to continue..."


${symbol_pound} === Clean logs ===
echo Cleaning logs...
rm -f ${symbol_dollar}APP_LOG/*${symbol_dollar}APP_NAME.log*
read -p "Press any key to continue..."


${symbol_pound} === Download the lastest version ===
echo Updating application...
read -p "Enter: version (${symbol_dollar}APP_MAVEN_CURRENT_VERSION):" version
version=${symbol_dollar}{version:-${symbol_dollar}APP_MAVEN_CURRENT_VERSION}

repo=${symbol_dollar}APP_MAVEN_REPO_ID_RELEASE
if [[ ${symbol_dollar}version == *"SNAPSHOT"* ]]; then
  repo=${symbol_dollar}APP_MAVEN_REPO_ID_SNAPSHOT
fi

wget -O ${symbol_dollar}APP_BACKEND/${symbol_dollar}APP_MAVEN_BIN_NAME "${symbol_dollar}NEXUS_URL/nexus/service/local/artifact/maven/redirect?r=${symbol_dollar}repo&g=${symbol_dollar}APP_MAVEN_GROUP_ID&a=${symbol_dollar}APP_MAVEN_ARTEFACT_ID&v=${symbol_dollar}version&p=${symbol_dollar}APP_MAVEN_PACKAGE"
read -p "Press any key to continue..."


${symbol_pound} === Start application ===
echo Starting application...
${symbol_dollar}APP_SCRIPT/start-${symbol_dollar}APP_NAME.sh


echo "see logs: tail -f ${symbol_dollar}APP_LOG/${symbol_dollar}APP_NAME.log" 


${symbol_pound}dos2unix deploy.sh

exit 0
