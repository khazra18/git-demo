package com.gitdemo.Service;

import com.gitdemo.Entity.Actor;

import java.util.List;


public interface ActorService {

    List<Actor> getAllActorList();

    Actor createActor(Actor actor);

    Actor updateActorDetailsById(Actor actor, long actor_id);

    boolean deleteActorDetailsById(long actorId);
}
