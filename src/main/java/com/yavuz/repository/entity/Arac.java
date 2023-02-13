package com.yavuz.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = "Arac.existByCarName",
                query = "SELECT COUNT(a)>0 from Arac a WHERE a.ad = :ad"),
        @NamedQuery(name = "Arac.findByCarName",
                query = "SELECT a FROM Arac a WHERE a.ad = :ad")
})
public class Arac extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    @Builder.Default
    private Boolean kiralikMi = true; // sisteme eklenen her yeni araç başta kiralanabilir vaziyettedir.
}
