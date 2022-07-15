package codej.codemarket.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MemberUpdateDTO {

    private String text;
    private String instaUrl;
    private String twitterUrl;

    public MemberDTO toEntity(){
        return MemberDTO.builder()
                .text(this.text)
                .instaUrl(this.instaUrl)
                .twitterUrl(this.twitterUrl)
                .build();
    }
}
