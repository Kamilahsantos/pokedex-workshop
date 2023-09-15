package com.kamilacode.workshop.pokedex.service;


import com.kamilacode.workshop.pokedex.exception.PokemonDuplicadoException;
import com.kamilacode.workshop.pokedex.exception.PokemonNaoEncontradoException;
import com.kamilacode.workshop.pokedex.model.Pokemon;
import com.kamilacode.workshop.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;


    public Pokemon criarPokemon(Pokemon pokemonModel) throws PokemonDuplicadoException {
        try {
            return pokemonRepository.save(pokemonModel);

        } catch (Exception e) {
            throw new PokemonDuplicadoException("Pokemon com mesmo nome já cadastrado");
        }
    }


    public List<Pokemon> listarPokemons() {
        return pokemonRepository.findAll();
    }


    public Optional<Pokemon> buscarPokemonPeloId(Long id) throws PokemonNaoEncontradoException {

        if (pokemonRepository.findById(id).isEmpty()) {
            throw new PokemonNaoEncontradoException(id);
        }
        return pokemonRepository.findById(id);
    }


    public ResponseEntity<Pokemon> atualizarPokemonPeloId(Pokemon pokemon, Long id) {
        return pokemonRepository.findById(id).map(pokemonToUpdate -> {
            pokemonToUpdate.setNome(pokemon.getNome());
            pokemonToUpdate.setId(id);
            pokemonToUpdate.setEvolucoes(pokemon.getEvolucoes());
            pokemonToUpdate.setTipo(pokemon.getTipo());
            Pokemon updated = pokemonRepository.save(pokemonToUpdate);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> excluirPokemonPeloId(Long id) {
        return pokemonRepository.findById(id).map(pokemonModelToDelete -> {
            pokemonRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
