package com.increff.toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_BIN_SKU;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class BinSkuPojo extends AbstractPojo
{
    @Id
    @TableGenerator(name = SEQ_BIN_SKU, initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_BIN_SKU)
    private Long id;

    @Column(nullable = false)
    private Long binId;

    @Column(nullable = false)
    private Long globalSkuId;

    @Column(nullable = false)
    private Long quantity;

}
