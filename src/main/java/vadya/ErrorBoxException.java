package vadya;

public class ErrorBoxException extends RuntimeException {
    public ErrorBoxException(String message) {
        super(message);
    }
}