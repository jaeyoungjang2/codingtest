package lec10.kotlin

class KotlinPenguin(
    species: String
) : KotlinAnimal(species, 2), KotlinFlyable, KotlinSwimable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄은 움직입니다~ 꿱꿱")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    // 중복되는 인터페이스를 특정할때 super<타입>.함수 사용
    override fun act() {
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()
    }

    // java kotlin 모두 인터페이스를 인스턴스화 할 수 없습니다.

}