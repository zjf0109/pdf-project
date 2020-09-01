import com.alibaba.fastjson.JSON;
import com.bowo.util.PdfUtil;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhaojufeng
 * @date 2020/8/27 15:15
 */
public class PdfExportTest {

    @Test
    public void test() {
        String json = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"aboveMap\":{\"mbarException\":0,\"faultTimeRate\":\"0%\",\"V00874\":0,\"outWaterTotal\":0,\"V00862\":0,\"totalTime\":0,\"V00850\":0,\"faultTime\":0,\"onlineRate\":\"0%\",\"faultAmount\":0,\"offLineTotal\":0,\"onlineTimeTotal\":0,\"normalTime\":0,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":0,\"timelinessRate\":\"0%\",\"faultInfoList\":[],\"V00856\":0,\"V00844\":0,\"mbarNormalRate\":\"0%\",\"totalPower\":0,\"energy\":0.0,\"V00868\":0},\"lastMap\":{\"mbarException\":23,\"faultTimeRate\":\"8.33%\",\"V00874\":79,\"outWaterTotal\":190,\"V00862\":40,\"totalTime\":24,\"V00850\":20,\"faultTime\":2,\"onlineRate\":\"62.50%\",\"faultAmount\":1,\"offLineTotal\":9,\"onlineTimeTotal\":15,\"normalTime\":22,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":1500,\"timelinessRate\":\"100.00%\",\"faultInfoList\":[{\"V01002\":\"2019-12-31 17:00\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);停电\",\"V01011\":\"2019-12-31 19:10\",\"dataString\":\"2019-12-31\",\"terminationData\":\"2019-12-31\",\"expendTime\":130}],\"V00856\":30,\"V00844\":10,\"mbarNormalRate\":\"98.49%\",\"totalPower\":500,\"energy\":14.0,\"V00868\":50},\"thisMap\":{\"mbarException\":90,\"faultTimeRate\":\"0.48%\",\"V00874\":368,\"outWaterTotal\":12248,\"V00862\":190,\"totalTime\":144,\"V00850\":220,\"faultTime\":5,\"onlineRate\":\"68.06%\",\"faultAmount\":4,\"offLineTotal\":46,\"onlineTimeTotal\":98,\"normalTime\":1027,\"intimefaultRate\":\"100.00%\",\"intimefault\":4,\"mbarNormal\":8350,\"timelinessRate\":\"25.00%\",\"faultInfoList\":[{\"V01002\":\"2020-08-18 09:10:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-18 12:32:02\",\"dataString\":\"2020-08-18\",\"terminationData\":\"2020-08-18\",\"expendTime\":201},{\"V01002\":\"2020-08-20 10:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-20 11:32:02\",\"dataString\":\"2020-08-20\",\"terminationData\":\"2020-08-20\",\"expendTime\":82},{\"V01002\":\"2020-08-22 14:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-22 15:10:02\",\"dataString\":\"2020-08-22\",\"terminationData\":\"2020-08-22\",\"expendTime\":60},{\"V01002\":\"2020-08-19 16:13:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-19 19:40:29\",\"dataString\":\"2020-08-19\",\"terminationData\":\"2020-08-19\",\"expendTime\":206}],\"V00856\":230,\"V00844\":30,\"mbarNormalRate\":\"98.93%\",\"totalPower\":8571,\"energy\":405.5,\"V00868\":300},\"alarmReport\":{\"totalAlerts\":2171,\"powerFault\":0,\"other\":0,\"hyperpressureRate\":\"0%\",\"masterDrive\":0,\"pumpFailureFiveRate\":\"0%\",\"pumpFailureOneRate\":\"45.37%\",\"pumpFailureFourRate\":\"0%\",\"hyperpressure\":0,\"pumpFailureThree\":676,\"theSensorRate\":\"0%\",\"otherRate\":\"0%\",\"resPlcRate\":\"0%\",\"feedSensor\":0,\"pumpFailureTwoRate\":\"11.29%\",\"pumpFailureThreeRate\":\"31.14%\",\"resbq\":0,\"pumpFailureTwo\":245,\"mainPlc\":0,\"feedSensorRate\":\"0%\",\"pumpFailureFive\":0,\"resPlc\":0,\"powerFaultRate\":\"0%\",\"hydropenia\":265,\"mainPlcRate\":\"0%\",\"pumpFailureOne\":985,\"pumpFailureFour\":0,\"resbqRate\":\"0%\",\"hydropeniaRate\":\"12.21%\",\"masterDriveRate\":\"0%\",\"theSensor\":0}}}";
        Map map = JSON.parseObject(json, Map.class);
    }

