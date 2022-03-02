package com.example.beerservice.web.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    UUID id;

    @Version
    Long version;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdDate;

    @UpdateTimestamp
    Timestamp lastModifiedDate;
    String beerName;
    String beerStyle;
    @Column(unique = true)
    Long upc;
    BigDecimal price;

    Integer minOnHand;
    Integer quantityToBrew;

}
