package Management.User.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schooldto {
    private String id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String emailid;
    private String phonenumber;
   private Date createdAt;
   private Date updatedAt;

   }


