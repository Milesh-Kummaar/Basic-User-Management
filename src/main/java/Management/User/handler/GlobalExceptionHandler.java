package Management.User.handler;



import Management.User.constant.Messagecodes;
import Management.User.dto.ExceptionResponseModel;
import Management.User.io.StatusMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;


/**
 * This class used to define global and custom exceptions for server internal error,
 * custom, bad request, time out etc,.
 * @author kavin.p
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * This method used to throw server internal error at global level
     * @author kavin.p
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseModel> generalException(Exception e) throws Exception {
        log.error("Exception type Exception in generalException() in  class GlobalExceptionHandler and exception is {}", e);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(Messagecodes.INTERNAL_SERVER_ERROR);
        model.setStatusMessage(new StatusMessage(Messagecodes.INTERNAL_SERVER_ERROR_MSG, "Internal Server Error. Please try again later."));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * This method used to send bad request response error at global level
     * @author kavin.p
     * @param e
     * @return
     * @throws IOException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseModel> badRequest(MethodArgumentNotValidException e) throws IOException {
        log.error("Exception type MethodArgumentNotValidException in badRequest() in  class GlobalExceptionHandler and exception is {}", e);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(Messagecodes.BAD_REQUEST);
        model.setStatusMessage(new StatusMessage(Messagecodes.BAD_REQUEST_MSG, e.getMessage()));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
    }


    /**
     * This method used to send bad request response error at global level
     * @author kavin.p
     * @param e
     * @return
     * @throws UsernameNotFoundException
     */
   @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionResponseModel> usernameNotFoundException(MethodArgumentNotValidException e) throws IOException {
        log.error("Exception type MethodArgumentNotValidException in badRequest() in  class GlobalExceptionHandler and exception is {}", e);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(Messagecodes.BAD_REQUEST);
        model.setStatusMessage(new StatusMessage(Messagecodes.BAD_REQUEST_MSG, e.getMessage()));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
    }


    /**
     * This method used to send bad request response error at global level
     * @author kavin.p
     * @param e
     * @return
     * @throws IOException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseModel> handleIllegalArgumentException(IllegalArgumentException e) throws IOException {
        log.error("Exception type IllegalArgumentException in handleIllegalArgumentException() in  class GlobalExceptionHandler and exception is {}", e);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(Messagecodes.BAD_REQUEST);
        model.setStatusMessage(new StatusMessage(Messagecodes.BAD_REQUEST_MSG, e.getMessage()));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.BAD_REQUEST);
    }


    /**
     * This method used to send gateway time out error. The time out is defined in application.properties file.
     * @author kavin.p
     * @param ce
     * @return
     * @throws IOException
     */
    @ExceptionHandler({ConnectTimeoutException.class})
    public ResponseEntity<ExceptionResponseModel> invalidResponse(ConnectTimeoutException ce) throws IOException {
        log.error("Exception type ConnectTimeoutException ||WebServiceIOException in invalidResponse() in  class GlobalExceptionHandler and exception is {}", ce);
        ExceptionResponseModel model = new ExceptionResponseModel();
        model.setStatus(Messagecodes.GATEWAY_TIMEOUT);
        model.setStatusMessage(new StatusMessage(Messagecodes.GATEWAY_TIMEOUT_MSG, Messagecodes.GATEWAY_TIMEOUT_DESC));
        return new ResponseEntity<ExceptionResponseModel>(model, HttpStatus.GATEWAY_TIMEOUT);
    }


}
