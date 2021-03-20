package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    internal fun `자동차 이름들로 Cars 객체를 생성할 수 있다`() {
        val cars = Cars(listOf("가", "나", "다"))
        assertThat(cars).containsAnyOf(Car("가"), Car("나"), Car("다"))
    }

    @Test
    internal fun `가장 멀리 간 자동차가 우승자고 우승자는 한 명 이상일 수 있다`() {
        val cars = Cars(listOf("가", "나", "다"))
        cars[0].move()
        cars[1].move()
        cars[2].stop()
        assertThat(cars.winners(1))
            .containsExactly(Car("가"), Car("나"))
    }
}