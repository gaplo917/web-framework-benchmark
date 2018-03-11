## Introduction
The main purpose of this performance-test is to verify my implementation of https://github.com/gaplo917/single-vertx-kotlin.

[Vert.x](http://vertx.io/) is incredibly flexible and performant. I started use
Vert.x Koltin to build stateless API Server and targeted to build a express-liked API in Kotlin.

The "Multiple Verticle" concept may not be suitable for running stateless
Vert.x in microservice architecture. As it should be a stateless API Server,
it can scale horizontal easily and automatically scale by kubernetes.

## Single verticle + Coroutine handling all request
TODO

## Testing Server Environment
Google cloud platform
Machine type: n1-highcpu-4 (1 vCPUs, 3.75 GB memory), n1-highcpu-4 (4 vCPUs, 3.6 GB memory)
CPU platform: Intel Broadwell
Zone: asia-southeast1-a
OS: Ubuntu 16.04


## Testing Client Environment
Google cloud platform
Machine type: n1-highcpu-8 (8 vCPUs, 7.2 GB memory)
CPU platform: Intel Broadwell
Zone: asia-southeast1-a
OS: Ubuntu 16.04

Using HTTP benchmarking tool written in Go
https://github.com/codesenberg/bombardier

## Benchmark result
TODO

## Conclusion
TODO


## Running Benchmark example
```
# Run script template
sh run.sh {bench_to_run} {endpoint} {save_path} {machine_name}

# Example
sh run.sh bombardier_5x_less.sh http://10.148.0.2:8080/ ./single-vertx-with-kt-coroutine/ n1-standard-1
sh run.sh bombardier.sh http://10.148.0.2:8080/ ./expressjs/ n1-highcpu-4
```
