package lec10.kotlin

fun main() {
    Derived(300)
}

open class Base(
    // 상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 OPEN을 피해야 한다.

    open val number: Int = 100
) {
    init {
        println("Base Class")
        // NUMBER 값이 0이 나오는 이유를 생각해보면 이해가 갈것이다.
        // 상위 클래스 생성자가 실행되는 동안
        // 하위 클래스를 인스턴스화 시킨다는 것은
        // Derived 에 있는 number에 값을 집어 넣어준다는 것인데
        // 이때 상위 클래스에서 넘버를 호출하면 하위 클래스의 넘버를 가져옴
        // 아직 상위 클래스의 컨스트럭터가 실행되는 경우라서 , 하위 클래스의 넘버가 초기화되지 않음
        // 그상태에서 하위 클래스의 number에 접근하니까 기초 값인 0이 나오게 됩니다
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
    }
}