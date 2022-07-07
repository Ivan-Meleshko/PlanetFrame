package com.skillfactory.planetframe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.skillfactory.planetframe.MyFrame;

class MyFrameTest {

	@Test
	void testHasNumbers() {
		String str = "Sample text 123";
		assertEquals(MyFrame.hasNumbers(str), true);
	}

	@Test
	void testHasNumbersTextOnly() {
		String str2 = "Sample text";
		assertEquals(MyFrame.hasNumbers(str2), false);
	}
	
	@Test
	void testProcess() {
		String str = "Sample text 123";
		assertEquals(MyFrame.process(str), 123);
		
	}

}
