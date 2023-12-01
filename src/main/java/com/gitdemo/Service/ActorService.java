package com.gitdemo.Service;

import com.gitdemo.Entity.Actor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActorService {

    List<Actor> getAllActorList();

}
