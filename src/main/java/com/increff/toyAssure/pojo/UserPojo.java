package com.increff.toyAssure.pojo;

import com.increff.toyAssure.util.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.increff.toyAssure.pojo.TableConstants.SEQ_INITIAL_VALUE;
import static com.increff.toyAssure.pojo.TableConstants.SEQ_USER;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class UserPojo extends AbstractPojo
{
    @Id
    @TableGenerator(name = SEQ_USER, initialValue = SEQ_INITIAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_USER)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;
}
