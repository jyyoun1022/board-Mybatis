package codej.codemarket.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDTO {

    private Long id;

    private String name;

    private String nickname;

    private String email;
    @Builder.Default
    private String text="";
    @Builder.Default
    private String instaUrl="";
    @Builder.Default
    private String twitterUrl="";


    private String password;

    private String phone;

    private String university;


}
