package codej.codemarket.service;

import codej.codemarket.mappers.FollowMapper;
import codej.codemarket.mappers.MemberMapper;
import codej.codemarket.mappers.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowMapper followMapper;
    private final NoticeMapper noticeMapper;
    private final MemberMapper memberMapper;

    /**
     * 팔로우
     */
    @Transactional
    public void doFollow(Long followMember,Long followedMember){
        followMapper.
    }

}
