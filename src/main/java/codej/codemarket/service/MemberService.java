package codej.codemarket.service;

import codej.codemarket.domain.MemberDTO;
import codej.codemarket.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberMapper memberMapper;

    /**
     * 회원 정보 수정
     */
    public MemberDTO memberUpdate(MemberDTO memberDTO){

        MemberDTO member = memberMapper.findById(memberDTO.getId());
        member.setText("안녕하세요");
        member.setInstaUrl("왜안바뀜");
        member.setTwitterUrl("얘는 왜 ?");
        memberMapper.updateMember(member);

        return member;
    }
}
