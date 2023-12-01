package com.gitdemo.Controller;

import com.gitdemo.Entity.Actor;
import com.gitdemo.Service.ActorService;
import com.gitdemo.Service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actor/v1")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/getAllActorList")
    public List<Actor> getActorList(){
        return actorService.getAllActorList();
    }

}
