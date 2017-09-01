#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
${symbol_pound}!/bin/bash
${symbol_pound} Initialize server for application

${symbol_pound} Use root user to create folders in /apps/${rootArtifactId}
echo Connect as root to create folders in /apps/${rootArtifactId}
read -p "Press any key to continue..."

cd /apps/${rootArtifactId}

${symbol_pound} Create folders with access rights
folders=( archive temp application application/bin application/service application/front application/logs application/pid )
for i in "${symbol_dollar}{folders[@]}"
do
    mkdir ${symbol_dollar}i
    chown ${rootArtifactId}:${rootArtifactId} ${symbol_dollar}i
    chmod 744 ${symbol_dollar}i
done

${symbol_pound} Initialize empty files with access rights
files=( init-application.sh deploy.sh application/bin/start-${rootArtifactId}-application.sh application/bin/stop-${rootArtifactId}-application.sh application/bin/check-${rootArtifactId}-application.sh application/service/${rootArtifactId}-application.jar )
for i in "${symbol_dollar}{files[@]}"
do
    touch ${symbol_dollar}i
    chown ${rootArtifactId}:${rootArtifactId} ${symbol_dollar}i
    chmod 744 ${symbol_dollar}i
done


${symbol_pound}dos2unix init-application.sh
${symbol_pound}chown ${rootArtifactId}:${rootArtifactId} init-application.sh
${symbol_pound}chmod 744 init-application.sh

exit 0
