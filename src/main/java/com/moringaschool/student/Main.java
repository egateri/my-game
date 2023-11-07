package com.moringaschool.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moringaschool.student.response.Message;
import com.moringaschool.student.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.moringaschool.student.model.User;

import java.util.List;
import java.util.UUID;

import static spark.Spark.*;

/**
 *
 * @author egateri@gmail.com
 *
 *
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final UserServiceImpl service = new UserServiceImpl();

    private static final ObjectMapper om = new ObjectMapper();


    public static void main(String[] args) {
        port(3000);

         //POST - Add a User
        post("/user/add", (request, response) -> {
            response.type("application/json");
            String requestRefId = UUID.randomUUID().toString();
            String name = request.headers("Authorization");
//            System.out.println(name);
            String userDetails= request.body();
            User newUser =om.readValue(userDetails, User.class);
            response.status(201); // 201 Created
            logger.info("requestRefId = "+requestRefId + " | statusCode =201 "+"| statusMessage = User created successfully via "+request.url() +" | Source IP = "+request.ip()+ " |");
//            return om.writeValueAsString(service.addUser(newUser));
            return om.writeValueAsString(Message.response(requestRefId,201,"created"," Success via "+request.url(),service.addUser(newUser)));
        });
        // GET - Give me user with this id
        get("/user/:id", (request, response) -> {
            response.type("application/json");
            String requestRefId = UUID.randomUUID().toString();
            User user = service.getUser(request.params(":id"));
            if (user != null) {
                response.status(200); // 200 OK
                logger.info("requestRefId = "+requestRefId + " | statusCode =200 "+"| statusMessage = User queried successfully via "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString(user);
                return om.writeValueAsString(Message.response(requestRefId,200,"success"," Success via "+request.url(),user));
            } else {
                response.status(404); // 404 Not found
                logger.info("requestRefId = "+requestRefId + " | statusCode =404 "+"| statusMessage = User Not found via "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString("user not found");
                return om.writeValueAsString(Message.response(requestRefId,404,"Not found"," Not Found via "+request.url(),"Not Found"));
            }
        });
        // GET - Get All Users
        get("/user", (request, response) -> {
            response.type("application/json");
            String requestRefId = UUID.randomUUID().toString();
            List result = service.getUsers();
            if (result.isEmpty()) {
                response.status(404); // 404 Not found
                logger.info("requestRefId = "+requestRefId + " | statusCode =404 "+"| statusMessage = Users Not Found via "+request.url() +" | Source IP = "+request.ip()+ " |");
                return om.writeValueAsString(Message.response(requestRefId,404,"Not found"," Users Not Found via "+request.url(),null));
            } else {
                response.status(200); // 200 OK
                logger.info("requestRefId = "+requestRefId + " | statusCode =200 "+"| statusMessage = Users queried Successfully "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString(result);
                return om.writeValueAsString(Message.response(requestRefId,200,"success"," Success via "+request.url(),result));
            }
        });
        // DELETE - delete user
        delete("/user/:id", (request, response) -> {
            response.type("application/json");
            String requestRefId = UUID.randomUUID().toString();
            String id = request.params(":id");
            User user = service.getUser(id);
            if (user != null) {
                response.status(200); // 200 OK
                logger.info("requestRefId = "+requestRefId + " | statusCode =200 "+"| statusMessage = User deleted successfully via "+request.url() +" | Source IP = "+request.ip()+ " |");
                service.deleteUser(id);
//                return om.writeValueAsString("user with id " + id + " is deleted!");
                return om.writeValueAsString(Message.response(requestRefId,200,"success"," User deleted via "+request.url(),"user with id " + id + " is deleted!"));
            } else {
                response.status(404);
                logger.info("requestRefId = "+requestRefId + " | statusCode =404 "+"| statusMessage = User not found for deletion via "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString("user not found");
                return om.writeValueAsString(Message.response(requestRefId,404,"not found"," Not found via "+request.url(),"User not found for deletion"));
            }
        });

        // PUT - Update user
        put("/user/:id", (request, response) -> {
            response.type("application/json");
            String requestRefId = UUID.randomUUID().toString();
            String id = request.params(":id");
            User user = service.getUser(id);
            if (user != null) {
                String userDetails= request.body();
                User editUser =om.readValue(userDetails, User.class);
//                String name = request.queryParams("name");
//                String email = request.queryParams("email");
                user.setFirstName(editUser.getFirstName());
                user.setLastName(editUser.getLastName());
                user.setEmail(editUser.getEmail());
                service.editUser(user);
                response.status(200); //200 OK
                logger.info("requestRefId = "+requestRefId + " | statusCode =200 "+"| statusMessage = User Updated successfully via "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString("user with id " + id + " is updated!");
                return om.writeValueAsString(Message.response(requestRefId,200,"Success"," Updated via "+request.url(),user));
            } else {
                response.status(404); //404 not found
                logger.info("requestRefId = "+requestRefId + " | statusCode =404 "+"| statusMessage = Not Found for Update via "+request.url() +" | Source IP = "+request.ip()+ " |");
//                return om.writeValueAsString("user not found");
                return om.writeValueAsString(Message.response(requestRefId,404,"not found"," Not found via "+request.url(),"NOt found for update"));
            }
        });


    }
}