#!/bin/bash
url="$2"
result_path="$3"

# clean pervious
rm -rf "$result_path$4-0ms";
rm -rf "$result_path$4-2ms";
rm -rf "$result_path$4-5ms";
rm -rf "$result_path$4-10ms";

echo "Start running 0ms benchmark...";
sh $1 $url "$result_path$4-0ms";

echo "Start running 10ms benchmark...";
sh $1 "$url/10ms" "$result_path$4-10ms";
