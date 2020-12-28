package com.crown.generator;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import org.beetl.core.Template;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.db.TableDesc;
import org.beetl.sql.core.kit.GenKit;
import org.beetl.sql.core.kit.StringKit;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MDCodeGen;
import org.beetl.sql.ext.gen.SourceGen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName util
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-09-17
 * @Time 16:50
 * @Version 1.0
 */
public class Generator {
    /**
     * 根据表名创建POJO
     *
     * @param tableName  表名
     * @param pojoPkg    实体包名
     * @param sqlManager
     * @throws Exception
     */
    public static void createPojo(String tableName, String pojoPkg, SQLManager sqlManager) throws Exception {
        GenConfig config = new GenConfig("com/crown/generator/pojo.btl");
        String replace = GenKit.getJavaResourcePath().replace("\\src", "\\beetlsql")+"\\src\\main\\java\\";
        config.setDisplay(false);
        config.setPreferBigDecimal(true);
        sqlManager.genPojoCode(tableName, pojoPkg,replace, config);
    }

    /**
     * 根据表名创建sql模板文件
     *
     * @param tableName  表名
     * @param sqlPath    md文件路径
     * @param sqlManager
     * @throws IOException
     */
    public static void createSqlMd(String tableName, String sqlPath, SQLManager sqlManager) throws IOException {
        GenConfig config = new GenConfig("com/crown/generator/pojo.btl");
        config.setDisplay(false);
        String fileName = StringKit.toLowerCaseFirstOne(sqlManager.getNc().getClassName(tableName));
        if (config.getIgnorePrefix() != null && !config.getIgnorePrefix().trim().equals("")) {
            fileName = fileName.replaceFirst(StringKit.toLowerCaseFirstOne(config.getIgnorePrefix()), "");
            fileName = StringKit.toLowerCaseFirstOne(fileName);
        }
        String replace = GenKit.getJavaResourcePath().replace("\\src", "\\beetlsql")+"/src/main/resources/";


        String target = replace + sqlPath + "/" + fileName + ".md";

        TableDesc desc = sqlManager.getMetaDataManager().getTable(tableName);
        FileWriter writer = new FileWriter(new File(target));
        MDCodeGen mdCodeGen = new MDCodeGen();
        mdCodeGen.setMapperTemplate(new GenConfig().getTemplate("com/crown/generator/md.btl"));
        mdCodeGen.genCode(sqlManager.getBeetl(), desc, sqlManager.getNc(), null, writer);
        writer.close();
    }

    /**
     * 根据类名创建接口文件
     *
     * @param tableName  表名
     * @param sqlManager
     * @throws IOException
     */
    public static void createController(String tableName, String pojoPkg, SQLManager sqlManager) throws IOException {
        String replace = GenKit.getJavaResourcePath().replace("\\src", "\\beetlsql")+"\\src\\main\\java\\";

        String target = replace + "com/crown/generator" + tableName.replace("_", "/");
        String packageName = tableName.replace("_", ".");
        String[] classNameArr = tableName.split("_");
        String baseName = "";
        for (int i = 0; i < classNameArr.length; i++) {
            baseName = baseName + StrUtil.upperFirst(classNameArr[i]);
        }

        String fileName = StrUtil.upperFirst(baseName) + "Controller.java";
        String className = baseName + "Controller";
        String pojoName = baseName;
        Path path = Paths.get(target);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        Path filePath = Paths.get(target + File.separatorChar + fileName);
        Files.deleteIfExists(filePath);
        Files.createFile(filePath);
        FileWriter writer = new FileWriter(new File(filePath.toString()));
        Map<String, String> bindingMap = new HashMap<>();
        bindingMap.put("className", StrUtil.upperFirst(className));
        bindingMap.put("package", "org.bdse.wiki.controller." + packageName);
        bindingMap.put("pojoPkg", pojoPkg);
        bindingMap.put("pojoName", pojoName);
        bindingMap.put("sqlId", StrUtil.lowerFirst(baseName));
        String controllerPath = "";
        for (int i = 0; i < classNameArr.length; i++) {
            controllerPath = controllerPath + classNameArr[i] + "/";
        }
        controllerPath = controllerPath.substring(0, controllerPath.length() - 1);
        bindingMap.put("controllerPath", controllerPath);

        Template template = SourceGen.getGt()
                .getTemplate(new GenConfig().getTemplate("org/bdse/wiki/common/controller.btl"));
        template.binding(bindingMap);
        template.renderTo(writer);
        writer.close();
    }

    /**
     * 创建数据库链接
     *
     * @return
     */
    public static SQLManager sqlManager() {
        Props props = new Props("application-beijing.properties");
        String driver = props.get("spring.datasource.master.druid.driverClassName").toString();
        String url = props.get("spring.datasource.master.druid.url").toString();
        String userName = props.get("spring.datasource.master.druid.username").toString();
        String password = props.get("spring.datasource.master.druid.password").toString();
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        SQLLoader loader = new ClasspathLoader("/resources/sql");
        UnderlinedNameConversion nc = new UnderlinedNameConversion();
        SQLManager sqlManager = new SQLManager(mysql, loader, source, nc, new Interceptor[] { new DebugInterceptor() });
        return sqlManager;
    }

    public static void main(String[] args) {
        SQLManager sqlManager = null;
        try {
            sqlManager = sqlManager();

            //			User user = new User();
            //			user.setUserAccount("admin");
            //			user.setUserPassword(SecureUtil.md5("111111"));
            //			user.setUserName("超级管理员");
            //			user.setStatus("1");
            //			user.setExpiryDate(DateTime.of("2099-12-31 23:59:59", "yyyy-MM-dd hh:mm:ss").getTime() / 1000);
            //			user.setCreateTime(DateTime.now().getTime() / 1000);
            //			sqlManager.insert(user);
            // 创建POJO
            String tableName = "b_device_rule";
            String replace = GenKit.getJavaResourcePath().replace("\\src", "\\bdse-wiki")+"\\src\\main\\java\\";
            System.out.println(replace);
            String pojoPkg ="org.bdse.wiki.pojo";
            createPojo(tableName, pojoPkg, sqlManager);

            // 创建sql模板
            String sqlPath = "/sql";
            createSqlMd(tableName, sqlPath, sqlManager);
            //
            //			// 创建Controller
            //			createController(tableName, pojoPkg, sqlManager);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlManager != null) {
                try {
                    sqlManager.getDs().getMaster().close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        System.out.println("===============创建完毕==================");
    }
}
