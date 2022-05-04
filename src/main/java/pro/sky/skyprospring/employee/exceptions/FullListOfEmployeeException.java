package pro.sky.skyprospring.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FullListOfEmployeeException extends RuntimeException {
    public FullListOfEmployeeException(){

    }
}
