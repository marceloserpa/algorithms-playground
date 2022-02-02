#!/usr/bin/env sh

DIR="tmp"

if [ -d "$DIR" ]; then
  rm -R tmp/*
else
  mkdir tmp
fi

mkdir tmp/deque

cp src/main/java/* tmp/deque/

cd tmp

zip deque.zip deque/*