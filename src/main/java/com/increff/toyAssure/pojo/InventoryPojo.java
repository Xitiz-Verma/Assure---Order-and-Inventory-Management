package com.increff.toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_INVENTORY;

@Getter
@Setter
@Entity
public class InventoryPojo extends AbstractPojo
{

    @Id
    @TableGenerator(name = SEQ_INVENTORY, initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_INVENTORY)
    private Long id;

    @Column(nullable = false,unique = true)
    private Long globalSkuId;

    @Column(nullable = false)
    private Long availableQuantity;

    @Column(nullable = false)
    private Long allocatedQuantity;

    @Column(nullable = false)
    private Long fulfilledQuanity;

}
