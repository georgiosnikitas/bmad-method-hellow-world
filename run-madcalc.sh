#!/bin/bash
JAR="target/madcalc-1.0-SNAPSHOT.jar"
MAIN="school.madcalc.MadCalc"
if [ ! -f "$JAR" ]; then
  echo "JAR file not found: $JAR"
  echo "Please run: mvn package"
  exit 1
fi
exec java -cp "$JAR" $MAIN