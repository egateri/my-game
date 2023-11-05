package com.moringaschool.student;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.moringaschool.student.model.User;
import com.moringaschool.student.response.StandardResponse;
import com.moringaschool.student.response.StatusResponse;
import com.moringaschool.student.service.UserService;

import static spark.Spark.*;
public class Main {
    UserService userService;
    public static void main(String[] args) {
        final UserService userService = null;
        get("/hello", (req, res)->"Hello, world");

        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });

        post("/users", (request, response) -> {
            response.type("application/json");
//            User user = new Gson().fromJson(request.body(), User.class);
//
//            userService.addUser(user);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        get("/users", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.ERROR,"I'm learning",new JsonObject()));
        });
    }
}