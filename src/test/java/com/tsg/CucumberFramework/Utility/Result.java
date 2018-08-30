package com.tsg.CucumberFramework.Utility;

public class Result {
	
	private String result;
	private String resultText;
	private String path;
	
	public Result(String result,String resultText,String path) {
		this.result = result;
		this.resultText = resultText;
		this.path = path;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
