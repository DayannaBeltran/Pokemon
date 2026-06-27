package com.example.PokemonApi.controller;

import com.example.PokemonApi.model.Pokemon;
import com.example.PokemonApi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> obtenerTodos() {
        return pokemonService.obtenerTodos();
    }

    //localhost:8080/api/pokemones/1
    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id) {
        return pokemonService.obtenerPorId(id);
    }

    @PostMapping
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.crearPokemon(pokemon);
    }

    @PutMapping("/{id}")
    public Pokemon editarPokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonCompleto(id, pokemon);
    }

    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonParcial(id, pokemon);
    }

    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }
}
