package kr.hankyungsoo.service.common;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class FileUploadService {

    @Value("${filepath.test}")
    private String filepath;
    /*
    * 파일 업로드
    * */
    public File upload(MultipartFile realFiles, String realFilesNameExtension, String serverFileName) throws IOException {

            // gradle 참조 추가 필요 commons
            String uploadFileName = serverFileName + "." + realFilesNameExtension;
            File uploadFile =  new File(filepath + uploadFileName);

            uploadFile.getParentFile().mkdirs();

            realFiles.transferTo(uploadFile);

            return uploadFile;
    }

}
