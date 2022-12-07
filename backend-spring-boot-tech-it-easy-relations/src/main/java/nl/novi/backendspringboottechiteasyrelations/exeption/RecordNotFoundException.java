package nl.novi.backendspringboottechiteasyrelations.exeption;

public class RecordNotFoundException extends RuntimeException{
    private static final long serialVersionUD = 1L;

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
