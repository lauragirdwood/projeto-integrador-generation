package org.generation.jogo.Quiz.pergunta;

import org.generation.jogo.Quiz.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    // READ
    @GetMapping("/perguntas")
    public List<Pergunta> findAll() {
        return perguntaRepository.findAll();
    }

    // CREATE

    @PostMapping("/perguntas")
    public Pergunta save (@RequestBody Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }

    @PutMapping("/perguntas/{id_pergunta}")
    public Pergunta update (@PathVariable Long id_pergunta, @RequestBody Pergunta pergunta) throws ResourceNotFoundException {
        return perguntaRepository.findById(id_pergunta).map(p -> {
            p.setNumero(pergunta.getNumero());
            p.setDescricao(pergunta.getDescricao());
            p.setValor_pontuacao(pergunta.getValor_pontuacao());
            return perguntaRepository.save(p);
        }) .orElseThrow(() -> new ResourceNotFoundException("Não existe pergunta cadastrada com o id_pergunta" + id_pergunta));
    }

    @DeleteMapping("/perguntas/{id_pergunta}")
    public void delete (@PathVariable Long id_pergunta) {
        perguntaRepository.deleteById(id_pergunta);
    }


}
