import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitTaskTest {

	JunitTask ju;
	@BeforeEach
	public void b() {
		ju=new JunitTask();
	}
	
	@Test
	void nchar() {
		JunitTask ju=new JunitTask();
		assertEquals("BCD",ju.checkForA("ABCD"));
		assertEquals("BBAA",ju.checkForA("BBAA"));
		assertEquals("BB",ju.checkForA("AABB"));
		assertEquals("BCD",ju.checkForA("BACD"));
	}
	@Test
	void lessthan2char() {
		JunitTask ju=new JunitTask();
		assertEquals("",ju.checkForA(""));
		assertEquals("",ju.checkForA("A"));
		assertEquals("B",ju.checkForA("B"));
		assertEquals("B",ju.checkForA("AB"));
		assertEquals("",ju.checkForA("AA"));
		assertEquals("BB",ju.checkForA("BB"));
	}

}
