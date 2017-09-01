#!/bin/bash
# Stop application

APP_USER=myapp
APP_SCRIPT=myapp-application
APP_HOME=/apps/myapp/application

#ps -fe | grep java | grep $APP_USER | grep -v grep | gawk '{print $2}' | xargs kill -9
kill -9 $(cat $APP_HOME/pid/$APP_SCRIPT.pid)

exit 0
