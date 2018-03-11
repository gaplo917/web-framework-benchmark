#!/bin/bash
mkdir -p $2;

sudo ~/go/bin/bombardier -c 125 -n 100000 -l $1 > "$2/warmup1.txt";
sudo ~/go/bin/bombardier -c 250 -n 100000 -l $1 > "$2/warmup2.txt";

for value in 125 250 500 1000 2000 3000
do
  sudo ~/go/bin/bombardier -c $value -n 500000 -l $1 > "$2/c$value.txt";
done


