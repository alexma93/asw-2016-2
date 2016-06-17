#!/bin/bash

# Script per l'accesso al servizio rest 

REST_CONTEXT_ROOT=progetto2
REST_SERVICE_URL=http://localhost:5678/${REST_CONTEXT_ROOT}


# accede a tutti i prodotti del catalogo(JSON) 
echo 
echo "GET ${REST_SERVICE_URL}/prodotti"
echo $(curl -s -H "Accept:application/json" --get "${REST_SERVICE_URL}/prodotti") 
