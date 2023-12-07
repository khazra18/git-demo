package com.gitdemo.Controller;

import com.gitdemo.Entity.Actor;
import com.gitdemo.Service.ActorService;
import com.gitdemo.Service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("actor/v1")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/getAllActorList")
    public List<Actor> getActorList(){
        return actorService.getAllActorList();
    }

    @PostMapping("/createActor")
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
        return new ResponseEntity<>(actorService.createActor(actor), HttpStatus.CREATED);
    }

    @PutMapping("/updateActorDetails/{actor_id}")
    public ResponseEntity<Actor> updateActorDetailsById(@RequestBody Actor actor,@PathVariable long actor_id){
        return new ResponseEntity<>(actorService.updateActorDetailsById(actor,actor_id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteActorDetailsById/{actor_id}")
    public ResponseEntity<String> deleteActorDetailsById(@PathVariable long actor_id){

        boolean isDeleted = actorService.deleteActorDetailsById(actor_id);
        if (isDeleted)
            return new ResponseEntity<>("Actor details for Id :" + actor_id + " deleted successfully",HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Actor details for Id :" + actor_id + " Not found",HttpStatus.NOT_FOUND);
    }

}
