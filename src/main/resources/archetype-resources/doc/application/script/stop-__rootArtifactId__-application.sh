#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
${symbol_pound}!/bin/bash
${symbol_pound} Stop application

APP_USER=${rootArtifactId}
APP_SCRIPT=${rootArtifactId}-application
APP_HOME=/apps/${rootArtifactId}/application

${symbol_pound}ps -fe | grep java | grep ${symbol_dollar}APP_USER | grep -v grep | gawk '{print ${symbol_dollar}2}' | xargs kill -9
kill -9 ${symbol_dollar}(cat ${symbol_dollar}APP_HOME/pid/${symbol_dollar}APP_SCRIPT.pid)

exit 0
