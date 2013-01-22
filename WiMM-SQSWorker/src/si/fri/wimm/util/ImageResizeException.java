package si.fri.wimm.util;

public class ImageResizeException extends Exception {
	private static final long serialVersionUID = 1L;

	public ImageResizeException(String message) {
        super(message);
    }

    public ImageResizeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
