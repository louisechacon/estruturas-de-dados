package sequencia;

public class InvalidPositionException extends RuntimeException {
	public InvalidPositionException(String erro) {
		super(erro);
	}
}