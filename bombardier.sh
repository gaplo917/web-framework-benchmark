#!/bin/bash
mkdir -p $2;

echo "running warmup...";
~/go/bin/bombardier --http2 -c 125 -n 20000 -l $1 > "$2/warmup1.txt";
~/go/bin/bombardier --http2 -c 250 -n 20000 -l $1 > "$2/warmup2.txt";

sleep 5;

for value in 50 125 250 500 1000 2000 4000
do
  echo "running concurrency = $value";
  ~/go/bin/bombardier --http2 -o json -p result -c $value -d 30s -l $1 | jq '.' | tee "$2/c$value.json" > /dev/null;
  sleep 5;
done


