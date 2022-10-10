package toyAssure.model.data;

import lombok.Getter;
import lombok.Setter;
import toyAssure.util.InvoiceType;

@Getter
@Setter
public class ChannelData
{
    private String name;
    private InvoiceType invoiceType;

}
