package com.example.friendbook

object FriendGenerator {

    var listOfFriends = mutableListOf<Friend>()

    val listOfNames = listOf("Adam", "Katrin", "Dmitriy", "Anatoliy")
    val listOfPhones = listOf("+7(927)835-12-32", "+7(999)545-89-22", "+7(900)122-01-10", "+7(906)385-53-53")

    fun generateFriends(numberOfFriends: Int) {
        val list = mutableListOf<Friend>()
        for (i in 1..numberOfFriends) {
            list.add(Friend(i.toLong(),listOfNames.random(), listOfPhones.random()))
        }
        listOfFriends = list
    }

}