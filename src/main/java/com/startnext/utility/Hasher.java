package com.startnext.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
	static private MessageDigest digest;

	public final static String getHash(String s) throws NoSuchAlgorithmException {
		digest = MessageDigest.getInstance("sha3-256");
		byte[] hashbytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
		String sha3Hex = bytesToHex(hashbytes);
		return sha3Hex;
	}

	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
