package com.project.e_pharmacie_spring.controllers;

import com.project.e_pharmacie_spring.models.User;
import com.project.e_pharmacie_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView();
        List<User> userList = userService.listAll();
        model.addObject("users",userList );
        model.setViewName("users");
        return model;
    }
@GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user=userService.getUserById(id);
        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}
@PostMapping("/adduser")
public ResponseEntity<User> createUser(@RequestBody User user){

  try {
      userService.saveUser(user);
      return new ResponseEntity<>(user,HttpStatus.CREATED);
  }catch (Exception e ){
      return new ResponseEntity<>(null,HttpStatus
      .INTERNAL_SERVER_ERROR);
  }
  }
  @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user){
        User user1=userService.getUserById(id);
        if(user1!=null){
            User user2=user1;
            user2.setName(user1.getName());
            user2.setCommands(user1.getCommands());
            user2.setMail(user1.getMail());
            user2.setNumber(user1.getNumber());
            user2.setPassword(user1.getPassword());
            userService.saveUser(user2);
            return new ResponseEntity<>(HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
  }
  @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id){
        try {
            userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
  }
}
