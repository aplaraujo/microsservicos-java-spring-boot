package io.github.aplaraujo.controllers;

import io.github.aplaraujo.exceptions.UnsupportedMathOperationException;
import static io.github.aplaraujo.request.converters.NumberConverter.*;
import io.github.aplaraujo.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    private final SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/10/5
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/10/5
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/multiplication/10/5
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/division/10/5
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/mean/10/5
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/squareRoot/81
    @RequestMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.squareRoot(convertToDouble(number));
    }

}
