#!/bin/bash
url="http://10.148.0.4/blog/public/index.php"
result_path="./n1-highcpu-4"

# clean pervious result
rm -rf *ms;


sh ../bombardier_10x_less.sh $url "$result_path-0ms";
sh ../bombardier_10x_less.sh "$url/2ms" "$result_path-2ms";
sh ../bombardier_10x_less.sh "$url/5ms" "$result_path-5ms";
sh ../bombardier_10x_less.sh "$url/10ms" "$result_path-10ms";
