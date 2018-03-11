## Introduction
The main purpose of this performance-test is to verify my implementation of https://github.com/gaplo917/single-vertx-kotlin.

[Vert.x](http://vertx.io/) is incredibly flexible and performant. I started use
Vert.x Koltin to build stateless API Server and targeted to build a express-liked API in Kotlin.

The "Multiple Verticle" concept may not be suitable for running stateless
Vert.x in microservice architecture. As it should be a stateless API Server,
it can scale horizontal easily and automatically scale by kubernetes.

## Single verticle + Coroutine handling all request
TODO

## Benchmark result
TODO

## Conclusion
TODO


## Testing Server Environment
Google cloud platform
* Machine type: n1-highcpu-4 (4 vCPUs, 3.6 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1-a
* OS: Ubuntu 16.04


## Testing Client Environment(different machine)
Google cloud platform
* Machine type: n1-highcpu-4 (4 vCPUs, 3.6 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1-a
* OS: Ubuntu 16.04

Using HTTP benchmarking tool written in Go
https://github.com/codesenberg/bombardier


## Running Benchmark example
```
cd expressjs

# config your endpoint & machine type
vi run.sh

# Run benchmark and be patient!
sh run.sh
```
