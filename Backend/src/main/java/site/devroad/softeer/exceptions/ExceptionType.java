package site.devroad.softeer.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

@JsonFormat
public enum ExceptionType {
    //Account Related Exceptions
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Account not found", 1001),
    ACCOUNT_ALREADY_EXISTS(HttpStatus.CONFLICT, "Account already exists", 1002),
    POST_ACCOUNT_FORM_INVALID(HttpStatus.BAD_REQUEST, "null 값이 회원가입 요청에 들어있습니다.", 1003),
    POST_ACCOUNT_EMAIL_DUPLICATED(HttpStatus.BAD_REQUEST, "중복된 email이  있습니다.", 1004),
    ACCOUNT_NOT_UPDATED(HttpStatus.BAD_REQUEST, "Account not updated", 1005),
    AUTHENTICATION_FAILED(HttpStatus.BAD_REQUEST, "Password가 잘못되었습니다.", 1006),
    POST_ACCOUNT_PHONE_DUPLICATED(HttpStatus.BAD_REQUEST, "중복된 휴대폰 번호가 있습니다.", 1007),
    ROADMAP_NOT_FOUND(HttpStatus.NOT_FOUND, "Roadmap not found", 1008),
    SUBJECT_NOT_FOUND(HttpStatus.NOT_FOUND, "Subject not found", 1009),




    //Database Related Exceptions
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Database error", 1101),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error", 1102),

    //JWT Related Exceptions
    JWT_NOT_VALID(HttpStatus.BAD_REQUEST, "JWT not valid", 1201),


    //Test Related Exceptions
    TEST_NOT_FOUND(HttpStatus.NOT_FOUND, "Test not exist", 1301),


    //Last Exceptions
    DATABASE_NOT_CONNECTED(HttpStatus.INTERNAL_SERVER_ERROR, "Database not connected", 2001);

    private HttpStatus httpStatus;
    private String message;
    private Integer customErrorCode;

    ExceptionType(HttpStatus httpStatus, String message, Integer customErrorCode) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.customErrorCode = customErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    public Integer getCustomErrorCode() {
        return customErrorCode;
    }
}