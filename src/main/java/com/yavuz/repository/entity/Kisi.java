package com.yavuz.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Kisi extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String telefon;
    private String email;
}
