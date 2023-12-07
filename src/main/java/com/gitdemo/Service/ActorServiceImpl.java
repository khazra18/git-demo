package com.gitdemo.Service;

import com.gitdemo.Entity.Actor;
import com.gitdemo.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActorList() {
        return actorRepository.findAll();
    }

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Transactional
    @Override
    public Actor updateActorDetailsById(Actor actor, long actor_id) {

        Actor actorIdNotFound = actorRepository.findById((int) actor_id).orElseThrow(() -> new RuntimeException("Actor Id not found"));

        actorIdNotFound.setFirst_name(actor.getFirst_name());
        actorIdNotFound.setLast_name(actor.getLast_name());
        actorIdNotFound.setLast_update(LocalDateTime.now());


        return actorIdNotFound;
    }

    @Override
    public boolean deleteActorDetailsById(long actorId) {

        Optional<Actor> actor = actorRepository.findById((int) actorId);
        if (actor.isPresent()) {
            actorRepository.deleteById((int) actorId);
            return true;
        }
        else{
            return false;
        }

    }
}
