package communityWardrobe.tiacloud.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int errorCode;
	
	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super();
		this.message = message;
	}

	public ApplicationException( int errorCode, String message) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}	
