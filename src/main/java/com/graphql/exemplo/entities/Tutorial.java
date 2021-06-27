package com.graphql.exemplo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name= "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false, updatable = false)
    private Autor autor;

}
