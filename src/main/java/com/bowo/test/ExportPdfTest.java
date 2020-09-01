package com.bowo.test;

import com.alibaba.fastjson.JSON;
import com.bowo.util.HistogramChartUtil;
import com.bowo.util.PdfUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhaojufeng
 * @date 2020/8/28 11:02
 */
public class ExportPdfTest {

    /**
     * word转成pdf测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String outWordPath = null;
        try {
            String json = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"aboveMap\":{\"mbarException\":0,\"faultTimeRate\":\"0%\",\"V00874\":0,\"outWaterTotal\":0,\"V00862\":0,\"totalTime\":0,\"V00850\":0,\"faultTime\":0,\"onlineRate\":\"0%\",\"faultAmount\":0,\"offLineTotal\":0,\"onlineTimeTotal\":0,\"normalTime\":0,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":0,\"timelinessRate\":\"0%\",\"faultInfoList\":[],\"V00856\":0,\"V00844\":0,\"mbarNormalRate\":\"0%\",\"totalPower\":0,\"energy\":0.0,\"V00868\":0},\"lastMap\":{\"mbarException\":23,\"faultTimeRate\":\"8.33%\",\"V00874\":79,\"outWaterTotal\":190,\"V00862\":40,\"totalTime\":24,\"V00850\":20,\"faultTime\":2,\"onlineRate\":\"62.50%\",\"faultAmount\":1,\"offLineTotal\":9,\"onlineTimeTotal\":15,\"normalTime\":22,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":1500,\"timelinessRate\":\"100.00%\",\"faultInfoList\":[{\"V01002\":\"2019-12-31 17:00\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);停电\",\"V01011\":\"2019-12-31 19:10\",\"dataString\":\"2019-12-31\",\"terminationData\":\"2019-12-31\",\"expendTime\":130}],\"V00856\":30,\"V00844\":10,\"mbarNormalRate\":\"98.49%\",\"totalPower\":500,\"energy\":14.0,\"V00868\":50},\"thisMap\":{\"mbarException\":90,\"faultTimeRate\":\"0.48%\",\"V00874\":368,\"outWaterTotal\":12248,\"V00862\":190,\"totalTime\":144,\"V00850\":220,\"faultTime\":5,\"onlineRate\":\"68.06%\",\"faultAmount\":4,\"offLineTotal\":46,\"onlineTimeTotal\":98,\"normalTime\":1027,\"intimefaultRate\":\"100.00%\",\"intimefault\":4,\"mbarNormal\":8350,\"timelinessRate\":\"25.00%\",\"faultInfoList\":[{\"V01002\":\"2020-08-18 09:10:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-18 12:32:02\",\"dataString\":\"2020-08-18\",\"terminationData\":\"2020-08-18\",\"expendTime\":201},{\"V01002\":\"2020-08-20 10:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-20 11:32:02\",\"dataString\":\"2020-08-20\",\"terminationData\":\"2020-08-20\",\"expendTime\":82},{\"V01002\":\"2020-08-22 14:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-22 15:10:02\",\"dataString\":\"2020-08-22\",\"terminationData\":\"2020-08-22\",\"expendTime\":60},{\"V01002\":\"2020-08-19 16:13:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-19 19:40:29\",\"dataString\":\"2020-08-19\",\"terminationData\":\"2020-08-19\",\"expendTime\":206}],\"V00856\":230,\"V00844\":30,\"mbarNormalRate\":\"98.93%\",\"totalPower\":8571,\"energy\":405.5,\"V00868\":300},\"alarmReport\":{\"totalAlerts\":2171,\"powerFault\":0,\"other\":0,\"hyperpressureRate\":\"0%\",\"masterDrive\":0,\"pumpFailureFiveRate\":\"0%\",\"pumpFailureOneRate\":\"45.37%\",\"pumpFailureFourRate\":\"0%\",\"hyperpressure\":0,\"pumpFailureThree\":676,\"theSensorRate\":\"0%\",\"otherRate\":\"0%\",\"resPlcRate\":\"0%\",\"feedSensor\":0,\"pumpFailureTwoRate\":\"11.29%\",\"pumpFailureThreeRate\":\"31.14%\",\"resbq\":0,\"pumpFailureTwo\":245,\"mainPlc\":0,\"feedSensorRate\":\"0%\",\"pumpFailureFive\":0,\"resPlc\":0,\"powerFaultRate\":\"0%\",\"hydropenia\":265,\"mainPlcRate\":\"0%\",\"pumpFailureOne\":985,\"pumpFailureFour\":0,\"resbqRate\":\"0%\",\"hydropeniaRate\":\"12.21%\",\"masterDriveRate\":\"0%\",\"theSensor\":0}}}";
            String json2 = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"sbid\":\"4028805e6c1c6948016c2d330f100051\",\"bfid\":\"2c93930b6b885b5b016b8892c2110019\",\"sbmc\":\"变频二次加压设备\",\"lpmc\":\"韶山路泵站\",\"bfmc\":\"韶山路二次加压泵房\",\"xmmc\":\"韶山路加压泵站\",\"xmdz\":\"环线与韶山路交汇处\",\"sbxh\":\"BTG4-800-32-30\",\"gsqy\":\"其它1\",\"zbxh\":\"ISG200-315\",\"zbll\":\"200\",\"zbyc\":\"32\",\"zbgl\":\"30\",\"fbxh\":\"\",\"fbll\":\"\",\"fbyc\":\"\",\"fbgl\":\"\",\"gys\":\"湖南金龙给水设备有限公司\",\"gsfs\":\"变频\",\"bzjg\":\"4泵\",\"ycjklx\":\"DTU连接无线\",\"dylxr\":\"\",\"dylxrlxfs\":\"\",\"delxr\":\"\",\"delxrlxfs\":\"\",\"wylxr\":\"\",\"wylxrlxfs\":\"\",\"xmlx\":\"统建统管\",\"sblx\":\"Bom表1\",\"bz1\":\"\",\"bz2\":\"\",\"byzq\":\"180\",\"jzscfzr\":\"\",\"xcazfzr\":\"廖郁\",\"htqdrq\":\"\",\"jhrq\":\"\",\"azrq\":\"\",\"tsrq\":\"\",\"tsysrq\":\"\",\"jfsyrq\":\"\",\"dagxsj\":\"\",\"dacjsj\":\"\",\"tryxsj\":\"2019-07-26\",\"sbzt\":\"使用中\",\"kzxtlx\":\"双变频双PLC\",\"sfgzsb\":\"是\",\"dqscfzr\":\"彭冶坤\",\"sfzx\":0,\"canedit\":\"true\",\"zbsl\":4,\"fbsl\":1}}";
            Map deviceMap = JSON.parseObject(json2, Map.class);
            Map map = JSON.parseObject(json, Map.class);
            String path = PdfUtil.getClassPath();//生成的word存放的目录
            double[][] data = new double[][]{{40, 60, 70}};
            String[] rowKeys = {""};
            String[] columnKeys = {"本周期", "上周期", "上上周期"};
            String pngPath = path + UUID.randomUUID() + ".png";
            HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(data, rowKeys, columnKeys), "", "", "总出水量(m)", pngPath);
            String base64 = PdfUtil.encodeBase64File(pngPath);
            Map datas = (Map) map.get("data");
            datas.put("device", deviceMap.get("data"));
            datas.put("base64", base64);
            Map map1 = new HashMap();
            map1.put("data", datas);
            String templateName = "device_2003_new.ftl";//模板名称
            //获取到项目编译后的根目录(/D:/work/pdf-project/target/classes/)
            outWordPath = path + UUID.randomUUID() + ".doc";//生成word存放目录
            PdfUtil.createWord(templateName, outWordPath, map1);//通过freemake生成word
            File file = new File("D:\\下载\\test.pdf");
            OutputStream out = new FileOutputStream(file);
            //word文档转pdf文档
            InputStream inputStream = PdfUtil.word2ConvertPdf(outWordPath);
            int index;
            byte[] bytes = new byte[1024];
            while ((index = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, index);
                out.flush();
            }
            out.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //删除掉生成的word
            File file = new File(outWordPath);
            if (file.exists()) {
                file.deleteOnExit();
            }
        }
    }

}
