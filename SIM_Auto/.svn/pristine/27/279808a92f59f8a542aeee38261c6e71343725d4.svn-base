package com.lavante.sim.Common.Util;

/**
 * Copyright (c) 2012 Lavante, Inc. All Rights Reserved
 */


import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * http://www.exampledepot.com/egs/javax.crypto/passkey.html
 * 
 * @author karthikeyan
 *
 */
public class DESEncryptionUtil {
	
	private static Cipher ecipher;
	private static Cipher dcipher;
	
	static {
		init();
	}

	private static void init() {
		try {
			// 8-byte Salt
			byte[] salt = {(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
					(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03, };
			// Iteration count
			int iterationCount = 10;
			// Create the key
			KeySpec keySpec = new PBEKeySpec( getPassPhrase().toCharArray(), salt, iterationCount );
			SecretKey key = SecretKeyFactory.getInstance( "PBEWithMD5AndDES" ).generateSecret( keySpec );
			ecipher = Cipher.getInstance( key.getAlgorithm() );
			dcipher = Cipher.getInstance( key.getAlgorithm() );
			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec( salt, iterationCount );
			// Create the ciphers
			ecipher.init( Cipher.ENCRYPT_MODE, key, paramSpec );
			dcipher.init( Cipher.DECRYPT_MODE, key, paramSpec );
		} catch( Exception e ) {
			
		}
	}
	
	public static final String ENCRYPT_SQL_FUNCTION = "dbo.lcfn_Encrypt";
	private static final byte[] PASS_PHRASE = {0x54, 0x72, 0x69, 0x70, 0x54,
			0x68, 0x65, 0x4c, 0x69, 0x67, 0x68, 0x74, 0x46, 0x61, 0x6e, 0x64,
			0x61, 0x6e, 0x67, 0x6f,};
	private static final int PASS_PHRASE_LENGTH = PASS_PHRASE.length;

	public static String getPassPhrase() {
		StringBuilder sb = new StringBuilder(PASS_PHRASE_LENGTH);
		for (int index = 0; index < PASS_PHRASE_LENGTH; ++index) {
			sb.append((char) PASS_PHRASE[index]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPassPhrase());
	}

	public static String encrypt(String str) {
		try {
			
			init();
			
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.trim().getBytes("UTF8");

			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);

			// Encode bytes to base64 to get a string
			@SuppressWarnings("restriction")
			String encryptedString = new sun.misc.BASE64Encoder().encodeBuffer(enc);
			
			//Since it is BASE64Encoder, it adds a new line character 
			//in the encrypted string when the length of string crosses 
			//64 characters (salt + key), hence we need to replace it
			encryptedString = encryptedString.replace( "\r\n", "");
			encryptedString = encryptedString.replace( "\n", "");
			encryptedString = encryptedString.replace( "\r", "");
			encryptedString = encryptedString.replace( " ", "" );
			encryptedString = encryptedString.replace( "\t", "" );
			
			return encryptedString;
		} catch (Exception e) {
		}
		return null;
	}

	public static String decrypt(String str) {
		try {
			
			init();
			
			// Decode base64 to get bytes
			@SuppressWarnings("restriction")
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str.trim());
			// Decrypt
			byte[] utf8 = dcipher.doFinal(dec, 0, dec.length );
			// Decode using utf-8
			return new String(utf8, "UTF8");
		} catch (Exception e) {
		}
		return null;
	}
	
}