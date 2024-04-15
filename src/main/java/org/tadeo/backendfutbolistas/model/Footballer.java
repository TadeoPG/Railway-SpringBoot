package org.tadeo.backendfutbolistas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idFootballer;

    @Column(nullable = false, length = 50)
    private String names;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, length = 50)
    private String characteristics;

    @ManyToOne
    @JoinColumn(name = "id_position", nullable = false, foreignKey = @ForeignKey(name = "FK_Footballer_Position"))
    private Position position;

}
