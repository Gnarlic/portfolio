/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.calculator.controller;

import gnarlitronic.ps.calculator.service.CalculatorService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Elnic
 */
@Controller
public class CalcController {

    @Inject
    CalculatorService svc;

    //initial page load
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "index";
    }

    //calculation controller
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String calculate(HttpServletRequest request, Model model) {
        String error = "";
        String firstNumber = request.getParameter("num1");
        if (firstNumber.isEmpty()) {
            firstNumber = "0";
            error = "Please enter a number in both boxes";
        }
        double a = Double.parseDouble(firstNumber);
        String secondNumber = request.getParameter("num2");
        if (secondNumber.isEmpty()) {
            secondNumber = "0";
            error = "Please enter a number in both boxes";
        }
        double b = Double.parseDouble(secondNumber);
        String operationType = request.getParameter("operation");
        double returnAnswer = 0;
        String displayOperationType = "";
        switch (operationType) {

            case "Add":
                returnAnswer = svc.add(a, b);
                displayOperationType = "+";
                break;
            case "Sub":
                returnAnswer = svc.subtract(a, b);
                displayOperationType = "-";
                break;
            case "Mul":
                returnAnswer = svc.multiply(a, b);
                displayOperationType = "x";
                break;
            case "Div":
                returnAnswer = svc.divide(a, b);
                displayOperationType = "%";
                break;
            default:
                returnAnswer = 0;
                break;

        }
        model.addAttribute("firstNumber", a);
        model.addAttribute("secondNumber", b);
        model.addAttribute("operationType", operationType);
        model.addAttribute("returnAnswer", returnAnswer);
        model.addAttribute("error", error);

        return "index";
    }
}
