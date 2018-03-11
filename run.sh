#!/bin/bash
url="$2"
result_path="$3"

# clean pervious
rm -rf "$result_path$4-0ms";
rm -rf "$result_path$4-2ms";
rm -rf "$result_path$4-5ms";
rm -rf "$result_path$4-10ms";

sh $1 $url "$result_path$4-0ms";
sh $1 "$url/2ms" "$result_path$4-2ms";
sh $1 "$url/5ms" "$result_path$4-5ms";
sh $1 "$url/10ms" "$result_path$4-10ms";
