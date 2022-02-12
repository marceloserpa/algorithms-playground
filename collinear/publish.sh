#!/usr/bin/env sh

DIR="tmp"

if [ -d "$DIR" ]; then
  rm -R tmp/*
else
  mkdir tmp
fi

mkdir tmp/collinear

cp src/main/java/* tmp/collinear/

cd tmp

zip collinear.zip collinear/*