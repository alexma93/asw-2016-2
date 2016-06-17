#!/bin/bash

# Script (di prova) per l'accesso al servizio rest

REST_CONTEXT_ROOT=progetto2
REST_SERVICE=hello 

# URL del servizio  
REST_SERVICE_URL=http://localhost:5678/${REST_CONTEXT_ROOT}/${REST_SERVICE}

echo 
echo "GET ${REST_SERVICE_URL}/info/"
echo $(curl -s -X GET "${REST_SERVICE_URL}/info/") 

