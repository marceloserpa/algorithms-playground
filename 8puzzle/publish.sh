#!/usr/bin/env sh

DIR="tmp"

if [ -d "$DIR" ]; then
  rm -R tmp/*
else
  mkdir tmp
fi

mkdir tmp/8puzzle

cp src/main/java/Board.java tmp/8puzzle/Board.java
cp src/main/java/Solver.java tmp/8puzzle/Solver.java

cd tmp

zip 8puzzle.zip 8puzzle/*