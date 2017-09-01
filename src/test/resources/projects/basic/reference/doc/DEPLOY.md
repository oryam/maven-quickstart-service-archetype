# DEPLOY


# INSTALLATION

A complete guide to install the deployable environment from scratch. 
Take steps you need, depending your use case.



## with `root` user

* As `root` user, check if `myapp` user exist
`cat /etc/passwd | grep myapp`
`cat /etc/group | grep myapp`

* Create the apps home directory
`mkdir /apps/myapp`

* As root user, check if `myapp` user exist
`adduser --no-create-home --home /apps/myapp myapp`
`passwd myapp` # example of password: myappWD1

* In case you need to remove the user
`userdel myapp`
(use -r option to remove the home dir `userdel -r myapp`)

* prepare empty `init-application.sh`
`touch /apps/myapp/init-application.sh`
`chown myapp:myapp /apps/myapp/init-application.sh`
`chmod 744 /apps/myapp/init-application.sh`



## with `root` user in `/apps/myapp/`

- go into `/apps/myapp/`
- check the content of your script `init-application.sh`
- copy/upload on the server the script `init-application.sh`
- check/apply execution right for owner `myapp`
- run `dos2unix init-application.sh`
- apply again myapp right `chown myapp:myapp init-application.sh`
- execute `init-application.sh`

- check the content of your script `deploy.sh`
- copy the `deploy.sh`
- check/apply execution right for owner `myapp`
- run `dos2unix deploy.sh`
- apply again myapp right `chown myapp:myapp deploy.sh`



## with `myapp` user in `/apps/myapp/application/bin`

- go into `/apps/myapp/application/bin`

- copy/upload on the server the script `check-myapp-application.sh`
- copy/upload on the server the script `start-myapp-application.sh`
- copy/upload on the server the script `stop-myapp-application.sh`

Optional: In case files are not in UNIX format, run dos2unix as root, then apply myapp owner right
- run `dos2unix *.sh`
- apply again myapp right `chown myapp:myapp *.sh`



## with `myapp` user in `/apps/myapp/`

- go into `/apps/myapp/`
- run `./deploy.sh`

- when application is completely started, upload static resources (html, js, ...), in `/apps/myapp/application/front`
	- delete existing ones
	- upload new ones

# Check

Make some checks on files.

- application class name for main in start script.
- jmx port not already used in start script.


# Virtual partition

Useful command lines to check or create partition and mount.

## Info

df -k
vgs    # virtual ...
lvs    # logical volume info
lvdisplay    # logical volume details
pvs          # physical volume

## Create

lvcreate -L 1G -n lv_myapp vg_apps

cat /etc/fstab
vi /etc/fstab    # add the mount point, yy, p
mkfs -t ext4 /dev/vg_apps/lv_myapp
mount /apps/myapp

## Reduce size

umount /apps/myapp
lvreduce -L 1G vg_apps/lv_myapp
mount /apps/myapp

