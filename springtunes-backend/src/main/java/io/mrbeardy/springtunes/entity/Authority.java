package io.mrbeardy.springtunes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

}
