package com.i4g.jpa.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "trans_logs")
@Data
@NoArgsConstructor
public class TransLog implements Serializable {
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

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "message_seq_no")
    private String messageSeqNo;

    @Column(name = "name_values_xml")
    private String nameValuesXML;

    @Column(name = "request_operation")
    private String requestOperation;

    @Column(name = "unique_id")
    private String uniqueId;

    @Column
    private String username;

    @OneToMany(mappedBy = "translog", fetch = FetchType.LAZY)
    private List transLogControllerData;

    @OneToMany(mappedBy = "translog", fetch = FetchType.LAZY)
    private List transLogServiceData;

}
