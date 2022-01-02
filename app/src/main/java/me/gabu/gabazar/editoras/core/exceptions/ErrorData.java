package me.gabu.gabazar.editoras.core.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorData {
    private String erro;
    private String path;
    private int code;
    private HttpStatus status;
}
