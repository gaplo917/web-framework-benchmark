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
    ulimit -n 10000
    go get -u github.com/kataras/iris

    # Single Core
    GOMAXPROCS=1 go run main.go

    # 4 Core
    GOMAXPROCS=4 go run main.go
```

## CPU Utlization under test
4 thread 100%
