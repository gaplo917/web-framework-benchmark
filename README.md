## Introduction
The main purpose of this performance-test is to verify my implementation of https://github.com/gaplo917/single-vertx-kotlin.

[Vert.x](http://vertx.io/) is incredibly flexible and performant. I started to use
Vert.x Koltin to build stateless API Server and targeted to build a express-liked API in Kotlin.

But with the power of kubernetes, the "Multiple Verticle" may not be suitable for running stateless
Vert.x in microservice architecture because any stateless service can be scaled horizontally on demand.

## Single verticle + Coroutine handling all request
TODO

## Testing Server Environment
Google cloud platform
* Machine type: n1-standard-1 (1 vCPUs, 3.75 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1
* OS: Ubuntu 16.04


## Testing Client Environment
Google cloud platform
* Machine type: n1-highcpu-8 (8 vCPUs, 7.2 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1
* OS: Ubuntu 16.04

Using HTTP benchmarking tool written in Go
https://github.com/codesenberg/bombardier

## Benchmark result
TODO(checkout charting branch at this moment)

## Conclusion
TODO


## Running Benchmark example
```
# Run script template
sh run.sh {bench_to_run} {endpoint} {save_path} {machine_name}

# Example
sh run.sh bombardier.sh http://10.148.0.2:8080 ./single-vertx-with-kt-coroutine/ n1-standard-1
sh run.sh bombardier.sh http://10.148.0.2:8080 ./expressjs/ n1-highcpu-4
sh run.sh bombardier.sh http://10.148.0.5/blog/public/index.php ./php-laravel-
lumen/ n1-standard-1
```
