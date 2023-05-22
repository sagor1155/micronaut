package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HomeController {

    @Get(value = "/", produces = MediaType.TEXT_HTML)
    public String getHome() {
        return "<div><h1 align=\"center\">This is your Home</h1></div>";
    }
}
