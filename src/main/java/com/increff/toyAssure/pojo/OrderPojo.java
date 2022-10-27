package com.increff.toyAssure.pojo;

import com.increff.toyAssure.util.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_CHANNEL;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "channelOrderId")})
public class OrderPojo extends AbstractPojo
{

    @Id
    @TableGenerator(name = SEQ_CHANNEL , initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CHANNEL)
    private Long id;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Long channelId;

    @Column(nullable = false)
    private String channelOrderId;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    private String invoiceUrl;

}

