package exception;

public class EmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyException() {
        super("A pilha está vazia");
    }
}
