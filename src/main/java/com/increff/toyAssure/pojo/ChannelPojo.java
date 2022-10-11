package com.increff.toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;
import com.increff.toyAssure.util.InvoiceType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class ChannelPojo extends AbstractPojo
{
    @Id
    @TableGenerator(name = TableConstants.SEQ_CHANNEL, initialValue = TableConstants.SEQ_INTITAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TableConstants.SEQ_CHANNEL)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private InvoiceType invoiceType;

}
