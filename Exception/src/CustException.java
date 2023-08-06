/**
 * @description: 自定义异常
 * @author: 22783
 * @date: 2023/7/24
 **/
public class CustException extends Exception{
    private String message;

    public CustException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
