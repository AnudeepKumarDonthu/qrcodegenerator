package com.org.model;

public class FinalResponse {
	
	private String fileName;
	private boolean status;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FinalResponse [fileName=" + fileName + ", status=" + status + "]";
	}

}
