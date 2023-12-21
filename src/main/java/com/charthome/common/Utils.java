package com.charthome.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j

public class Utils {

    public static String saveFile(MultipartFile upfile , String savePath) {

        String originName = upfile.getOriginalFilename();
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int random = (int) (Math.random() * 90000 + 10000); // 5자리 랜덤정수값
        String ext = originName.substring(originName.lastIndexOf("."));

        String changeName = currentTime+random+ext;

        try {
            upfile.transferTo(new File(savePath+changeName));
        } catch (IllegalStateException | IOException e) {
            log.error("게시글 등록 오류 = {}",e.getMessage());
        }

        return changeName;
    }
}
