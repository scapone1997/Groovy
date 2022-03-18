package com.mypackage.builders

import groovy.xml.MarkupBuilder

/**
 * Valgono le stesse considerazioni fatte per il builder per xml.
 * Vediamo però una ulteriose ineteressante cosa. Possiamo iterare una lista
 * di corsi al fien di costruire una tabella html contenente i corsi.
 * Inoltre, creiamo il file html nella cartella apposita
 */

List courses = [
        [id:1 , name: 'Apache Groovy'],
        [id:2, name: 'Spring Boot']
]

FileWriter writer = new FileWriter('html/about.html')
MarkupBuilder markupBuilder = new MarkupBuilder(writer)

markupBuilder.html{
    head{
        title 'About Dan Vega'
        description 'This is an about me page'
        keywords 'Dan Vegna, Groovy, Java'
    }

    body{
        h1 'About me'
        p 'this is a bunch of text about me..'
        section {
            h2 'Coursed'
            table{
                tr{
                    th 'id'
                    th 'name'
                }
                //ieriamo la lista e costruiamo il documento html
                courses.each {
                    course->
                        tr{
                            td course.id
                            td course.name
                        }
                }

            }
        }
    }
}

