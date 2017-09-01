#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
$symbol_pound DEPLOY


$symbol_pound INSTALLATION

A complete guide to install the deployable environment from scratch. 
Take steps you need, depending your use case.



$symbol_pound$symbol_pound with `root` user

* As `root` user, check if `${rootArtifactId}` user exist
`cat /etc/passwd | grep ${rootArtifactId}`
`cat /etc/group | grep ${rootArtifactId}`

* Create the apps home directory
`mkdir /apps/${rootArtifactId}`

* As root user, check if `${rootArtifactId}` user exist
`adduser --no-create-home --home /apps/${rootArtifactId} ${rootArtifactId}`
`passwd ${rootArtifactId}` $symbol_pound example of password: ${rootArtifactId}WD1

* In case you need to remove the user
`userdel ${rootArtifactId}`
(use -r option to remove the home dir `userdel -r ${rootArtifactId}`)

* prepare empty `init-application.sh`
`touch /apps/${rootArtifactId}/init-application.sh`
`chown ${rootArtifactId}:${rootArtifactId} /apps/${rootArtifactId}/init-application.sh`
`chmod 744 /apps/${rootArtifactId}/init-application.sh`



$symbol_pound$symbol_pound with `root` user in `/apps/${rootArtifactId}/`

- go into `/apps/${rootArtifactId}/`
- check the content of your script `init-application.sh`
- copy/upload on the server the script `init-application.sh`
- check/apply execution right for owner `${rootArtifactId}`
- run `dos2unix init-application.sh`
- apply again ${rootArtifactId} right `chown ${rootArtifactId}:${rootArtifactId} init-application.sh`
- execute `init-application.sh`

- check the content of your script `deploy.sh`
- copy the `deploy.sh`
- check/apply execution right for owner `${rootArtifactId}`
- run `dos2unix deploy.sh`
- apply again ${rootArtifactId} right `chown ${rootArtifactId}:${rootArtifactId} deploy.sh`



$symbol_pound$symbol_pound with `${rootArtifactId}` user in `/apps/${rootArtifactId}/application/bin`

- go into `/apps/${rootArtifactId}/application/bin`

- copy/upload on the server the script `check-${rootArtifactId}-application.sh`
- copy/upload on the server the script `start-${rootArtifactId}-application.sh`
- copy/upload on the server the script `stop-${rootArtifactId}-application.sh`

Optional: In case files are not in UNIX format, run dos2unix as root, then apply ${rootArtifactId} owner right
- run `dos2unix *.sh`
- apply again ${rootArtifactId} right `chown ${rootArtifactId}:${rootArtifactId} *.sh`



$symbol_pound$symbol_pound with `${rootArtifactId}` user in `/apps/${rootArtifactId}/`

- go into `/apps/${rootArtifactId}/`
- run `./deploy.sh`

- when application is completely started, upload static resources (html, js, ...), in `/apps/${rootArtifactId}/application/front`
	- delete existing ones
	- upload new ones

$symbol_pound Check

Make some checks on files.

- application class name for main in start script.
- jmx port not already used in start script.


$symbol_pound Virtual partition

Useful command lines to check or create partition and mount.

$symbol_pound$symbol_pound Info

df -k
vgs    $symbol_pound virtual ...
lvs    $symbol_pound logical volume info
lvdisplay    $symbol_pound logical volume details
pvs          $symbol_pound physical volume

$symbol_pound$symbol_pound Create

lvcreate -L 1G -n lv_${rootArtifactId} vg_apps

cat /etc/fstab
vi /etc/fstab    $symbol_pound add the mount point, yy, p
mkfs -t ext4 /dev/vg_apps/lv_${rootArtifactId}
mount /apps/${rootArtifactId}

$symbol_pound$symbol_pound Reduce size

umount /apps/${rootArtifactId}
lvreduce -L 1G vg_apps/lv_${rootArtifactId}
mount /apps/${rootArtifactId}

