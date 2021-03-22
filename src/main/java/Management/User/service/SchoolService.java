package Management.User.service;




import Management.User.dto.Schooldto;
import Management.User.io.BaseResponse;
import org.springframework.stereotype.Component;


@Component
public interface SchoolService {
    public BaseResponse processLogin(Schooldto request) throws Exception;
    public BaseResponse processSignup(Schooldto request) throws Exception;



}
