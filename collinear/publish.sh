#!/usr/bin/env sh

DIR="tmp"

if [ -d "$DIR" ]; then
  rm -R tmp/*
else
  mkdir tmp
fi

mkdir tmp/collinear

cp src/main/java/BruteCollinearPoints.java tmp/collinear/BruteCollinearPoints.java
cp src/main/java/FastCollinearPoints.java tmp/collinear/FastCollinearPoints.java
cp src/main/java/LineSegment.java tmp/collinear/LineSegment.java
cp src/main/java/Point.java tmp/collinear/Point.java

cd tmp

zip collinear.zip collinear/*