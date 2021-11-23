package me.dio.heroesapi.service;

import me.dio.heroesapi.document.Heroes;
import me.dio.heroesapi.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
    private final HeroesRepository herosRepository;

    public HeroesService(HeroesRepository herosRepository){ this.herosRepository = herosRepository; }

    public Flux<Heroes> findAll(){ return Flux.fromIterable(this.herosRepository.findAll()); }

    public Mono<Heroes> findById(String id){ return Mono.justOrEmpty(this.herosRepository.findById(id)); }

    public Mono<Heroes> save (Heroes heroes){
        return Mono.justOrEmpty(this.herosRepository.save(heroes));
    }

    public Mono<Boolean> deleteByIdHero (String id){
        herosRepository.deleteById(id);
        return Mono.just(true);
    }
}
