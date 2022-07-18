package codej.codemarket.mappers;

import codej.codemarket.domain.Follow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {

//insert into follow ( follow_member,followed_member)
    // values(#{followMember},#{followedMember})
//delete from follows where follow_member=#{followMember} and followed_member=#{followed_member}

    void following(Follow follow);

    void unfollowing(Follow follow);


}
