import java.io.IOException;

public class Exception {
    class EmptyStringException extends RuntimeException{
        public EmptyStringException(String message) {
            super(message);
        }
}
class ArrayCountElementException extends RuntimeException{
    public ArrayCountElementException(String message) {
        super(message);
    }
}
class CheckDateFormat extends RuntimeException{
    public CheckDateFormat(String message) {
        super(message);
}
}

}

