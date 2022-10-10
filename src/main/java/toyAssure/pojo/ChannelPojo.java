package toyAssure.pojo;

import lombok.Getter;
import lombok.Setter;
import toyAssure.util.InvoiceType;

import javax.persistence.*;

import static toyAssure.pojo.TableConstants.SEQ_CHANNEL;
import static toyAssure.pojo.TableConstants.SEQ_INTITAL_VALUE;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class ChannelPojo extends AbstractPojo
{
    @Id
    @TableGenerator(name = SEQ_CHANNEL, initialValue = SEQ_INTITAL_VALUE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CHANNEL)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private InvoiceType invoiceType;

}
