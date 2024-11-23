package com.example.building.ControllerAdvice;


import com.example.building.customException.FieldRequiredException;
import com.example.building.model.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        System.out.println("ArithmeticException handler triggered!");
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setError("Lỗi số học xảy ra: " + ex.getMessage());

        List<String> details = new ArrayList<>();
        details.add("Số nguyên không thể chia cho 0.");
        errorResponseDTO.setDetail(details);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {
        System.out.println("Exception handler for FieldRequiredException triggered!");
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setError("Lỗi: " + ex.getMessage());

        List<String> details = new ArrayList<>();
        details.add("name or numberofbasement is null!");
        errorResponseDTO.setDetail(details);

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
    }
}
