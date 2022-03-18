package com.mypackage.intro

class Account {
    BigDecimal balance

    Account plus(Account other){
        new Account(balance: this.balance + other.balance)
    }

    String toString(){
        "Account balance: $balance"
    }
}
