package com.bowo.util;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Map;

/**
 * @author zhaojufeng
 * @date 2020/8/27 11:11
 */
public class PdfUtil {

    private static Configuration configuration = null;

    private final static String TEMPLATESPATH = "/templates/";//模板路径

    /**
     * 初始化配置并设置默认编码UTF-8
     */
    static {
        configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDefaultEncoding("UTF-8");
    }

    /**
     * @Description: 验证aspose.word组件是否授权：无授权的文件有水印标记
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes());
            //InputStream inputStream = Xml2Word2Pdf.class.getClassLoader().getResourceAsStream("\\license.xml");
            com.aspose.words.License license = new com.aspose.words.License();
            license.setLicense(inputStream);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过模板文件创建word文档
     *
     * @param tpmplateFileName 模板名称
     * @param outFilePath      文件输出的路径
     * @param dataMap          生成word所需要显示的数据
     */
    public static void createWord(String tpmplateFileName, String outFilePath, Map<String, Object> dataMap) {
        try {
            configuration.setClassForTemplateLoading(PdfUtil.class, TEMPLATESPATH);
            Template template = configuration.getTemplate(tpmplateFileName);//获取文档XML模板
            //设置输出文件位置和文件名
            File outFile = new File(outFilePath);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 本方法用于将word转换pdf(返回输入流，用于浏览器下载文件)
     *
     * @param sourceFile word所在的目录
     * @return
     * @throws Exception
     */
    public static InputStream word2ConvertPdf(String sourceFile) throws Exception {
        InputStream in = null;
        FileOutputStream os = null;
        // 验证License 若不验证则转化出的pdf文档会有水印产生
        if (!getLicense()) {
            throw new Exception("生成PDF文档,验证License失败!");
        }
        try {
            File file = File.createTempFile("tempPdf", ".pdf");  //新建一个空白pdf文档
            file.deleteOnExit();
            os = new FileOutputStream(file);
            Document doc = new Document(sourceFile);//通过sourceFile创建word文档对象
            doc.save(os, SaveFormat.PDF);//word转换成pdf
            in = new FileInputStream(file);
            return in;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("生成PDF文档失败!");
        } finally {
            //转换完成后删除掉word
//            File file = new File(sourceFile);
//            if (file.exists()) {
//                file.delete();
//            }
            os.close();
        }
    }

    /**
     * 获取到编译后的类路径
     */
    public static String getClassPath() {
        String classPath = PdfUtil.class.getResource("/").getPath().substring(1) + TEMPLATESPATH;
        return classPath;
    }

    /**
     * 把文件转换成base64字符串
     * @param path 文件路径
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }
}
