Creating Spring Boot Apps as a Service
from 《Apress Pro Spring Boot》

Another amazing feature of Spring Boot is that you can run your app as a service. Running a Spring Boot
as a service has its benefits. It’s easy to install and manage, and if the server restarts, your app will start
automatically without you having to do it manually.
If you are using Unix, the only thing you need to do is add a configuration declaration to the Spring Boot
plugin in the pom.xml file and in build.gradle. See Listings 12-9 and 12-10
Listing 12-9. pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<!-- ...all the previous code -->
<build>
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <executable>true</executable>
        </configuration>
    </plugin>
</plugins>
</build>
</project>
Listing 12-9 shows the pom.xml file. The only thing that’s new is in the <plugin> tag, the
<configuration> tag that is making the WAR or JAR executable.
Listing 12-10. build.gradle
...
apply plugin: 'spring-boot'
springBoot {
    executable = true
}
...
Listing 12-10 shows the build.gradle. The only thing you need to add is the springBoot declaration.
Now, when you package your application with the following:

最好使用命令跳过测试: $ mvn clean package -Dmaven.test.skip=true
备用(编绎但不运行测试): $ ./mvnw clean package -DskipTests=true

You can execute the JAR directly:

$ target/spring-boot-journal-0.0.1-SNAPSHOT.war

And it will run! So, if you are running a UNIX environment you can just bind it to the /etc/init.d
(in a Debian environment, assuming you have the executable in the /opt folder):

$ ln -s /opt/spring-boot-journal-0.0.1-SNAPSHOT.war /etc/init.d/journal

我的命令:
sudo ln -s /home/sam/IdeaProjects/mvn-demos/sb-framework/app/target/app-1.0-SNAPSHOT.jar /etc/init.d/sb-framework-app
sudo chkconfig sb-framework-app on
sudo chkconfig --list sb-framework-app


Then you can start your application with the following:
$ service journal start

So simple! You’ll probably need to set up the run levels where the app might run. You can take a look at
your UNIX distribution to see what else you need to do in order to enable the journal app as a service.
Maybe you are wondering how is this possible. You can take a peek at the file. If you execute the
following command:
$ head -n 242 target/spring-boot-journal-0.0.1-SNAPSHOT.war
#!/bin/bash
...
...
You will see that the first 242 lines of the file are a BASH script. So, that’s how it runs.
