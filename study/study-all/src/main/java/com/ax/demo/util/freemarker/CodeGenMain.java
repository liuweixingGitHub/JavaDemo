package com.ax.demo.util.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.cglib.core.ClassInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author axing
 */
public class CodeGenMain {
//Configuration.VERSION_2_3_23

    private static Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);

  public static void main(String[] args) throws IOException, TemplateException {
//    if (args.length==0)return;


      File file = new File("src/main/java/com/ax/demo/util/freemarker");

      cfg.setDirectoryForTemplateLoading(file);


      Map<String,Object> map = new HashMap(10);
      map.put("className","Brand");


      Template template = cfg.getTemplate("IDAO.ftl");

      File out = new File("src/main/java/com/ax/demo/dao/IBrandDAO.java");

      template.process(map,new FileWriter(out));


  }

  private static void  genJavaFile(ClassInfo classInfo, String templateName, String filePathTempllate) throws  Exception{
//
//      Template template = cfg.getTemplate(templateName);
//
//      String filePath = MessageFormat.format(templateName,classInfo.getClass().re)


  }




}
