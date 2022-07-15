package codej.codemarket.mappers;

import codej.codemarket.domain.CommentDTO;
import codej.codemarket.domain.MemberDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    private final Logger  log = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("멤버 임의 삽입")
    void insertMember(){
        String u20 = UUID.randomUUID().toString();
        for(int i=60; i<80; i++){
            String uuid = UUID.randomUUID().toString();
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setName("member_"+i);
            memberDTO.setNickname("nick"+i+"name");
            memberDTO.setEmail("member"+i+"@naver.com");
            memberDTO.setText(uuid);
            memberDTO.setInstaUrl(uuid);
            memberDTO.setTwitterUrl(uuid);
            memberDTO.setPassword("1111");
            memberDTO.setPhone("010-0"+i+"0-2901");
            memberDTO.setUniversity("서강대");

            memberMapper.insert(memberDTO);
            log.info("Member : "+i+"개가 등록되었습니다.");
        }

    }

    @Test
    @DisplayName("findByNickname")
    void testFindByNickname(){
        MemberDTO memberDTO = memberMapper.findByNickname("nick19name");

        try{
            String jsonMember = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(memberDTO);
            log.info("jsonMember={}",memberDTO);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    @DisplayName("findByEmail")
    void testFindByEmail(){
        MemberDTO memberDTO = memberMapper.findByEmail("member19@naver.com");

        try{
            String jsonMember = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(memberDTO);
            log.info("jsonMember={}",jsonMember);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }






}
