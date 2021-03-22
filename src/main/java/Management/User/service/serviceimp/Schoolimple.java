package Management.User.service.serviceimp;


import Management.User.constant.Messagecodes;
import Management.User.dto.Schooldto;
import Management.User.entity.School;
import Management.User.io.BaseResponse;
import Management.User.io.StatusMessage;
import Management.User.repository.SchoolRepository;
import Management.User.service.SchoolService;
import Management.User.util.CommonUtils;
import Management.User.util.validation.AdminUserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Schoolimple implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public BaseResponse processLogin(Schooldto request) throws Exception {
        School school= schoolRepository.findByUsername(request.getUsername());
        if (CommonUtils.checkIsNullOrEmpty(school))
            throw new IllegalArgumentException("Invalid Username");
        if(!school.getPassword().equals(request.getPassword()))
            throw new IllegalArgumentException("Invalid Password");
        Schooldto schooldto=new Schooldto();
        BeanUtils.copyProperties(school,schooldto);
        schooldto.setPassword(null);
        return BaseResponse.builder()
                .status(Messagecodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(Messagecodes.SUCCESS)
                        .description(Messagecodes.LOGIN)
                        .build())
                .data(school)
                .build();
    }

    @Override
    public BaseResponse processSignup(Schooldto request) throws Exception {
        if(schoolRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("User Name Already Exists");
        }
        if(schoolRepository.existsByEmailid(request.getEmailid())) {
            throw new IllegalArgumentException("Mail Id Already Exists");
        }
        if(schoolRepository.existsByPhonenumber(request.getPhonenumber())) {
            throw new IllegalArgumentException("Phone Number Already Exists");
        }
        if(request.getPhonenumber().length()!=10) {
            throw new IllegalArgumentException("Phone Number Must Be 10 Digits");
        }
        if(request.getPassword().length()<8 && request.getPassword().length()<16 ){
            throw new IllegalArgumentException("Length of Password Must Be Above 8 and Below 16");
        }
        AdminUserValidation.validateAdminUser(request);
        School school=new School();
        BeanUtils.copyProperties(request,school);
        schoolRepository.save(school);
        request.setPassword(null);
        return BaseResponse.builder()
                .status(Messagecodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(Messagecodes.SUCCESS)
                        .description(Messagecodes.SIGNUP)
                        .build())
                .data(school)
                .build();
    }
}
