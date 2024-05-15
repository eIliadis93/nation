package com.qualco.nation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Map<String, Object> errorAttributes = getErrorAttributes(request);
        String errorMessage = (String) errorAttributes.get("message");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }


    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
        return errorAttributes.getErrorAttributes(new ServletWebRequest(request), options);
    }
}
