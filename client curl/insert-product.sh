#!/bin/bash

# Script per l'accesso al servizio rest 

REST_CONTEXT_ROOT=progetto2
REST_SERVICE_URL=http://localhost:5678/${REST_CONTEXT_ROOT}
PRODUCT_INFO={"prodotto":{"nome":"palla rumorosa","prezzoDiListino":3.0,"descrizione":"una pallina rumorosa","codice":"3332","dataInserimento":"2015-06-16","quantita":5,"specie":"cane","votoMedio":0}}



# inserisce un prodott (JSON) 
echo 
echo "GET ${REST_SERVICE_URL}/prodotti"

echo $(curl -H "Content-Type: application/json" -X POST -d "${PRODUCT_INFO}" "${REST_SERVICE_URL}/prodotti")
