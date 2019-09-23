package com.ilinksolutions.UKVisaED.exceptions;

public enum ErrorCode
{
	GENERAL_ERROR_CODE (1000),
	DATABASE_ERROR_CODE (2000),
	EMAIL_ERROR_CODE (3000),
	SECURITY_ERROR_CODE (4000),
	BAD_REQUEST_ERROR_CODE (50000),
	ENTITY_NOT_FOUND_ERROR_CODE(60000),
	UNPROCESSABLE_ENTITY_ERROR_CODE(70000),
	DECRYPT_ERROR_CODE (80000),
	ENCRYPT_ERROR_CODE (90000);
	
    private final int errorCode;

    ErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }
    
    public int getLevelCode()
    {
        return this.errorCode;
    }
}
