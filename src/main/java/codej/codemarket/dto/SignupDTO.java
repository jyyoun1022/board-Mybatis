package codej.codemarket.dto;

import codej.codemarket.domain.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@ToString
public class SignupDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String university;


    public MemberDTO toEntity(){
        MemberDTO member = MemberDTO.builder()
                .name(this.name)
                .nickname(this.nickname)
                .password(this.password)
                .phone(this.phone)
                .university(this.university)
                .build();
        return member;
    }

}
