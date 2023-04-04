package kr.hankyungsoo.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class FileDownloadService {
    @Value("${filepath.test}")
    private String filepath;

    //파일 다운로드
    public File download(HttpServletResponse response , String data) throws IOException {

        //파일 구하기
        File file = new File(filepath + data);
        System.out.println("file.getPath() = " + file.getPath());

        //응답 해더 설정
        response.setContentType("application/download; utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");

        final OutputStream out = response.getOutputStream();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
        }
        out.flush();

        return file;
    }
}
