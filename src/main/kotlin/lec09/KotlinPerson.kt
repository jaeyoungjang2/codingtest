package lec09

import java.lang.IllegalArgumentException

class KotlinPerson(
    val name: String,
    var age: Int
) {
    init {
        if (age < 0)
            throw IllegalArgumentException("나이는 ${this.age} 일 수 없습니다")
    }

    constructor(name: String): this(name, -1) {
        println("첫번째 부 생성자")
    }

//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    val isAdult: Boolean
        get() {
            return this.age >= 20
        }

}

fun main() {
    KotlinPerson("재영")
}