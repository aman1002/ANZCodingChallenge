package com.anz.codechallenge.validator;

import com.anz.codechallenge.exceptions.ValidationException;

public class AccountValidator {
	
	public static void validateAccountNumber(String accountNumber) throws ValidationException {
		if (!isValidAccountNumber(accountNumber))
			throw new ValidationException("AccountValidator.INVALID_ACCOUNT_NUMBER");
	}

	private static boolean isValidAccountNumber(String accountNumber) {
		if (accountNumber.matches("[0-9]+") && accountNumber.length() == 9)
			return true;
		return false;
	}

}
