package com.increff.toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_BIN;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "binId")})
public class BinPojo extends AbstractPojo
{
    @Id
    @TableGenerator(name = SEQ_BIN, initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_BIN)
    private Long binId;
}
