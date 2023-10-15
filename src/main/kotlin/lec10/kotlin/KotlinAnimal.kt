package lec10.kotlin

abstract class KotlinAnimal(
    val species: String,
    open val legCount: Int
) {
    abstract fun move();
}