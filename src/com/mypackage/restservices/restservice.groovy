package com.mypackage.restservices

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.apache.groovy.json.internal.LazyMap

/**
 * Per avere a che fare con i servizi REST è obbligatorio conoscere i metodi HTTP.
 * Il protocollo HTTP prevede i seguenti metodi:
 *   - GET e POST: entrambi i metodi get e post vengono utilizzati per inviare e ricevere
 *          informazioni tra client Web e server. Tuttavia, la differenza tra loro sta
 *          nella visibilità dei loro parametri URL, che appaiono chiaramente nel metodo get,
 *          ma non nel metodo post.
 *   - PUT: è il metodo che viene utilizzato per aggiornare la risorsa disponibile sul Server.
 *          Nel body della richiesta PUT viene scritto un oggetto JSON.
 *   - DELETE: è il metodo che viene utilizzato per cancellare la risorsa disponibile sul Server.
 *
 *   Nello scenario del nostro browser abbiamo che il Browser invia una richiesta GET o POST al Server
 *   e il Server risponde con una risposta contenete una pagina HTML.
 *
 *   Nello scenario dei servizi REST, abbiamo un Client (può essere un tool, un altro server) che invia
 *   una richiesta al nostro Application Server usando i metodi GET/POST/PUT/DELETE.
 *   L'Application Server invia una risposta al Client in formato JSON o XML.
 */

/**
 * Importante parlare anche degli HTTP Status Codes. Questi codice ci aiutano a capire in che stato
 * la nostra richiesta si trova. I più importanti sono:
 *   - 1xx: codici che
 *   - 2xx: i codici che iniziano con 2 sono quelli che indicano successo.
 *   - 3xx: sono i codici che mostrano il redirezionamento.
 *   - 4xx: codici di errore.
 *   - 5xx: codici di errore server.
 *
 * I codici più famosi sono questi:
 *   - 200 OK: la richiesta è stata completata con successo.
 *   - 201 Created: la richiesta è stata soddisfatta ed una nuova risorsa è stata creata.
 *   - 204 No Content: Il server ha soddisfatto la richiesta ma non ha bisogno di ritornare
 *                     un entity-body.
 *   - 301 Moved Permanently: La risorsa richiesta è stata spostata su di un nuovo URI ed ogni futura
 *                            referenza a questa risorsa dovrà usare uno degli URI ritornati.
 *   - 304 Not Modified: ...
 *   - 307 Temporary Redirect: ....
 *   - 400 Bad Request: La richiesta non può essere compresa dal Server in quanto scritta con sintassi
 *                      sbagliata.
 *   - 401 e 403: La richiesta è legale ma il server si rifiuta di rispondere. C'è bisogno di essere
 *                autenticati o altro..
 *   - 404 Not Found: La risorsa richiesta non è trovabile ma potrà essere disponibile nel futuro.
 *   - 500 Internal Server Error: Il server ha incontrato dei problemi e non può rispondere.
 *   - 502 Bad Gateway: ...
 *
 *
 */

/**
 * Per Content Neogtation intendiamo la possibilità di Client e Server in ambito REST di mettersi d'accordo
 * su cosa inviarsi. Il Client dice al Server: "ti invio un JSON e mi aspetto un JSON di risposta". Ma
 * potrebbe anche dire "ti invio un JSON e mi aspetto un XML come risposta". Vedremo che si specifica questa cosa
 * impostando la richiesta nel formato che desideriamo.
 */

URL url = new URL("https://api.carbonintensity.org.uk/intensity")
InputStream urlStream = url.openStream()
BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream))
LazyMap result = (new JsonSlurper().parse(reader))

