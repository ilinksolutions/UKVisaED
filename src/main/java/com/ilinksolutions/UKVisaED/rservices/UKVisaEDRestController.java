package com.ilinksolutions.UKVisaED.rservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilinksolutions.UKVisaED.bservices.UKVisaEDService;
import com.ilinksolutions.UKVisaED.domains.UKVisaMessage;
import com.ilinksolutions.UKVisaED.exceptions.ErrorCode;
import com.ilinksolutions.UKVisaED.exceptions.USCISException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "UK Visa ED Rest Test API", tags = { "UK Visa Encrypt/Decrypt Endpoints" })
public class UKVisaEDRestController {
	
	private static final String COULD_NOT_DECRYPT_MESSAGE = "Could not decrypt message!";
	private static final String COULD_NOT_ENCRYPT_MESSAGE = "Could not encrypt message!";

	Logger logger = LoggerFactory.getLogger(UKVisaEDRestController.class);

	@ApiOperation(value = "Returns decrypted message on success.")
	@ApiResponses(
			value={
					@ApiResponse(code = 200, message = "Successfully decrypted the message."),
			}
	)
	@PostMapping("/decryptmsg")
	public ResponseEntity<String> decryptMessage(@PathVariable String encryptedMessage)
	{
		logger.info("UKVisaEDRestController: decryptMessage: Begin!");
		
//		logger.info("UKVisaEDRestController: decryptMessage: Path Variable: " + message.toString());
		String decryptResponse = null;
		try {
//			String messageString = "{\"id\": " + message.getId() + "," + "\"firstName\": \"" + message.getFirstName()
//			+ "\"," + "\"lastName\": \"" + message.getLastName() + "\"," + "\"contactNo\": \""
//			+ message.getContactNo() + "\"," + "\"email\": \"" + message.getEmail() + "\"}";
//			// attempt to decrypt the message
//			String decryptedMessage = UKVisaEDService.decryptMessage(messageString);
			
			String decryptedMessage = UKVisaEDService.decryptMessage(encryptedMessage);
			
			// set response as the decrypted message
			decryptResponse = decryptedMessage;		
		} catch (Exception e) {
			throw new USCISException(COULD_NOT_DECRYPT_MESSAGE, ErrorCode.DECRYPT_ERROR_CODE);
		}
		// return response
		return ResponseEntity.ok(decryptResponse);
	}
	

	@ApiOperation(value = "Returns encrypted message on success.")
	@ApiResponses(
			value={
					@ApiResponse(code = 200, message = "Successfully encrypted the message."),
			}
	)
	@PostMapping("/encryptmsg")
	public ResponseEntity<String> encryptMessage(@RequestBody UKVisaMessage message)
	{
		logger.info("UKVisaEDRestController: encryptMessage: Begin!");
		logger.info("UKVisaEDRestController: encryptMessage: Path Variable: " + message.toString());
		String encryptResponse = null;
		try {
			String messageString = "{\"id\": " + message.getId() + "," + "\"firstName\": \"" + message.getFirstName()
			+ "\"," + "\"lastName\": \"" + message.getLastName() + "\"," + "\"contactNo\": \""
			+ message.getContactNo() + "\"," + "\"email\": \"" + message.getEmail() + "\"}";
			// attempt to encrypt the message
			String encryptedMessage = UKVisaEDService.encryptMessage(messageString);
			// set response as the encrypted message
			encryptResponse = encryptedMessage;		
		} catch (Exception e) {
			throw new USCISException(COULD_NOT_ENCRYPT_MESSAGE, ErrorCode.ENCRYPT_ERROR_CODE);
		}
		return ResponseEntity.ok(encryptResponse);
	}
	
	
}