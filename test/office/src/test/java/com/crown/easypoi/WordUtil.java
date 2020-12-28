package com.crown.easypoi;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WordUtil
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-10-30
 * @Time 13:33
 * @Version 1.0
 */
public class WordUtil {

    /**
     * 导出word（2007版本docx）
     *
     * @param templateWordPath
     * @param dataMap
     * @return
     * @throws Exception
     */
    public static byte[] exportWord(String templateWordPath, Map<String, Object> dataMap) throws Exception {
        File tf = new File(templateWordPath);
        if (!tf.exists() || !tf.isFile()) {
            throw new RuntimeException("File [" + templateWordPath + "] Not Found Or Not File.");
        }
        XWPFDocument document = WordExportUtil.exportWord07(templateWordPath, dataMap);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        document.write(bos);
        return bos.toByteArray();
    }

    public static void main(String[] args) {
        try {
            try (FileOutputStream fos = new FileOutputStream("attach/exp.docx")) {
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("title", "个人信息");
                Map<String, String> user = new HashMap<>();
                user.put("name", "张三");
                user.put("age", "22");
                user.put("address", "重庆渝北区");
                user.put("other", "篮球");
                dataMap.put("user", user);

                List<Map<String, String>> jobs = new ArrayList<>();
                Map<String, String> job;
                for (int i = 0; i < 5; i++) {
                    job = new HashMap<>();
                    job.put("name", "公司名称-" + i);
                    job.put("address", "公司地址:" + i);
                    jobs.add(job);
                }

                dataMap.put("jobs",jobs);

                ArrayList<User> users = new ArrayList<>();
                dataMap.put("users",users);
                byte[] doc = exportWord("attach/template.docx", dataMap);

                fos.write(doc);

                fos.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}