package com.yavuz.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = "Kiralama.getCarIds",
                query = "SELECT k.aracId FROM Kiralama k"),
        @NamedQuery(name = "Kiralama.getCustomerIds",
                query = "SELECT k.kisiId FROM Kiralama k"),
        @NamedQuery(name = "Kiralama.getCarIdsByCustomerId",
                query = "SELECT k.aracId FROM Kiralama k " +
                        "WHERE k.kisiId = :kisiId")
})
public class Kiralama extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kisiId;
    private Long aracId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date kiraBaslangic;
    @Temporal(TemporalType.TIMESTAMP)
    private Date kiraBitis;
}
