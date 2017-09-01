#!/bin/bash
# Deploy application
# - stop application
# - backup conf, script, binaries, static resources
# - clean logs
# - TODO update script
# - TODO update conf
# - update binaries (.jar)
# - TODO update static resources (.html, .js, ...)
# - start application

APP_NAME=myapp-application
APP_ROOT=/apps/myapp
APP_HOME=$APP_ROOT/application
APP_SCRIPT=$APP_HOME/bin
APP_BACKEND=$APP_HOME/service
APP_HTML=$APP_HOME/front
APP_LOG=$APP_HOME/logs

NEXUS_URL=http://127.0.0.1:8081

APP_MAVEN_REPO_ID_SNAPSHOT=app-snapshots
APP_MAVEN_REPO_ID_RELEASE=app-releases
APP_MAVEN_GROUP_ID=com.oryam.maven.myapp
APP_MAVEN_ARTEFACT_ID=myapp-application
APP_MAVEN_CURRENT_VERSION=0.0.1-SNAPSHOT
APP_MAVEN_PACKAGE=jar
APP_MAVEN_BIN_NAME=myapp-application.jar
APP_MAVEN_BIN_DEST=$APP_BACKEND/$APP_MAVEN_BIN_NAME



# Use user account
echo Connect as myapp to run this script
read -p "Press any key to continue..."

cd $APP_ROOT


# === Stop application ===
echo Stopping application...
$APP_SCRIPT/stop-$APP_NAME.sh
read -p "Press any key to continue..."
$APP_SCRIPT/check-$APP_NAME.sh


# === Backup application ===
echo Archiving application folder...
datepattern=$(date '+%Y%m%d%H%M')
zip -r "archive/application_$datepattern.zip" application
read -p "Press any key to continue..."


# === Clean logs ===
echo Cleaning logs...
rm -f $APP_LOG/*$APP_NAME.log*
read -p "Press any key to continue..."


# === Download the lastest version ===
echo Updating application...
read -p "Enter: version ($APP_MAVEN_CURRENT_VERSION):" version
version=${version:-$APP_MAVEN_CURRENT_VERSION}

repo=$APP_MAVEN_REPO_ID_RELEASE
if [[ $version == *"SNAPSHOT"* ]]; then
  repo=$APP_MAVEN_REPO_ID_SNAPSHOT
fi

wget -O $APP_BACKEND/$APP_MAVEN_BIN_NAME "$NEXUS_URL/nexus/service/local/artifact/maven/redirect?r=$repo&g=$APP_MAVEN_GROUP_ID&a=$APP_MAVEN_ARTEFACT_ID&v=$version&p=$APP_MAVEN_PACKAGE"
read -p "Press any key to continue..."


# === Start application ===
echo Starting application...
$APP_SCRIPT/start-$APP_NAME.sh


echo "see logs: tail -f $APP_LOG/$APP_NAME.log" 


#dos2unix deploy.sh

exit 0
