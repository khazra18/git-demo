package com.gitdemo.Service;

import com.gitdemo.Entity.Actor;
import com.gitdemo.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActorList() {
        return actorRepository.findAll();
    }
}
