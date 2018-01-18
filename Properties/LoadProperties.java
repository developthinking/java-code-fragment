package test.propertiesTest;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Properties;
import java.util.Set;


public class LoadProperties {
    /**
     * 读Properties文件
     * @param filePath 文件路径
     * @param encoding 文件编码
     * @return
     */
    public static Properties getProperties(String filePath, String encoding) {
    	if (StringUtils.isNotBlank(filePath)) {
    		return null;
    	}
        InputStream inputStream = null;
        try {
            //inputStream = new FileInputStream(fileName);
            inputStream = LoadProperties.class.getClassLoader().getResourceAsStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(inputStream, encoding));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 读Properties文件（有序）
     * @param filePath 文件路径
     * @param encoding 文件编码
     */
    public static Properties getOrderedProperties(String filePath, String encoding) {
        Properties properties = new OrderedProperties();
        InputStreamReader inputStreamReader = null;
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            //prop.load(in);//直接这么写，如果properties文件中有汉子，则汉字会乱码。因为未设置编码格式。
            inputStreamReader = new InputStreamReader(inputStream, encoding);
            properties.load(inputStreamReader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    /**
     * 读取配置文件key对应的value
     * @param filePath 文件路径
     * @param encoding 文件编码
     * @param propertyKey 配置文件key
     */
    public static String getInfoByKey(String filePath, String encoding, String propertyKey) {
    	//配置信息读取
    	Properties properties = getProperties(filePath, encoding);
    	//配置关键字读取
        return properties.getProperty(propertyKey);
    }

    /**
     * 读取配置文件的key集合
     * @param filePath 文件路径
     * @param encoding 文件编码
     */
    public static Set<Object> getKeys(String filePath, String encoding) {
        //配置信息读取
        Properties properties = getProperties(filePath, encoding);
        //关键字列表
        return properties.keySet();
    }

    /**
     * 更新Properties
     * @param properties properties对象
     * @param hintInfo properties注释提示
     * @param filePath 文件路径
     * @param flag 是否追加写 true表示追加打开,false每次都是清空再重写
     * @param encoding 文件编码
     */
    public static void updateProperties(Properties properties, String hintInfo, String filePath, boolean flag, String encoding) {
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(filePath, flag);//true表示追加打开,false每次都是清空再重写
            OutputStreamWriter writer = new OutputStreamWriter(oFile, encoding);
            properties.store(writer, hintInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
