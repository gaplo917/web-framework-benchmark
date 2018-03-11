#!/bin/bash
url="http://10.148.0.4:8080/"
result_path="./n1-highcpu-4"

# clean pervious result
rm -rf *ms;


sh ../bombardier.sh $url "$result_path-0ms";
sh ../bombardier.sh "$url/2ms" "$result_path-2ms";
sh ../bombardier.sh "$url/5ms" "$result_path-5ms";
sh ../bombardier.sh "$url/10ms" "$result_path-10ms";
