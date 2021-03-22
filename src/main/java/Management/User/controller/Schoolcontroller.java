package Management.User.controller;


import Management.User.constant.NameSpaceConstant;
import Management.User.dto.Schooldto;
import Management.User.io.BaseResponse;
import Management.User.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Schoolcontroller {

    @Autowired
    SchoolService schoolService;

//   @Autowired
//   EmailService emailService;


    @PostMapping(value = NameSpaceConstant.LOGIN)
    public ResponseEntity<BaseResponse> processLogin(@RequestBody Schooldto req) throws Exception {
        BaseResponse response = schoolService.processLogin(req);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = NameSpaceConstant.SIGNUP)
    public ResponseEntity<BaseResponse> processSignup(@RequestBody Schooldto req) throws Exception {
        BaseResponse response = schoolService.processSignup(req);
       return ResponseEntity.ok(response);
    }

//
//    @PostMapping(value = NameSpaceConstant.FORGET)
//    public ResponseEntity<BaseResponse> sendEmail(@RequestBody Schooldto request) throws Exception {
//        Map<String, Object> model = new HashMap<>();
//        BaseResponse response= emailService.sendEmail(request, model);
//        return ResponseEntity.ok(response);
//
//    }

}
