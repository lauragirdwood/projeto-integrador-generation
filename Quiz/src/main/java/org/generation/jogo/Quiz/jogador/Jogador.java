package org.generation.jogo.Quiz.jogador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "jogador", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id_jogador"
        }),
        @UniqueConstraint(columnNames = {
                "id_usuario"
        }),
        @UniqueConstraint(columnNames = {
                "nome"
        }),
        @UniqueConstraint(columnNames = {
                "foto_url"
        }),
        @UniqueConstraint(columnNames = {
                "pontuacao"
        }),
        @UniqueConstraint(columnNames = {
                "nivel"
        })
})

public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jogador;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Long id_usuario;

    @NotNull
    private String nome;

    @NotNull
    private String foto_url;

    @NotNull
    private Integer pontuacao;

    @NotNull
    private Integer nivel;


}
