#!/bin/bash

targetFolder="$(dirname $0)/../libs"

if test ! -d "$targetFolder"
then
   mkdir "$targetFolder"
fi

cd "$targetFolder"

if test ! -e commons-logging-1.2.jar
then
   wget http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
fi

if test ! -e commons-codec-1.10.jar
then
   wget http://central.maven.org/maven2/commons-codec/commons-codec/1.10/commons-codec-1.10.jar
fi

if test ! -e gson-2.3.1.jar
then
   wget http://central.maven.org/maven2/com/google/code/gson/gson/2.3.1/gson-2.3.1.jar
fi

if test ! -e httpclient-4.5.jar
then
   wget http://central.maven.org/maven2/org/apache/httpcomponents/httpclient/4.5/httpclient-4.5.jar
fi

if test ! -e httpcore-4.4.3.jar
then
   wget http://central.maven.org/maven2/org/apache/httpcomponents/httpcore/4.4.3/httpcore-4.4.3.jar
fi
