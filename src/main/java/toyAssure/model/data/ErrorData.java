package toyAssure.model.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorData {

    private Integer row;
    private String message;

    public ErrorData(Integer row, String message)
    {
        this.row=row;
        this.message=message;
    }

    @Override
    public String toString()
    {
        return "Error row " + this.row + " " +this.message + "!";
    }
}
