package toyAssure.model.form;

import lombok.Getter;
import lombok.Setter;
import toyAssure.util.InvoiceType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChannelForm
{
    @NotBlank
    private String name;

    @NotNull
    private InvoiceType invoiceType;

}
