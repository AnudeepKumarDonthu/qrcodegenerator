/**
 * 
 */
package com.org.model;

/**
 * @author M1041175
 *
 */
public class InputFromUI {

	private String filename;
	private String qrdata;
	private String email;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getQrdata() {
		return qrdata;
	}

	public void setQrdata(String qrdata) {
		this.qrdata = qrdata;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "InputFromUI [filename=" + filename + ", data=" + qrdata + ", Email=" + email + "]";
	}

}
