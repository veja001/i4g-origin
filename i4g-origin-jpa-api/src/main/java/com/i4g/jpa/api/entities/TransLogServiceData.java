package com.i4g.jpa.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "trans_log_service_data")
@Data
@NoArgsConstructor
public class TransLogServiceData implements Serializable {
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

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "message_timestamp")
    private String messageTimestamp;

    @Column(name = "record_after_change")
    private String recordAfterChange;

    @Column(name = "record_before_change")
    private String recordBeforeChange;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "record_table_name")
    private String recordTableName;

    @Column(name = "record_username")
    private String recordUsername;

    @Column(name = "status_id")
    private Integer statusId;

    @ManyToOne
    @JoinColumn(name = "trans_log_id")
    private TransLog transLog;

}
