Il progetto permette l'esecuzione di un'applicazione con interfaccia rest su un ambiente distribuito tramite l'utilizzo di vagrant e docker.
L'ambiente prevede una macchina virtuale sulla quale è installato docker e sono presenti due contenitori :
- nel primo contenitore è presente un database utilizzato dall'applicazione
- nel secondo contenitore è presente un application server su cui far girare l'applicazione

Le tecnologie utilizzate sono le seguenti:
- il framework JPA per la gestione della persistenza, nel caso specifico gestisce entità come Prodotti, Fornitori, Ordini ecc...
- il DBMS Postgres presente nel primo contenitore
- l'application server TomEE che implementa le specifiche JSP installato nel secondo contenitore
- Vagrant per la creazione dell'ambiente su cui è installato Docker.

Il comando "vagrant up" prepara tutto l'ambiente in modo automatico, ossia:
- crea la macchina virtuale con sopra docker
- crea le immagini dei due contenitori
- esegue due contenitori e li collega tra loro

Per il primo contenitore è necessario semplicemente installare postgres. Per il secondo oltre ad installare TomEE, vanno aggiunti in opportune cartelle:
- il file .war del progetto
- i driver di jdbc
- il file tomee.xml

Sono presenti dei client curl di prova, per testare il funzionamento dell'applicazione.
L'applicazione originaria, utilizzata nel primo progetto, presentava un intero sistema di e-commerce. Qui, poichè non è presente l'interfaccia web, sono presenti solo alcune funzionalità di base.


Partecipanti:
- Alessio Daniele Marra
- Daniele Petrillo
- Anton Shanya
