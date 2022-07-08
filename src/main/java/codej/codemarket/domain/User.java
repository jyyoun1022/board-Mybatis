package codej.codemarket.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private String active;
    private String role;




}
