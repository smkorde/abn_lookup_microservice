package com.sud.digibiz.util;

public class AbnAcnUtils {

	public static byte ABN_LENGTH = 11;
	public static byte ACN_LENGTH = 9;

	private static byte ABN_MOD = 89;
	private static byte ACN_MOD = 10;

	private static byte RADIX = 10;

	protected static int[] abnWeightings = { 10, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
	protected static int[] acnWeightings = { 8, 7, 6, 5, 4, 3, 2, 1 };

	public static String trimSpaces(String value){
	    if(value == null){
	        return "";
	    }
	    return value.replace(" ", "");
    }

	/**
	 * http://www.ato.gov.au/businesses/content.asp?doc=/content/13187.htm&pc=001/003/021/002/001&mnu=610&mfp=001/003&st=&cy=1
	 * 
	 * @param abn
	 * @return
	 */
	public static boolean isValidABN(final String abn) {
		String tempAbn = trimSpaces(abn);
		if (tempAbn.length() != ABN_LENGTH) {
			return false;
		}
		int total = 0;
		char[] digits = tempAbn.toCharArray();
		digits[0] = Character.forDigit(Character.digit(digits[0], RADIX) - 1,
				RADIX);
		for (int i = 0; i < ABN_LENGTH; i++) {
			total += Character.digit(digits[i], RADIX) * abnWeightings[i];
		}
		int remainder = total % ABN_MOD;
		return (remainder == 0);
	}

	/**
	 * http://www.asic.gov.au/asic/asic.nsf/byheadline/Australian+Company+Number+(ACN)+Check+Digit?opendocument
	 * 
	 * @param acn
	 * @return
	 */
	public static boolean isValidACN(final String acn) {
		String tempAcn = trimSpaces(acn);
		if (tempAcn.length() != ACN_LENGTH) {
			return false;
		}
		int total = 0;
		char[] digits = tempAcn.toCharArray();
		for (int i = 0; i < ACN_LENGTH - 1; i++) {
			total += Character.digit(digits[i], RADIX) * acnWeightings[i];
		}
		int remainder = total % ACN_MOD;
		int complement = ACN_MOD - remainder;
		if(complement == 10){
			complement = 0;
		}
		int checksum = Character.digit(digits[ACN_LENGTH - 1], RADIX);
		return (complement == checksum);
	}

}
