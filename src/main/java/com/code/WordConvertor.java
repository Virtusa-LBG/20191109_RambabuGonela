package com.code;

public class WordConvertor {

	private static final String CRORE = "crore";
	private static final String THOUSAND = "thousand";
	private static final String LAKH = "lakh";
	private static final String HUNDRED = "hundred";
	static String[] onesPlace = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static String[] tensPlace = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninty" };
	static String[] tens = { "eleven", "twelve", "thirteen", "fourteen", "fifteeen", "sixsteen", "seventeen",
			"eighteen", "ninteen" };
	static String SPACE = " ";

	public static void main(String[] args) {

		if (args == null || args.length == 0 || args.length > 1) {
			System.out.println("Please enter valid number");
		} else {

			String input = args[0];
			Integer inputValue = Integer.parseInt(input);
			System.out.println("entered number" + inputValue);
			System.out.println("British english word  :" + placeValue(inputValue));

		}

	}

	public static String printNumberInWords(Integer inputValue) {

		if (inputValue != null) {
			return placeValue(inputValue);
		} else {
			return "Please enter valid number";
		}
	}

	
	public static String placeValue(Integer inputValue) {
		int thousadPlaceValue = inputValue / 1000;
		int hundredPlaceValue = 0;
		if(inputValue > 1000 & thousadPlaceValue < 100) {
			hundredPlaceValue = 0;
		}else {
			hundredPlaceValue = thousadPlaceValue > 0 ? thousadPlaceValue % 100 : inputValue / 100;
		}
		
		int remainingTens = inputValue % 100;
		int tensPlaceValue = remainingTens / 10;
		int remainingOnce = remainingTens % 10;
		String hundredString = "";

		hundredString = getThousandValue(thousadPlaceValue, hundredString);

		hundredString = getHundredValue(hundredPlaceValue, hundredString);

		hundredString = getTensAndOnes(remainingTens, tensPlaceValue, remainingOnce, hundredString); 

		return hundredString;
	}

	private static String getTensAndOnes(int remainingTens, int tensPlaceValue, int remainingOnce,
			String hundredString) {

		if (remainingTens >= 10 && remainingTens < 20  ) {
			hundredString = hundredString + SPACE + tens[(remainingTens - 10) - 1];
		} else if (tensPlaceValue > 0) {
			{
				hundredString = hundredString + SPACE + tensPlace[tensPlaceValue - 1];
			}

			if (remainingOnce > 0) {
				hundredString = hundredString + SPACE + onesPlace[remainingOnce - 1];
			}
		} else if (remainingOnce > 0) {
			hundredString = hundredString + SPACE + onesPlace[remainingOnce - 1];
		}
		return hundredString;
	}

	private static String getHundredValue(int hundredPlaceValue, String hundredString) {
		if (hundredPlaceValue > 100) {
			hundredString = hundredString + onesPlace[hundredPlaceValue / 100 - 1] + SPACE + HUNDRED;
		} else if (hundredPlaceValue > 10) {
			hundredString = hundredString + onesPlace[hundredPlaceValue / 10 - 1] + SPACE + HUNDRED;
		} else if (hundredPlaceValue > 0) {
			hundredString = hundredString + onesPlace[hundredPlaceValue - 1] + SPACE + HUNDRED;
		}
		return hundredString;
	}

	private static String getThousandValue(int thousadPlaceValue, String hundredString) {
		if (thousadPlaceValue > 0) {
			if (thousadPlaceValue > 10000) {
				hundredString = onesPlace[thousadPlaceValue / 10000 - 1] + SPACE + CRORE + SPACE;
			} else if (thousadPlaceValue > 1000) {
				hundredString = tensPlace[thousadPlaceValue / 1000 - 1] + SPACE + LAKH + SPACE;
			} else if (thousadPlaceValue > 100) {
				hundredString = onesPlace[thousadPlaceValue / 100 - 1] + SPACE + LAKH + SPACE;
			} else if (thousadPlaceValue > 10) {
				hundredString = tensPlace[thousadPlaceValue / 10 - 1] + SPACE + THOUSAND;
			} else {
				hundredString = onesPlace[thousadPlaceValue - 1] + SPACE + THOUSAND;
			}
		}
		return hundredString;
	}

}
