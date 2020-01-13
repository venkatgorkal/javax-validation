package com.example.ValidationDemo.exception;
import java.util.Date;
import java.util.List;

public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;
  private String errorCode;
  List<String> messages;

  public ExceptionResponse(Date timestamp, String message, String details,String errorCode,List<String> messages) {
    super();
    this.timestamp = timestamp;
    this.message = message;
    this.details = details;
    this.messages = messages;
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
	return errorCode;
}

public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

public Date getTimestamp() {
    return timestamp;
  }

  public List<String> getMessages() {
	return messages;
}

public void setMessages(List<String> messages) {
	this.messages = messages;
}

public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }

}