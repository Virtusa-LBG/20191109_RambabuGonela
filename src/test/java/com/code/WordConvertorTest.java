package com.code;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordConvertorTest {

	@Test
	public void testthousands() {
		assertEquals("two thousand one", WordConvertor.printNumberInWords(2001) );
	}
	
	@Test
	public void testHundreds() {
		assertEquals("two hundred eleven", WordConvertor.printNumberInWords(211) );
	}
	
	@Test
	public void testLaksh() {
		assertEquals("twenty lakh  one", WordConvertor.printNumberInWords(2000001) );
	}
	
	@Test
	public void testLakhsAndTest() {
		assertEquals("fourty lakh  twenty four", WordConvertor.printNumberInWords(4000024) );
	}
	
	@Test
	public void testCores() {
		assertEquals("four crore  twenty four", WordConvertor.printNumberInWords(40000024) );
	}
	
	@Test
	public void testValidadInput() {
		assertEquals("Please enter valid number", WordConvertor.printNumberInWords(null) );
	}
	
		
}
