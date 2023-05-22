package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/person")
public class PersonController {

    @Post(value = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> createPerson(final Person person) {
        person.setAge(22);
        System.out.println("Person created: " + person.toString());
        return HttpResponse.created(person);
    }
}
