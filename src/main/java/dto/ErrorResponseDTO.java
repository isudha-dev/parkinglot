package dto;

public class ErrorResponseDTO {

    private String message;
    private int errorCode;

    public ErrorResponseDTO(final String message, final int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(final String message) {
        this.message = message;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
    }
}
