package david.augusto.luan.sgc.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraNegocioException extends RuntimeException {

    private String msg;
    private String msg2;
    private int request;

    public RegraNegocioException( String msg, String msg2) {
        this.msg = msg;
        this.msg2 = msg2;
    }


    public RegraNegocioException(final String message) {
        this(message, (String) null);
    }

    public RegraNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
