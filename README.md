# Learn_Spring
学习Spring

## 关于JDK13 在 maven 出现版本错误5问题的解决
```
        <!--
          在pom.xml里加上如下代码强制制定JDK的版本就完事了，不需要对Idea做任何配置，当然你得保证本地有对应版本的JDK
        -->
       <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <!-- <version>3.7</version> 默认用最新的-->
                    <configuration>
                        <source>13</source>
                        <target>13</target>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
```
