package com.metehanbolat.roomdbguide.multipletable.data

import com.metehanbolat.roomdbguide.multipletable.model.Director
import com.metehanbolat.roomdbguide.multipletable.model.School
import com.metehanbolat.roomdbguide.multipletable.model.Student
import com.metehanbolat.roomdbguide.multipletable.model.Subject
import com.metehanbolat.roomdbguide.multipletable.relations.StudentSubjectCrossRef

val directors = listOf(
    Director("Mike Litoris", "Jake Wharton School"),
    Director("Jack Goff", "Kotlin School"),
    Director("Chris P. Chicken", "JetBrains School")
)
val schools = listOf(
    School("Jake Wharton School"),
    School("Kotlin School"),
    School("JetBrains School")
)
val subjects = listOf(
    Subject("Dating for programmers"),
    Subject("Avoiding depression"),
    Subject("Bug Fix Meditation"),
    Subject("Logcat for Newbies"),
    Subject("How to use Google")
)
val students = listOf(
    Student("Beff Jezos", 2, "Kotlin School"),
    Student("Mark Suckerberg", 5, "Jake Wharton School"),
    Student("Gill Bates", 8, "Kotlin School"),
    Student("Donny Jepp", 1, "Kotlin School"),
    Student("Hom Tanks", 2, "JetBrains School")
)
val studentSubjectRelations = listOf(
    StudentSubjectCrossRef("Beff Jezos", "Dating for programmers"),
    StudentSubjectCrossRef("Beff Jezos", "Avoiding depression"),
    StudentSubjectCrossRef("Beff Jezos", "Bug Fix Meditation"),
    StudentSubjectCrossRef("Beff Jezos", "Logcat for Newbies"),
    StudentSubjectCrossRef("Mark Suckerberg", "Dating for programmers"),
    StudentSubjectCrossRef("Gill Bates", "How to use Google"),
    StudentSubjectCrossRef("Donny Jepp", "Logcat for Newbies"),
    StudentSubjectCrossRef("Hom Tanks", "Avoiding depression"),
    StudentSubjectCrossRef("Hom Tanks", "Dating for programmers")
)