package pl.sdacademy.projektplus.quiz.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HealthCheckDto {
    private boolean status;
    private String message;

}
