#!/bin/bash
# Initialize server for application

# Use root user to create folders in /apps/myapp
echo Connect as root to create folders in /apps/myapp
read -p "Press any key to continue..."

cd /apps/myapp

# Create folders with access rights
folders=( archive temp application application/bin application/service application/front application/logs application/pid )
for i in "${folders[@]}"
do
    mkdir $i
    chown myapp:myapp $i
    chmod 744 $i
done

# Initialize empty files with access rights
files=( init-application.sh deploy.sh application/bin/start-myapp-application.sh application/bin/stop-myapp-application.sh application/bin/check-myapp-application.sh application/service/myapp-application.jar )
for i in "${files[@]}"
do
    touch $i
    chown myapp:myapp $i
    chmod 744 $i
done


#dos2unix init-application.sh
#chown myapp:myapp init-application.sh
#chmod 744 init-application.sh

exit 0
