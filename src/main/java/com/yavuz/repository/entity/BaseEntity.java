package com.yavuz.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@SuperBuilder
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Builder.Default
    private Long createat = System.currentTimeMillis();
    @Builder.Default
    private Long updateat = System.currentTimeMillis();
}
