#!/bin/bash

export ANT_OPTS="-Djavax.xml.accessExternalDTD=true -DenableExternalEntityProcessing=true -Djavax.xml.accessExternalSchema=all"
ant -verbose


