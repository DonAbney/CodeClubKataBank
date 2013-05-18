package com.club.code
import spock.lang.Specification

class KataBankSpock extends Specification {
	
	def kataBank, validRawAccountNumber
	
	def setup() {
		kataBank = new KataBank()
		validRawAccountNumber = ["    _  _     _  _  _  _  _ ",
					 "  | _| _||_||_ |_   ||_||_|",
	       			     "  ||_  _|  | _||_|  ||_| _|",
							     "                           "]
	}
	
	def "read account number reads a raw account number"() {
		expect:
			kataBank.readAccountNumber("validOneAccountTestInput.txt") == validRawAccountNumber
	}

	def "validate single account number"() {
		expect:
			kataBank.isValidAccountNumber(validRawAccountNumber)
	}
	
	def "invalid single account number"() {
		setup: 
			def invalidAccountNumber = validRawAccountNumber[0..2]
		
		expect:
			kataBank.isValidAccountNumber(invalidAccountNumber) == false
	}
}
