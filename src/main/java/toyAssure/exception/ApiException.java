package toyAssure.exception;

import lombok.Getter;
import toyAssure.model.data.ErrorData;

import java.util.List;

@Getter
public class ApiException extends Exception {

    private static final long serialVersionUID = 1L;
    private List<ErrorData> errorFormList;
    private Integer errorType=0;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(List<ErrorData> errorFormList)
    {
        this.errorFormList=errorFormList;
        this.errorType=1;
    }
}
