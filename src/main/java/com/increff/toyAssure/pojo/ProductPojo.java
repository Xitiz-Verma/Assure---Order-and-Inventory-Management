package com.increff.toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_PRODUCT;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"globalSkuId","clientSkuId"})})
public class ProductPojo
{
    @Id
    @TableGenerator(name = SEQ_PRODUCT , initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PRODUCT)
    private Long globalSkuId;

    @Column(nullable = false)
    private String clientSkuId;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brandId;

    @Column(nullable = false)
    private Double mrp;

    @Column(nullable = false)
    private String description;
}
