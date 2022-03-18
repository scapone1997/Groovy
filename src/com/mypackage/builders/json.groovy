package com.mypackage.builders

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

JsonBuilder jsonBuilder = new JsonBuilder()

jsonBuilder.books{
    currentBook{
        title 'Orgoglio e Pregiudizio'
        isbn '978-0-145'
        author(first:'Timothy', last:'Ferris', twitter:'@timothyFerris')
        related 'The 4 Hour Body', 'The 4 hour chef'
    }
    nextBook{
        title 'The Ones'
        isbn '554-0-145'
        author(first:'Linda', last:'Hope', twitter:'@hopeless')
        related 'Dreaming', 'Dinasty', 'Ciaone'
    }
}

println jsonBuilder.toPrettyString()

//Scriviamo l'oggetto dentro un file per creare un vero documento JSON
new File('json/books.json').write(jsonBuilder.toPrettyString())

/**
 * Supponiamo ora di voler fare il contrario. Cioè: il file JSON esiste già nella cartella e
 * vogliamo poterlo manipolare nel nostro programma come un oggetto qualsiasi.
 */
JsonSlurper jsonSlurper = new JsonSlurper()
def json = jsonSlurper.parse(new File('json/books.json'))

//Stampiamo gli elementi che ci interessano
println json.books.currentBook
println json.books.currentBook.title
println json.books.currentBook.author

