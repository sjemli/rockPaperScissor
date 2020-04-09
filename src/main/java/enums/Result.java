package enums;

public enum Result {
    WIN(""), LOSS(""), TIE("");

    private final String message;


    Result(String message) {
        this.message = message;
    }

}
