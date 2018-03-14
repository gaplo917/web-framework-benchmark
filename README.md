## Benchmark Objective
The main purpose of this performance-test is to verify my implementation of https://github.com/gaplo917/single-vertx-kotlin.

[Vert.x](http://vertx.io/) is incredibly flexible and performant. I started to use
Vert.x Koltin to build stateless API Server and targeted to build a express-liked API in Kotlin.

But with the power of kubernetes, the "Multiple Verticle" may not be suitable for running stateless
Vert.x in microservice architecture because any stateless service can be scaled horizontally on demand.

## Benchmark TODO
[x] Using a Go HTTP benchmark client to make N concurrent request in 30s
[x] Use d3 script to render the benchmark result
[ ] Automatically generate benchmark data for d3
[ ] Automatically run benchmark when adding a new web framework  


## Benchmark Performed
Make N concurrent request in 30s, where N in [50,125,250,500,1000,2000,4000]

Testing framework
* Express 
* Koa
* Go Iris
* Vert.x Kotlin with Custom coroutine implementation
* Spring boot
* PHP lumen (fpm + apache2)

Testing implemenation
* Directly reply "OK" (0ms I/O)
* 10ms I/O simulation

## Benchmark Server Environment
Google cloud platform
* Machine type: n1-standard-1 (1 vCPUs, 3.75 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1
* OS: Ubuntu 16.04


## Benchmark Client Environment
Google cloud platform
* Machine type: n1-highcpu-8 (8 vCPUs, 7.2 GB memory)
* CPU platform: Intel Broadwell
* Zone: asia-southeast1
* OS: Ubuntu 16.04

Using HTTP benchmarking tool written in Go
https://github.com/codesenberg/bombardier

## Benchmark result
* [Average Latency](https://rawgit.com/gaplo917/web-framework-benchmark/master/charting/latency/index.html)
* [Average Request/s](https://rawgit.com/gaplo917/web-framework-benchmark/master/charting/rps/index.html)

## Conclusion
TODO


## Running Benchmark example
```
# Run script template
sh run.sh {bench_to_run} {endpoint} {save_path} {machine_name}

# Example
sh run.sh bombardier.sh http://10.148.0.2:8080 ./single-vertx-with-kt-coroutine/ n1-standard-1
sh run.sh bombardier.sh http://10.148.0.2:8080 ./expressjs/ n1-highcpu-4
sh run.sh bombardier.sh http://10.148.0.5/blog/public/index.php ./php-laravel-lumen/ n1-standard-1
```
