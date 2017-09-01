# DOCUMENTATION


## Dependencies

/lib
  ojdbc*.jar

`mvn install:install-file -Dfile=lib/ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1.0 -Dpackaging=jar -DgeneratePom=true`
`mvn install:install-file -Dfile=lib/ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1.0 -Dpackaging=jar -DgeneratePom=true`
`mvn install:install-file -Dfile=lib/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.1.0 -Dpackaging=jar -DgeneratePom=true`


## Modification

replace case sensitive, word, "myapp" by "yourOwnAppName" for package name, artifactId, groupId, linux user, script, ...


pom.xml
  svn / scm url
  repository
  dependencies


persistence-generate
  hibernate.cfg.xml
  hibernate.reveng.xml
  sql script


application.yml
  change port


.sh scripts
  user
  main bootable class name


## Run

Run the application with required module: --spring.profiles.active=module-domain,module-persistence,module-web

