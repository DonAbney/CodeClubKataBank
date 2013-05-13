import groovy.util.GroovyTestCase;

class KataBankTest extends GroovyTestCase {

	def kataBank
	
	def validRawAccountNumber = ["    _  _     _  _  _  _  _ ", 
							  	 "  | _| _||_||_ |_   ||_||_|",
								 "  ||_  _|  | _||_|  ||_| _|",
								 "                           "]
	
	def invalidRawAccountNumber_wrongLines = validRawAccountNumber[0..2]
	
	def invalidRawAccountNumber_shortLine = [validRawAccountNumber[0],
		validRawAccountNumber[1][0..25],
		validRawAccountNumber[2],
		validRawAccountNumber[3]]
		

	void setUp() {
		kataBank = new KataBank()	
	}
	
	void testReadAccountNumberReadsARawAccountNumber() {
		assertEquals('got the expected array of strings', validRawAccountNumber, kataBank.readAccountNumber("validOneAccountTestInput.txt"));
	}
	
	void testValidateSingleAccountFromFile()
	{
		assertTrue(kataBank.isValidAccountNumber(validRawAccountNumber))
	}
	
	void testWrongNumberOfLinesFromFile()
	{
		assertFalse(kataBank.isValidAccountNumber(invalidRawAccountNumber_wrongLines))
	}
	
	void testShortLine()
	{
		assertFalse(kataBank.isValidAccountNumber(invalidRawAccountNumber_shortLine))
	}
}

class KataBank {
	
	def readAccountNumber(filename) {
		new File("resources/${filename}").readLines()
	}
	
	def isValidAccountNumber(Collection accountNumber) {
		if (accountNumber.size() != 4)
			false
		else if (accountNumber.findAll() {it.size() != 27}.size() != 0)
			false
		else
			true
	}	
}
