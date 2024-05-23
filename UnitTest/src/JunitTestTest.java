import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;


class JunitTestTest {
	private JunitTest.Calculator calculator;
	
	
	@BeforeEach
	void setUp() {
		calculator = new JunitTest.Calculator();
		System.out.println("새 Junit 인스턴스 생");
	}

	
	@Test
	void testAdd() {
		System.out.println("덧셈 테스트 시작");
		assertEquals(5, calculator.add(2, 3), "2+3 should equals 5");
		System.out.println("덧셈 테스트 통과: 2+3 = " +  calculator.add(2, 3));
	}
	
	
	@Test
	void testSubtract() {
		System.out.println("뺄셈 테스트 시작");
		assertEquals(1, calculator.subtract(4, 3), "4-3 should equals 1");
		System.out.println("뺄셈 테스트 통과: 4-3 = " +  calculator.subtract(4, 3));
	}
	
	@Test
	void testMultiply() {
		System.out.println("곱셈 테스트 시작");
		assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equals 6");
		System.out.println("곱셈 테스트 통과: 2*3 = " +  calculator.multiply(2, 3));
	}
	
	@Test
	void testDivide() {
		System.out.println("나눗셈 테스트 시작");
		assertEquals(2, calculator.add(6, 3), "6 / 3 should equals 2");
		System.out.println("나눗셈 테스트 통과: 6 / 3 = " +  calculator.add(6, 3));
	}
	
	@Test
	void testDivideByZero() {
		System.out.println("0으로 나누기 테스트 시작");
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0), "Divisor cannot be zero");
		System.out.println("0으로 나누기 예외 처리 테스트 통과");
	}

}
