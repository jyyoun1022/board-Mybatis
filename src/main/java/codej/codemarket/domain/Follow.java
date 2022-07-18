package codej.codemarket.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Follow {


    private Long id;

    private Long fromMemberId;//팔로우 하는 멤버

    private Long toMemberId;//팔로우 받는 멤버


}
