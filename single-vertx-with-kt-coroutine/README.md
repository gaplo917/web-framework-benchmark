# Notes

## Java Version
```
    java -version
    openjdk version "1.8.0_151"
    OpenJDK Runtime Environment (build 1.8.0_151-8u151-b12-0ubuntu0.16.04.2-b12)
    OpenJDK 64-Bit Server VM (build 25.151-b12, mixed mode)
```

## Kotlin Version
1.2.10

## Vert.x Version
3.5.1

## Build executable
```
./gradlew clean fatJar
```

## Run
```
java -jar -server -Xms2G -Xmx3G -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+AggressiveOpts build/libs/single-vertx-kotlin-all-1.0-SNAPSHOT.jar
```

# n1-highcpu-4 CPU Utlization under test
1 thread ~100%
3 thread ~20-50%
