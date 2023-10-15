package lec10.kotlin

interface KotlinSwimable {

    // kotlin 에서는 backing field가 없는 프로퍼티를 interface에 만들수 있다. ??
//    val swimAbility: Int

    fun act() {
        println("어푸 어푸")
    }
}