    @Test
    public void exportLocalhost() {
        String outWordPath = null;
        try {
            String json = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"aboveMap\":{\"mbarException\":0,\"faultTimeRate\":\"0%\",\"V00874\":0,\"outWaterTotal\":0,\"V00862\":0,\"totalTime\":0,\"V00850\":0,\"faultTime\":0,\"onlineRate\":\"0%\",\"faultAmount\":0,\"offLineTotal\":0,\"onlineTimeTotal\":0,\"normalTime\":0,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":0,\"timelinessRate\":\"0%\",\"faultInfoList\":[],\"V00856\":0,\"V00844\":0,\"mbarNormalRate\":\"0%\",\"totalPower\":0,\"energy\":0.0,\"V00868\":0},\"lastMap\":{\"mbarException\":23,\"faultTimeRate\":\"8.33%\",\"V00874\":79,\"outWaterTotal\":190,\"V00862\":40,\"totalTime\":24,\"V00850\":20,\"faultTime\":2,\"onlineRate\":\"62.50%\",\"faultAmount\":1,\"offLineTotal\":9,\"onlineTimeTotal\":15,\"normalTime\":22,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":1500,\"timelinessRate\":\"100.00%\",\"faultInfoList\":[{\"V01002\":\"2019-12-31 17:00\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);停电\",\"V01011\":\"2019-12-31 19:10\",\"dataString\":\"2019-12-31\",\"terminationData\":\"2019-12-31\",\"expendTime\":130}],\"V00856\":30,\"V00844\":10,\"mbarNormalRate\":\"98.49%\",\"totalPower\":500,\"energy\":14.0,\"V00868\":50},\"thisMap\":{\"mbarException\":90,\"faultTimeRate\":\"0.48%\",\"V00874\":368,\"outWaterTotal\":12248,\"V00862\":190,\"totalTime\":144,\"V00850\":220,\"faultTime\":5,\"onlineRate\":\"68.06%\",\"faultAmount\":4,\"offLineTotal\":46,\"onlineTimeTotal\":98,\"normalTime\":1027,\"intimefaultRate\":\"100.00%\",\"intimefault\":4,\"mbarNormal\":8350,\"timelinessRate\":\"25.00%\",\"faultInfoList\":[{\"V01002\":\"2020-08-18 09:10:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-18 12:32:02\",\"dataString\":\"2020-08-18\",\"terminationData\":\"2020-08-18\",\"expendTime\":201},{\"V01002\":\"2020-08-20 10:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-20 11:32:02\",\"dataString\":\"2020-08-20\",\"terminationData\":\"2020-08-20\",\"expendTime\":82},{\"V01002\":\"2020-08-22 14:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-22 15:10:02\",\"dataString\":\"2020-08-22\",\"terminationData\":\"2020-08-22\",\"expendTime\":60},{\"V01002\":\"2020-08-19 16:13:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-19 19:40:29\",\"dataString\":\"2020-08-19\",\"terminationData\":\"2020-08-19\",\"expendTime\":206}],\"V00856\":230,\"V00844\":30,\"mbarNormalRate\":\"98.93%\",\"totalPower\":8571,\"energy\":405.5,\"V00868\":300},\"alarmReport\":{\"totalAlerts\":2171,\"powerFault\":0,\"other\":0,\"hyperpressureRate\":\"0%\",\"masterDrive\":0,\"pumpFailureFiveRate\":\"0%\",\"pumpFailureOneRate\":\"45.37%\",\"pumpFailureFourRate\":\"0%\",\"hyperpressure\":0,\"pumpFailureThree\":676,\"theSensorRate\":\"0%\",\"otherRate\":\"0%\",\"resPlcRate\":\"0%\",\"feedSensor\":0,\"pumpFailureTwoRate\":\"11.29%\",\"pumpFailureThreeRate\":\"31.14%\",\"resbq\":0,\"pumpFailureTwo\":245,\"mainPlc\":0,\"feedSensorRate\":\"0%\",\"pumpFailureFive\":0,\"resPlc\":0,\"powerFaultRate\":\"0%\",\"hydropenia\":265,\"mainPlcRate\":\"0%\",\"pumpFailureOne\":985,\"pumpFailureFour\":0,\"resbqRate\":\"0%\",\"hydropeniaRate\":\"12.21%\",\"masterDriveRate\":\"0%\",\"theSensor\":0}}}";
            Map map = JSON.parseObject(json, Map.class);
            Map data = new HashMap();
            data.put("data", data.get("data"));
            String templatePaht = "templates/";//模板文件存放的目录
            String templateName = "device_2003_new.ftl";//模板名称
            //获取到项目编译后的根目录(/D:/work/pdf-project/target/classes/)
            String path = PdfUtil.getClassPath();//生成的word存放的目录
            outWordPath = path + UUID.randomUUID() + ".doc";//生成word存放目录
            PdfUtil.createWord(templateName, outWordPath, data);//通过freemake生成word
            //word文档转pdf文档
            PdfUtil.word2ConvertPdf(outWordPath);
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

    @Test
    public  void te2st(){
        String path = PdfUtil.getClassPath();
    }
}
