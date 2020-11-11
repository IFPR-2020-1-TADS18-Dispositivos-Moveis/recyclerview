package com.stiehl.recyclerview.models

data class Person(
    var firstName: String,
    var lastName: String,
    var title: String,
    var enabled: Boolean = true
) {
    companion object {
        fun getAll(): List<Person> {
            return listOf(
                Person("Diego", "Stiehl", "Sr."),
                Person("Diego", "Maradona", "Senior", false),
                Person("Donald", "Trump", "Mr."),
                Person("Pato", "Donald", "Duck", false),
                Person("Teresa", "Calcutá", "Madre", false),
            )
        }
    }
}