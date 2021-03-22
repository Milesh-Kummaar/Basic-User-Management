package Management.User.util.validation;


import Management.User.dto.Schooldto;
import Management.User.util.CommonUtils;

public class AdminUserValidation {

    public static void validateAdminUser(Schooldto request) {

        if (CommonUtils.checkIsNullOrEmpty(request.getUsername()))
            throw new IllegalArgumentException("UserName is Mandatory");

        if (CommonUtils.checkIsNullOrEmpty(request.getPassword()))
            throw new IllegalArgumentException("Password is Mandatory");
    }
    }
