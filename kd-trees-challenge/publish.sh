#!/usr/bin/env sh

DIR="tmp"

if [ -d "$DIR" ]; then
  rm -R tmp/*
else
  mkdir tmp
fi

mkdir tmp/kd-tree

cp src/main/java/PointSET.java tmp/kd-tree/PointSET.java
cp src/main/java/KdTree.java tmp/kd-tree/KdTree.java

cd tmp

zip kd-tree.zip kd-tree/*