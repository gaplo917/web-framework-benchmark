# Notes

## Java Version
```
    java -version
    openjdk version "1.8.0_151"
    OpenJDK Runtime Environment (build 1.8.0_151-8u151-b12-0ubuntu0.16.04.2-b12)
    OpenJDK 64-Bit Server VM (build 25.151-b12, mixed mode)
```
## Spring Boot Version
2.0

## Build executable
```
    ./gradlew build
```

## Run
```
    java -jar -server -Xms2G -Xmx3G -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+AggressiveOpts build/libs/gs-spring-boot-0.1.0.jar
```

# n1-highcpu-4 CPU Utlization under test
4 threads being utilized equally, mostly 100%
