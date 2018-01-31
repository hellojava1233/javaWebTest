package org.web.chapter1.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @description: This is ....
 * Created By yupeng
 * 9:43   2018/1/31
 * version: 0.0.l
 */
public class DatabaseHelper {




    /**
     * 执行 SQL 文件
     */
    public static void executeSqlFile(String filePath) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String sql;
            while ((sql = reader.readLine()) != null) {
               // executeUpdate(sql);
                System.out.println(sql);
            }
        } catch (Exception e) {
           e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取sql文件 并测试显示
     * @param a
     */
     public static void main(String[] a){
      //   DatabaseHelper.executeSqlFile("sql/customer_init.sql");

         /**
          * 读取配置文件并打印
          */
         Properties conf = PropsUtil.loadProps("config.properties");
         String driver = conf.getProperty("jdbc.driver");
         String url = conf.getProperty("jdbc.url");
         String username = conf.getProperty("jdbc.username");
         String password = conf.getProperty("jdbc.password");
         System.out.println(conf.toString());
         System.out.println(url);
     }

}
