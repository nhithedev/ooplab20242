package hust.soict.hedspi.aims.exception;

//PlayerException must extend Exception (checked)
public class PlayerException extends Exception {

	private static final long serialVersionUID = 1L;

public PlayerException() {
     super();
 }

 public PlayerException(String message) {
     super(message);
 }
}
