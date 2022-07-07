package codej.codemarket.util;

import codej.codemarket.domain.AttachDTO;
import codej.codemarket.exception.AttachFileException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtils {

    //오늘 날짜
    private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

    //업로드 경로
    private final String uploadPath = Paths.get("/Users","YOUNJY","upload2",today).toString();


    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
     * @return 랜덤 문자열
     */
    private final String getRandomString(){

        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 서버에 첨부 파일을 생성하고, 업로드 파일 목록 반환
     *
     * @return 업로드 파일 목록
     */

    public List<AttachDTO> uploadFiles(MultipartFile[] files, Long boardIdx) {
        System.out.println("===================");
        System.out.println(uploadPath);
        System.out.println("===================");

        /* 파일이 비어있으면 비어있는 리스트 반환 */
        if (files[0].getSize() < 1) {
            return Collections.emptyList();
        }
        //업로드 파일 정보를 담을 비어있는 리스트
        ArrayList<AttachDTO> attachList = new ArrayList<>();

        //uploadPath에 해당하는 디렉토리가 존재하지 않으면, 부모 디렉토리를 포함한 모든 디렉토리를 생성
        File dir = new File(uploadPath);
        if(dir.exists() == false){
            dir.mkdirs();
        }

        //파일 개수만큼 forEach 실행
        for(MultipartFile file : files){
            try{
                //파일 확장자
                final String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                //서버에 저장할 파일명(랜덤문자열+확장자)
                final String saveName = getRandomString() +"."+extension;
                //업로드 경로에 saveName 과 동일한 이름을 가진 파일 생성
                File target = new File(uploadPath, saveName);
                file.transferTo(target);

                //파일 정보 저장
                AttachDTO attach = new AttachDTO();
                attach.setBoardIdx(boardIdx);
                attach.setOriginalName(file.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(file.getSize());

                attachList.add(attach);
            }catch (IOException e){
                throw new AttachFileException("["+file.getOriginalFilename()+"] failed to save file...");
            }catch (Exception e){
                throw new AttachFileException("["+file.getOriginalFilename()+"] failed to save file...");
            }
        }
        return attachList;
    }
}
