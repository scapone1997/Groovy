package com.mypackage.beans

/**
 * Vediamo come usare i bean.
 */
DipendenteBeanGroovy dipendenteBean = new DipendenteBeanGroovy(nome: "simone", cognome: "capone")
dipendenteBean.setNome("andrea")
dipendenteBean.nome = "veronica"

/**
 * Quello che notiamo è che chiamare il metodo setNome automaticamente generato in Groovy
 * ed usare la notazione a riga 8 che usa l'assegnazione significa fare la stessa cosa.
 * Entrambi chiamato il metodo setNome(..). Guardandolo potrebbe sembrare che l'attributo nome
 * sia pubblico ma noi sappiamo che non è così. Infatti, andando a vedere nella cartella "out"
 * l'attributo risulta privato. L'operatore di assegnazione "=" ha l'effetto di chiamare il
 * setter dell'attributo scritto alla sinistra.
 */
println dipendenteBean

/**
 * Notiamo che nel nostro bean scritto in Groovy abbiamo descritto un metodo getter personale.
 * Dunque non stiamo più utilizzando quello scritto di default da Groovy ma bensì sembra che lo abbiamo
 * sovrascritto.
 */
println dipendenteBean.getCognome()

/**
 * Se nonostante questo getter scritto da noi vogliamo comunque avere il risultato classico
 * dobbiamo scriver come sotto. In questo modo stiamo estrapolando il vero valore dell'oggetto.
 */
println dipendenteBean.@cognome
