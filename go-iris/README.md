# Notes

## Go Version
```
    go version
    go version go1.9.4 linux/amd64
```

## iris Version
v10.3.0 https://github.com/kataras/iris

## Run
```
    go get -u github.com/kataras/iris
    go run main.go
```

## CPU Utlization under test
4 thread 100%


## Problem
When running `-c 2000`, some connection maybe dropped and client encounter
long waiting. It affected the benchmark result(c2000.txt)
