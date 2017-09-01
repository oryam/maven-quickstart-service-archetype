# DOCUMENTATION


# How to initialize an archetype project

- From an existing project

`mvn archetype:create-from-project`

- Clean the generated folder
- Clean the metadata

- From the new generated folder copied elsewhere

`mvn clean install`

- Integration test with a reference project

`mvn clean install integration-test`


# How to generate a new project with the archetype

```
mvn archetype:generate                          \
  -DarchetypeGroupId=<archetype-groupId>        \
  -DarchetypeArtifactId=<archetype-artifactId>  \
  -DarchetypeVersion=<archetype-version>        \
  -DgroupId=<my.groupid>                        \
  -DartifactId=<my-artifactId>                  \
  -Dversion=<my-version>
```
  
`mvn archetype:generate -DarchetypeGroupId=com.oryam.maven.archetype -DarchetypeArtifactId=quickstart-service-archetype -DarchetypeVersion=1.0.4 -DgroupId=com.oryam.maven.myapp -DartifactId=myapp -Dversion=0.0.1-SNAPSHOT`



