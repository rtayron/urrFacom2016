package exception;

public class DaoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1487343102457398672L;
	
	
	String msg;
	public DaoException(String message) {
		this.msg = message;
	}
	public DaoException(){
	}
	@Override
	public String getMessage() {
		return this.msg;
	}

}
