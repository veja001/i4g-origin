package com.i4g.jpa.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country implements Serializable {
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

    @Column
    private String name;

    @Column(name = "iso_prefix")
    private String isoPrefix;

    @Column
    private String code;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Currency> currencies;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
