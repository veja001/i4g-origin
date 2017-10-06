package com.i4g.jpa.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "industries")
@Data
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;

    @Column
    private String line1;

    @Column
    private String line2;

    @Column
    private String city;

    @Column
    private String state;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private Boolean verified;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
