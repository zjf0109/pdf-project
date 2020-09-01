package com.bowo.controller;

import com.alibaba.fastjson.JSON;
import com.bowo.pojo.Serie;
import com.bowo.util.ChartUtils;
import com.bowo.util.HistogramChartUtil;
import com.bowo.util.PdfUtil;
import com.bowo.util.PieChartUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.*;

/**
 * @author zhaojufeng
 * @date 2020/8/27 14:10
 */
@RestController
public class MainController {

    /**
     * 导出pdf
     */
    @GetMapping(value = "exprotPdf")
    public void exprotPdf(HttpServletResponse response) throws Exception {
        String json2 = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"sbid\":\"4028805e6c1c6948016c2d330f100051\",\"bfid\":\"2c93930b6b885b5b016b8892c2110019\",\"sbmc\":\"变频二次加压设备\",\"lpmc\":\"韶山路泵站\",\"bfmc\":\"韶山路二次加压泵房\",\"xmmc\":\"韶山路加压泵站\",\"xmdz\":\"环线与韶山路交汇处\",\"sbxh\":\"BTG4-800-32-30\",\"gsqy\":\"其它1\",\"zbxh\":\"ISG200-315\",\"zbll\":\"200\",\"zbyc\":\"32\",\"zbgl\":\"30\",\"fbxh\":\"\",\"fbll\":\"\",\"fbyc\":\"\",\"fbgl\":\"\",\"gys\":\"湖南金龙给水设备有限公司\",\"gsfs\":\"变频\",\"bzjg\":\"4泵\",\"ycjklx\":\"DTU连接无线\",\"dylxr\":\"\",\"dylxrlxfs\":\"\",\"delxr\":\"\",\"delxrlxfs\":\"\",\"wylxr\":\"\",\"wylxrlxfs\":\"\",\"xmlx\":\"统建统管\",\"sblx\":\"Bom表1\",\"bz1\":\"\",\"bz2\":\"\",\"byzq\":\"180\",\"jzscfzr\":\"\",\"xcazfzr\":\"廖郁\",\"htqdrq\":\"\",\"jhrq\":\"\",\"azrq\":\"\",\"tsrq\":\"\",\"tsysrq\":\"\",\"jfsyrq\":\"\",\"dagxsj\":\"\",\"dacjsj\":\"\",\"tryxsj\":\"2019-07-26\",\"sbzt\":\"使用中\",\"kzxtlx\":\"双变频双PLC\",\"sfgzsb\":\"是\",\"dqscfzr\":\"彭冶坤\",\"sfzx\":0,\"canedit\":\"true\",\"zbsl\":4,\"fbsl\":1}}";
        String json = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"aboveMap\":{\"mbarException\":0,\"faultTimeRate\":\"0%\",\"V00874\":0,\"outWaterTotal\":0,\"V00862\":0,\"totalTime\":0,\"V00850\":0,\"faultTime\":0,\"onlineRate\":\"0%\",\"faultAmount\":0,\"offLineTotal\":0,\"onlineTimeTotal\":0,\"normalTime\":0,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":0,\"timelinessRate\":\"0%\",\"faultInfoList\":[],\"V00856\":0,\"V00844\":0,\"mbarNormalRate\":\"0%\",\"totalPower\":0,\"energy\":0.0,\"V00868\":0},\"lastMap\":{\"mbarException\":23,\"faultTimeRate\":\"8.33%\",\"V00874\":79,\"outWaterTotal\":190,\"V00862\":40,\"totalTime\":24,\"V00850\":20,\"faultTime\":2,\"onlineRate\":\"62.50%\",\"faultAmount\":1,\"offLineTotal\":9,\"onlineTimeTotal\":15,\"normalTime\":22,\"intimefaultRate\":\"0%\",\"intimefault\":0,\"mbarNormal\":1500,\"timelinessRate\":\"100.00%\",\"faultInfoList\":[{\"V01002\":\"2019-12-31 17:00\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);停电\",\"V01011\":\"2019-12-31 19:10\",\"dataString\":\"2019-12-31\",\"terminationData\":\"2019-12-31\",\"expendTime\":130}],\"V00856\":30,\"V00844\":10,\"mbarNormalRate\":\"98.49%\",\"totalPower\":500,\"energy\":14.0,\"V00868\":50},\"thisMap\":{\"mbarException\":90,\"faultTimeRate\":\"0.48%\",\"V00874\":368,\"outWaterTotal\":12248,\"V00862\":190,\"totalTime\":144,\"V00850\":220,\"faultTime\":5,\"onlineRate\":\"68.06%\",\"faultAmount\":4,\"offLineTotal\":46,\"onlineTimeTotal\":98,\"normalTime\":1027,\"intimefaultRate\":\"100.00%\",\"intimefault\":4,\"mbarNormal\":8350,\"timelinessRate\":\"25.00%\",\"faultInfoList\":[{\"V01002\":\"2020-08-18 09:10:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-18 12:32:02\",\"dataString\":\"2020-08-18\",\"terminationData\":\"2020-08-18\",\"expendTime\":201},{\"V01002\":\"2020-08-20 10:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-20 11:32:02\",\"dataString\":\"2020-08-20\",\"terminationData\":\"2020-08-20\",\"expendTime\":82},{\"V01002\":\"2020-08-22 14:10\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-22 15:10:02\",\"dataString\":\"2020-08-22\",\"terminationData\":\"2020-08-22\",\"expendTime\":60},{\"V01002\":\"2020-08-19 16:13:42\",\"V01003\":\"主变频器状态(故障);备用变频器状态(故障);\",\"V01011\":\"2020-08-19 19:40:29\",\"dataString\":\"2020-08-19\",\"terminationData\":\"2020-08-19\",\"expendTime\":206}],\"V00856\":230,\"V00844\":30,\"mbarNormalRate\":\"98.93%\",\"totalPower\":8571,\"energy\":405.5,\"V00868\":300},\"alarmReport\":{\"totalAlerts\":2171,\"powerFault\":0,\"other\":0,\"hyperpressureRate\":\"0%\",\"masterDrive\":0,\"pumpFailureFiveRate\":\"0%\",\"pumpFailureOneRate\":\"45.37%\",\"pumpFailureFourRate\":\"0%\",\"hyperpressure\":0,\"pumpFailureThree\":676,\"theSensorRate\":\"0%\",\"otherRate\":\"0%\",\"resPlcRate\":\"0%\",\"feedSensor\":0,\"pumpFailureTwoRate\":\"11.29%\",\"pumpFailureThreeRate\":\"31.14%\",\"resbq\":0,\"pumpFailureTwo\":245,\"mainPlc\":0,\"feedSensorRate\":\"0%\",\"pumpFailureFive\":0,\"resPlc\":0,\"powerFaultRate\":\"0%\",\"hydropenia\":265,\"mainPlcRate\":\"0%\",\"pumpFailureOne\":985,\"pumpFailureFour\":0,\"resbqRate\":\"0%\",\"hydropeniaRate\":\"12.21%\",\"masterDriveRate\":\"0%\",\"theSensor\":0}}}";
        Map map = JSON.parseObject(json, Map.class);
        Map map2 = JSON.parseObject(json2, Map.class);
        Map deviceMap = (Map) map2.get("data");
        Map dataMap = new HashMap();
        String templateName = "device_2003_new.ftl";//模板名称
        String path = PdfUtil.getClassPath();//生成的word存放的目录
        Map data = (Map) map.get("data");
        Map data2 = (Map) map.get("data");
        data2.put("device", deviceMap);
        dataMap.put("data", data2);
        Map thisMap = (Map) data.get("thisMap");
        Map lastMap = (Map) data.get("lastMap");
        Map aboveMap = (Map) data.get("aboveMap");
        String[] rowKeys = {""};
        String[] columnKeys = {"本周期", "上周期", "上上周期"};
        /*总出水量------------开始*/
        Double thisOutWaterTotal = thisMap.get("outWaterTotal") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("outWaterTotal")));
        Double lastOutWaterTotal = lastMap.get("outWaterTotal") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("outWaterTotal")));
        Double aboveOutWaterTotal = aboveMap.get("outWaterTotal") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("outWaterTotal")));
        double[][] datas1 = new double[][]{{thisOutWaterTotal, lastOutWaterTotal, aboveOutWaterTotal}};
        String pngPath1 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas1, rowKeys, columnKeys), "", "", "总出水量(m³)", pngPath1);
        String base641 = PdfUtil.encodeBase64File(pngPath1);
        data.put("base641", base641);
        /*总出水量------------结束*/

        /*总耗电量------------开始*/
        Double thisTotalPower = thisMap.get("totalPower") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("totalPower")));
        Double lastTotalPower = lastMap.get("totalPower") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("totalPower")));
        Double aboveTotalPower = aboveMap.get("totalPower") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("totalPower")));
        double[][] datas2 = new double[][]{{thisTotalPower, lastTotalPower, aboveTotalPower}};
        String pngPath2 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas2, rowKeys, columnKeys), "", "", "总耗电量(kWh)", pngPath2);
        String base642 = PdfUtil.encodeBase64File(pngPath2);
        data.put("base642", base642);
        /*总耗结束------------结束*/

        /*能耗kWh(m³·MPa)------------开始*/
        Double thisEnergy = thisMap.get("energy") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("energy")));
        Double lastEnergy = lastMap.get("energy") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("energy")));
        Double aboveEnergy = aboveMap.get("energy") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("energy")));
        double[][] datas3 = new double[][]{{thisEnergy, lastEnergy, aboveEnergy}};
        String pngPath3 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas3, rowKeys, columnKeys), "", "", "能耗kWh(m³·MPa)", pngPath3);
        String base643 = PdfUtil.encodeBase64File(pngPath3);
        data.put("base643", base643);
        /*能耗kWh(m³·MPa)------------结束*/

        /*在线时间(小时)------------开始*/
        Double thisOnlineTimeTotal = thisMap.get("onlineTimeTotal") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("onlineTimeTotal")));
        Double lastoOlineTimeTotal = lastMap.get("onlineTimeTotal") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("onlineTimeTotal")));
        Double aboveOnlineTimeTotal = aboveMap.get("onlineTimeTotal") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("onlineTimeTotal")));
        double[][] datas4 = new double[][]{{thisOnlineTimeTotal, lastoOlineTimeTotal, aboveOnlineTimeTotal}};
        String pngPath4 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas4, rowKeys, columnKeys), "", "", "在线时间(小时)", pngPath4);
        String base644 = PdfUtil.encodeBase64File(pngPath4);
        data.put("base644", base644);
        /*在线时间(小时)------------结束*/


        /*断线时间(小时)------------开始*/
        Double thisOffLineTotal = thisMap.get("offLineTotal") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("offLineTotal")));
        Double lastOffLineTotal = lastMap.get("offLineTotal") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("offLineTotal")));
        Double aboveOffLineTotal = aboveMap.get("offLineTotal") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("offLineTotal")));
        double[][] datas5 = new double[][]{{thisOffLineTotal, lastOffLineTotal, aboveOffLineTotal}};
        String pngPath5 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas5, rowKeys, columnKeys), "", "", "断线时间(小时)", pngPath5);
        String base645 = PdfUtil.encodeBase64File(pngPath5);
        data.put("base645", base645);
        /*断线时间(小时)------------结束*/

        /*压力稳定率(%)------------开始*/
        Double thisMbarNormalRatel = thisMap.get("mbarNormalRate") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("mbarNormalRate")).substring(0, String.valueOf(thisMap.get("mbarNormalRate")).length() - 1));
        Double lastMbarNormalRatel = lastMap.get("mbarNormalRate") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("mbarNormalRate")).substring(0, String.valueOf(lastMap.get("mbarNormalRate")).length() - 1));
        Double aboveMbarNormalRatel = aboveMap.get("mbarNormalRate") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("mbarNormalRate")).substring(0, String.valueOf(aboveMap.get("mbarNormalRate")).length() - 1));
        double[][] datas6 = new double[][]{{thisMbarNormalRatel, lastMbarNormalRatel, aboveMbarNormalRatel}};
        String pngPath6 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas6, rowKeys, columnKeys), "", "", "压力稳定率(%)", pngPath6);
        String base646 = PdfUtil.encodeBase64File(pngPath6);
        data.put("base646", base646);
        /*压力稳定率(%)------------结束*/

        /*故障时间比(%)------------开始*/
        Double thisFaultTimeRate = thisMap.get("faultTimeRate") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("faultTimeRate")).substring(0, String.valueOf(thisMap.get("faultTimeRate")).length() - 1));
        Double lastFaultTimeRate = lastMap.get("faultTimeRate") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("faultTimeRate")).substring(0, String.valueOf(lastMap.get("faultTimeRate")).length() - 1));
        Double aboveFaultTimeRate = aboveMap.get("faultTimeRate") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("faultTimeRate")).substring(0, String.valueOf(aboveMap.get("faultTimeRate")).length() - 1));
        double[][] datas7 = new double[][]{{thisFaultTimeRate, lastFaultTimeRate, aboveFaultTimeRate}};
        String pngPath7 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas7, rowKeys, columnKeys), "", "", "故障时间比(%)", pngPath7);
        String base647 = PdfUtil.encodeBase64File(pngPath7);
        data.put("base647", base647);
        /*故障时间比(%)------------结束*/

        /*异常及时排除率(%)------------开始*/
        Double thisTimelinessRate = thisMap.get("timelinessRate") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("timelinessRate")).substring(0, String.valueOf(thisMap.get("timelinessRate")).length() - 1));
        Double lastTimelinessRate = lastMap.get("timelinessRate") == null ? 0 : Double.parseDouble(String.valueOf(lastMap.get("timelinessRate")).substring(0, String.valueOf(lastMap.get("timelinessRate")).length() - 1));
        Double aboveTimelinessRate = aboveMap.get("timelinessRate") == null ? 0 : Double.parseDouble(String.valueOf(aboveMap.get("timelinessRate")).substring(0, String.valueOf(aboveMap.get("timelinessRate")).length() - 1));
        double[][] datas8 = new double[][]{{thisTimelinessRate, lastTimelinessRate, aboveTimelinessRate}};
        String pngPath8 = path + UUID.randomUUID() + ".png";
        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(datas8, rowKeys, columnKeys), "", "", "异常及时排除率(%)", pngPath8);
        String base648 = PdfUtil.encodeBase64File(pngPath8);
        data.put("base648", base648);
        /*异常及时排除率(%)------------结束*/

        /*在线率(%)饼图------------开始*/
        Double thisOnlineRate = thisMap.get("onlineRate") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("onlineRate")).substring(0, String.valueOf(thisMap.get("onlineRate")).length() - 1));
        Double dx = 100 - thisOnlineRate;
        double[] data9 = {thisOnlineRate, dx};
        String[] keys1 = {"在线", "断线"};
        String pngPath9 = path + UUID.randomUUID() + ".png";
        PieChartUtil.createValidityComparePimChar(PieChartUtil.getDataPieSetByUtil(data9, keys1), "在线与断线", pngPath9, keys1);
        String base649 = PdfUtil.encodeBase64File(pngPath9);
        data.put("base649", base649);
        /*在线率(%)饼图------------结束*/

        /*出水压力(%)饼图------------开始*/
        Double thisMbarNormalRate = thisMap.get("mbarNormalRate") == null ? 0 : Double.parseDouble(String.valueOf(thisMap.get("mbarNormalRate")).substring(0, String.valueOf(thisMap.get("mbarNormalRate")).length() - 1));
        Double yc = 100 - thisMbarNormalRate;
        double[] data10 = {thisMbarNormalRate, yc};
        String[] keys2 = {"正常", "异常"};
        String pngPath10 = path + UUID.randomUUID() + ".png";
        PieChartUtil.createValidityComparePimChar(PieChartUtil.getDataPieSetByUtil(data10, keys2), "出水压力", pngPath10, keys2);
        String base6410 = PdfUtil.encodeBase64File(pngPath10);
        data.put("base6410", base6410);
        /*出水压力(%)饼图------------结束*/

        /*故障率(%)饼图------------开始*/
        Double gz = 100 - thisFaultTimeRate;
        double[] data11 = {gz, thisFaultTimeRate};
        String[] keys3 = {"正常", "异常"};
        String pngPath11 = path + UUID.randomUUID() + ".png";
        PieChartUtil.createValidityComparePimChar(PieChartUtil.getDataPieSetByUtil(data11, keys3), "故障时间", pngPath11, keys3);
        String base6411 = PdfUtil.encodeBase64File(pngPath11);
        data.put("base6411", base6411);
        /*故障率(%)饼图------------结束*/
        String outWordPath = path + UUID.randomUUID() + ".doc";//生成word存放目录
        PdfUtil.createWord(templateName, outWordPath, map);//通过freemake生成word
        //word文档转pdf文档
        InputStream inputStream = PdfUtil.word2ConvertPdf(outWordPath);
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("单设备报表.pdf", "UTF-8"));
        int b = 0;
        byte[] buffer = new byte[1024];
        while (b != -1) {
            b = inputStream.read(buffer);
            if (b != -1) {
                out.write(buffer, 0, b);
            }
        }
        out.flush();
        out.close();
        inputStream.close();
    }

    @RequestMapping(value = "test")
    public void test(HttpServletResponse response) {
        try {
            String json = "{\"code\":\"1\",\"desc\":\"获取数据成功！\",\"data\":{\"total\":{\"V00819total\":573.6,\"V00817_max\":594.0,\"jynh\":1.01,\"V00817_min\":20.4,\"V00819_max\":587.0,\"V00817total\":573.6,\"V00819_min\":13.4,\"jypjz\":2.53},\"list\":[{\"V00819total\":4.0,\"nh\":0.53,\"V00817_max\":18.2,\"time\":\"2020-08-10 00:00:30\",\"jynh\":0.72,\"V00817_min\":14.2,\"V00819_max\":25.2,\"V00819_min\":21.2,\"V00817total\":4.0,\"jypjz\":0.95},{\"V00819total\":2.4,\"nh\":1.2,\"V00817_max\":23.0,\"time\":\"2020-08-10 00:02:00\",\"jynh\":0.77,\"V00817_min\":20.6,\"V00819_max\":30.0,\"V00819_min\":27.6,\"V00817total\":2.4,\"jypjz\":1.51},{\"V00819total\":2.4,\"nh\":1.6,\"V00817_max\":27.8,\"time\":\"2020-08-10 00:03:00\",\"jynh\":0.8,\"V00817_min\":25.4,\"V00819_max\":34.8,\"V00819_min\":32.4,\"V00817total\":2.4,\"jypjz\":1.58},{\"V00819total\":2.4,\"nh\":2.0,\"V00817_max\":32.6,\"time\":\"2020-08-10 00:04:00\",\"jynh\":0.82,\"V00817_min\":30.2,\"V00819_max\":39.6,\"V00819_min\":37.2,\"V00817total\":2.4,\"jypjz\":1.64},{\"V00819total\":2.4,\"nh\":2.4,\"V00817_max\":37.4,\"time\":\"2020-08-10 00:05:00\",\"jynh\":0.84,\"V00817_min\":35.0,\"V00819_max\":44.4,\"V00819_min\":42.0,\"V00817total\":2.4,\"jypjz\":1.68},{\"V00819total\":2.4,\"nh\":2.8,\"V00817_max\":42.2,\"time\":\"2020-08-10 00:06:00\",\"jynh\":0.86,\"V00817_min\":39.8,\"V00819_max\":49.2,\"V00819_min\":46.8,\"V00817total\":2.4,\"jypjz\":1.71},{\"V00819total\":2.4,\"nh\":3.2,\"V00817_max\":47.0,\"time\":\"2020-08-10 00:07:00\",\"jynh\":0.87,\"V00817_min\":44.6,\"V00819_max\":54.0,\"V00819_min\":51.6,\"V00817total\":2.4,\"jypjz\":1.73},{\"V00819total\":2.4,\"nh\":3.6,\"V00817_max\":51.8,\"time\":\"2020-08-10 00:08:00\",\"jynh\":0.88,\"V00817_min\":49.4,\"V00819_max\":58.8,\"V00819_min\":56.4,\"V00817total\":2.4,\"jypjz\":1.76},{\"V00819total\":2.4,\"nh\":4.0,\"V00817_max\":56.6,\"time\":\"2020-08-10 00:09:00\",\"jynh\":0.89,\"V00817_min\":54.2,\"V00819_max\":63.6,\"V00819_min\":61.2,\"V00817total\":2.4,\"jypjz\":1.78},{\"V00819total\":2.4,\"nh\":4.4,\"V00817_max\":61.4,\"time\":\"2020-08-10 00:10:00\",\"jynh\":0.9,\"V00817_min\":59.0,\"V00819_max\":68.4,\"V00819_min\":66.0,\"V00817total\":2.4,\"jypjz\":1.79},{\"V00819total\":2.4,\"nh\":4.8,\"V00817_max\":66.2,\"time\":\"2020-08-10 00:11:00\",\"jynh\":0.9,\"V00817_min\":63.8,\"V00819_max\":73.2,\"V00819_min\":70.8,\"V00817total\":2.4,\"jypjz\":1.81},{\"V00819total\":2.4,\"nh\":5.2,\"V00817_max\":71.0,\"time\":\"2020-08-10 00:12:00\",\"jynh\":0.91,\"V00817_min\":68.6,\"V00819_max\":78.0,\"V00819_min\":75.6,\"V00817total\":2.4,\"jypjz\":1.82},{\"V00819total\":2.4,\"nh\":5.6,\"V00817_max\":75.8,\"time\":\"2020-08-10 00:13:00\",\"jynh\":0.92,\"V00817_min\":73.4,\"V00819_max\":82.8,\"V00819_min\":80.4,\"V00817total\":2.4,\"jypjz\":1.83},{\"V00819total\":2.4,\"nh\":6.0,\"V00817_max\":80.6,\"time\":\"2020-08-10 00:14:00\",\"jynh\":0.92,\"V00817_min\":78.2,\"V00819_max\":87.6,\"V00819_min\":85.2,\"V00817total\":2.4,\"jypjz\":1.84},{\"V00819total\":2.4,\"nh\":6.4,\"V00817_max\":85.4,\"time\":\"2020-08-10 00:15:00\",\"jynh\":0.92,\"V00817_min\":83.0,\"V00819_max\":92.4,\"V00819_min\":90.0,\"V00817total\":2.4,\"jypjz\":1.85},{\"V00819total\":2.4,\"nh\":6.8,\"V00817_max\":90.2,\"time\":\"2020-08-10 00:16:00\",\"jynh\":0.93,\"V00817_min\":87.8,\"V00819_max\":97.2,\"V00819_min\":94.8,\"V00817total\":2.4,\"jypjz\":1.85},{\"V00819total\":2.4,\"nh\":7.2,\"V00817_max\":95.0,\"time\":\"2020-08-10 00:17:00\",\"jynh\":0.93,\"V00817_min\":92.6,\"V00819_max\":102.0,\"V00819_min\":99.6,\"V00817total\":2.4,\"jypjz\":1.86},{\"V00819total\":2.4,\"nh\":7.6,\"V00817_max\":99.8,\"time\":\"2020-08-10 00:18:00\",\"jynh\":0.93,\"V00817_min\":97.4,\"V00819_max\":106.8,\"V00819_min\":104.4,\"V00817total\":2.4,\"jypjz\":1.87},{\"V00819total\":2.4,\"nh\":8.0,\"V00817_max\":104.6,\"time\":\"2020-08-10 00:19:00\",\"jynh\":0.94,\"V00817_min\":102.2,\"V00819_max\":111.6,\"V00819_min\":109.2,\"V00817total\":2.4,\"jypjz\":1.87},{\"V00819total\":2.4,\"nh\":8.4,\"V00817_max\":109.4,\"time\":\"2020-08-10 00:20:00\",\"jynh\":0.94,\"V00817_min\":107.0,\"V00819_max\":116.4,\"V00819_min\":114.0,\"V00817total\":2.4,\"jypjz\":1.88},{\"V00819total\":2.4,\"nh\":8.8,\"V00817_max\":114.2,\"time\":\"2020-08-10 00:21:00\",\"jynh\":0.94,\"V00817_min\":111.8,\"V00819_max\":121.2,\"V00819_min\":118.8,\"V00817total\":2.4,\"jypjz\":1.88},{\"V00819total\":2.4,\"nh\":9.2,\"V00817_max\":119.0,\"time\":\"2020-08-10 00:22:00\",\"jynh\":0.94,\"V00817_min\":116.6,\"V00819_max\":126.0,\"V00819_min\":123.6,\"V00817total\":2.4,\"jypjz\":1.89},{\"V00819total\":2.4,\"nh\":9.6,\"V00817_max\":123.8,\"time\":\"2020-08-10 00:23:00\",\"jynh\":0.95,\"V00817_min\":121.4,\"V00819_max\":130.8,\"V00819_min\":128.4,\"V00817total\":2.4,\"jypjz\":1.89},{\"V00819total\":2.4,\"nh\":10.0,\"V00817_max\":128.6,\"time\":\"2020-08-10 00:24:00\",\"jynh\":0.95,\"V00817_min\":126.2,\"V00819_max\":135.6,\"V00819_min\":133.2,\"V00817total\":2.4,\"jypjz\":1.9},{\"V00819total\":2.4,\"nh\":10.4,\"V00817_max\":133.4,\"time\":\"2020-08-10 00:25:00\",\"jynh\":0.95,\"V00817_min\":131.0,\"V00819_max\":140.4,\"V00819_min\":138.0,\"V00817total\":2.4,\"jypjz\":1.9},{\"V00819total\":2.4,\"nh\":10.8,\"V00817_max\":138.2,\"time\":\"2020-08-10 00:26:00\",\"jynh\":0.95,\"V00817_min\":135.8,\"V00819_max\":145.2,\"V00819_min\":142.8,\"V00817total\":2.4,\"jypjz\":1.9},{\"V00819total\":2.4,\"nh\":11.2,\"V00817_max\":143.0,\"time\":\"2020-08-10 00:27:00\",\"jynh\":0.95,\"V00817_min\":140.6,\"V00819_max\":150.0,\"V00819_min\":147.6,\"V00817total\":2.4,\"jypjz\":1.91},{\"V00819total\":2.4,\"nh\":11.6,\"V00817_max\":147.8,\"time\":\"2020-08-10 00:28:00\",\"jynh\":0.95,\"V00817_min\":145.4,\"V00819_max\":154.8,\"V00819_min\":152.4,\"V00817total\":2.4,\"jypjz\":1.91},{\"V00819total\":2.4,\"nh\":12.0,\"V00817_max\":152.6,\"time\":\"2020-08-10 00:29:00\",\"jynh\":0.96,\"V00817_min\":150.2,\"V00819_max\":159.6,\"V00819_min\":157.2,\"V00817total\":2.4,\"jypjz\":1.91},{\"V00819total\":2.4,\"nh\":12.4,\"V00817_max\":157.4,\"time\":\"2020-08-10 00:30:00\",\"jynh\":0.96,\"V00817_min\":155.0,\"V00819_max\":164.4,\"V00819_min\":162.0,\"V00817total\":2.4,\"jypjz\":1.91},{\"V00819total\":2.4,\"nh\":12.8,\"V00817_max\":162.2,\"time\":\"2020-08-10 00:31:00\",\"jynh\":0.96,\"V00817_min\":159.8,\"V00819_max\":169.2,\"V00819_min\":166.8,\"V00817total\":2.4,\"jypjz\":1.92},{\"V00819total\":2.4,\"nh\":13.2,\"V00817_max\":167.0,\"time\":\"2020-08-10 00:32:00\",\"jynh\":0.96,\"V00817_min\":164.6,\"V00819_max\":174.0,\"V00819_min\":171.6,\"V00817total\":2.4,\"jypjz\":1.92},{\"V00819total\":2.4,\"nh\":13.6,\"V00817_max\":171.8,\"time\":\"2020-08-10 00:33:00\",\"jynh\":0.96,\"V00817_min\":169.4,\"V00819_max\":178.8,\"V00819_min\":176.4,\"V00817total\":2.4,\"jypjz\":1.92},{\"V00819total\":2.4,\"nh\":14.0,\"V00817_max\":176.6,\"time\":\"2020-08-10 00:34:00\",\"jynh\":0.96,\"V00817_min\":174.2,\"V00819_max\":183.6,\"V00819_min\":181.2,\"V00817total\":2.4,\"jypjz\":1.92},{\"V00819total\":2.4,\"nh\":14.4,\"V00817_max\":181.4,\"time\":\"2020-08-10 00:35:00\",\"jynh\":0.96,\"V00817_min\":179.0,\"V00819_max\":188.4,\"V00819_min\":186.0,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":14.8,\"V00817_max\":186.2,\"time\":\"2020-08-10 00:36:00\",\"jynh\":0.96,\"V00817_min\":183.8,\"V00819_max\":193.2,\"V00819_min\":190.8,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":15.2,\"V00817_max\":191.0,\"time\":\"2020-08-10 00:37:00\",\"jynh\":0.96,\"V00817_min\":188.6,\"V00819_max\":198.0,\"V00819_min\":195.6,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":15.6,\"V00817_max\":195.8,\"time\":\"2020-08-10 00:38:00\",\"jynh\":0.97,\"V00817_min\":193.4,\"V00819_max\":202.8,\"V00819_min\":200.4,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":16.0,\"V00817_max\":200.6,\"time\":\"2020-08-10 00:39:00\",\"jynh\":0.97,\"V00817_min\":198.2,\"V00819_max\":207.6,\"V00819_min\":205.2,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":16.4,\"V00817_max\":205.4,\"time\":\"2020-08-10 00:40:00\",\"jynh\":0.97,\"V00817_min\":203.0,\"V00819_max\":212.4,\"V00819_min\":210.0,\"V00817total\":2.4,\"jypjz\":1.93},{\"V00819total\":2.4,\"nh\":16.8,\"V00817_max\":210.2,\"time\":\"2020-08-10 00:41:00\",\"jynh\":0.97,\"V00817_min\":207.8,\"V00819_max\":217.2,\"V00819_min\":214.8,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":17.2,\"V00817_max\":215.0,\"time\":\"2020-08-10 00:42:00\",\"jynh\":0.97,\"V00817_min\":212.6,\"V00819_max\":222.0,\"V00819_min\":219.6,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":17.6,\"V00817_max\":219.8,\"time\":\"2020-08-10 00:43:00\",\"jynh\":0.97,\"V00817_min\":217.4,\"V00819_max\":226.8,\"V00819_min\":224.4,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":18.0,\"V00817_max\":224.6,\"time\":\"2020-08-10 00:44:00\",\"jynh\":0.97,\"V00817_min\":222.2,\"V00819_max\":231.6,\"V00819_min\":229.2,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":18.4,\"V00817_max\":229.4,\"time\":\"2020-08-10 00:45:00\",\"jynh\":0.97,\"V00817_min\":227.0,\"V00819_max\":236.4,\"V00819_min\":234.0,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":18.8,\"V00817_max\":234.2,\"time\":\"2020-08-10 00:46:00\",\"jynh\":0.97,\"V00817_min\":231.8,\"V00819_max\":241.2,\"V00819_min\":238.8,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":19.2,\"V00817_max\":239.0,\"time\":\"2020-08-10 00:47:00\",\"jynh\":0.97,\"V00817_min\":236.6,\"V00819_max\":246.0,\"V00819_min\":243.6,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":19.6,\"V00817_max\":243.8,\"time\":\"2020-08-10 00:48:00\",\"jynh\":0.97,\"V00817_min\":241.4,\"V00819_max\":250.8,\"V00819_min\":248.4,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":20.0,\"V00817_max\":248.6,\"time\":\"2020-08-10 00:49:00\",\"jynh\":0.97,\"V00817_min\":246.2,\"V00819_max\":255.6,\"V00819_min\":253.2,\"V00817total\":2.4,\"jypjz\":1.94},{\"V00819total\":2.4,\"nh\":20.4,\"V00817_max\":253.4,\"time\":\"2020-08-10 00:50:00\",\"jynh\":0.97,\"V00817_min\":251.0,\"V00819_max\":260.4,\"V00819_min\":258.0,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":20.8,\"V00817_max\":258.2,\"time\":\"2020-08-10 00:51:00\",\"jynh\":0.97,\"V00817_min\":255.8,\"V00819_max\":265.2,\"V00819_min\":262.8,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":21.2,\"V00817_max\":263.0,\"time\":\"2020-08-10 00:52:00\",\"jynh\":0.97,\"V00817_min\":260.6,\"V00819_max\":270.0,\"V00819_min\":267.6,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":21.6,\"V00817_max\":267.8,\"time\":\"2020-08-10 00:53:00\",\"jynh\":0.97,\"V00817_min\":265.4,\"V00819_max\":274.8,\"V00819_min\":272.4,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":22.0,\"V00817_max\":272.6,\"time\":\"2020-08-10 00:54:00\",\"jynh\":0.97,\"V00817_min\":270.2,\"V00819_max\":279.6,\"V00819_min\":277.2,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":22.4,\"V00817_max\":277.4,\"time\":\"2020-08-10 00:55:00\",\"jynh\":0.98,\"V00817_min\":275.0,\"V00819_max\":284.4,\"V00819_min\":282.0,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":22.8,\"V00817_max\":282.2,\"time\":\"2020-08-10 00:56:00\",\"jynh\":0.98,\"V00817_min\":279.8,\"V00819_max\":289.2,\"V00819_min\":286.8,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":23.2,\"V00817_max\":287.0,\"time\":\"2020-08-10 00:57:00\",\"jynh\":0.98,\"V00817_min\":284.6,\"V00819_max\":294.0,\"V00819_min\":291.6,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":23.6,\"V00817_max\":291.8,\"time\":\"2020-08-10 00:58:00\",\"jynh\":0.98,\"V00817_min\":289.4,\"V00819_max\":298.8,\"V00819_min\":296.4,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":24.0,\"V00817_max\":296.6,\"time\":\"2020-08-10 00:59:00\",\"jynh\":0.98,\"V00817_min\":294.2,\"V00819_max\":303.6,\"V00819_min\":301.2,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":24.4,\"V00817_max\":301.4,\"time\":\"2020-08-10 01:00:00\",\"jynh\":0.98,\"V00817_min\":299.0,\"V00819_max\":308.4,\"V00819_min\":306.0,\"V00817total\":2.4,\"jypjz\":1.95},{\"V00819total\":2.4,\"nh\":24.8,\"V00817_max\":306.2,\"time\":\"2020-08-10 01:01:00\",\"jynh\":0.98,\"V00817_min\":303.8,\"V00819_max\":313.2,\"V00819_min\":310.8,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":25.2,\"V00817_max\":311.0,\"time\":\"2020-08-10 01:02:00\",\"jynh\":0.98,\"V00817_min\":308.6,\"V00819_max\":318.0,\"V00819_min\":315.6,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":25.6,\"V00817_max\":315.8,\"time\":\"2020-08-10 01:03:00\",\"jynh\":0.98,\"V00817_min\":313.4,\"V00819_max\":322.8,\"V00819_min\":320.4,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":26.0,\"V00817_max\":320.6,\"time\":\"2020-08-10 01:04:00\",\"jynh\":0.98,\"V00817_min\":318.2,\"V00819_max\":327.6,\"V00819_min\":325.2,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":26.4,\"V00817_max\":325.4,\"time\":\"2020-08-10 01:05:00\",\"jynh\":0.98,\"V00817_min\":323.0,\"V00819_max\":332.4,\"V00819_min\":330.0,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":26.8,\"V00817_max\":330.2,\"time\":\"2020-08-10 01:06:00\",\"jynh\":0.98,\"V00817_min\":327.8,\"V00819_max\":337.2,\"V00819_min\":334.8,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":27.2,\"V00817_max\":335.0,\"time\":\"2020-08-10 01:07:00\",\"jynh\":0.98,\"V00817_min\":332.6,\"V00819_max\":342.0,\"V00819_min\":339.6,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":27.6,\"V00817_max\":339.8,\"time\":\"2020-08-10 01:08:00\",\"jynh\":0.98,\"V00817_min\":337.4,\"V00819_max\":346.8,\"V00819_min\":344.4,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":28.0,\"V00817_max\":344.6,\"time\":\"2020-08-10 01:09:00\",\"jynh\":0.98,\"V00817_min\":342.2,\"V00819_max\":351.6,\"V00819_min\":349.2,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":28.4,\"V00817_max\":349.4,\"time\":\"2020-08-10 01:10:00\",\"jynh\":0.98,\"V00817_min\":347.0,\"V00819_max\":356.4,\"V00819_min\":354.0,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":28.8,\"V00817_max\":354.2,\"time\":\"2020-08-10 01:11:00\",\"jynh\":0.98,\"V00817_min\":351.8,\"V00819_max\":361.2,\"V00819_min\":358.8,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":29.2,\"V00817_max\":359.0,\"time\":\"2020-08-10 01:12:00\",\"jynh\":0.98,\"V00817_min\":356.6,\"V00819_max\":366.0,\"V00819_min\":363.6,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":29.6,\"V00817_max\":363.8,\"time\":\"2020-08-10 01:13:00\",\"jynh\":0.98,\"V00817_min\":361.4,\"V00819_max\":370.8,\"V00819_min\":368.4,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":30.0,\"V00817_max\":368.6,\"time\":\"2020-08-10 01:14:00\",\"jynh\":0.98,\"V00817_min\":366.2,\"V00819_max\":375.6,\"V00819_min\":373.2,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":30.4,\"V00817_max\":373.4,\"time\":\"2020-08-10 01:15:00\",\"jynh\":0.98,\"V00817_min\":371.0,\"V00819_max\":380.4,\"V00819_min\":378.0,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":30.8,\"V00817_max\":378.2,\"time\":\"2020-08-10 01:16:00\",\"jynh\":0.98,\"V00817_min\":375.8,\"V00819_max\":385.2,\"V00819_min\":382.8,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":31.2,\"V00817_max\":383.0,\"time\":\"2020-08-10 01:17:00\",\"jynh\":0.98,\"V00817_min\":380.6,\"V00819_max\":390.0,\"V00819_min\":387.6,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":31.6,\"V00817_max\":387.8,\"time\":\"2020-08-10 01:18:00\",\"jynh\":0.98,\"V00817_min\":385.4,\"V00819_max\":394.8,\"V00819_min\":392.4,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":32.0,\"V00817_max\":392.6,\"time\":\"2020-08-10 01:19:00\",\"jynh\":0.98,\"V00817_min\":390.2,\"V00819_max\":399.6,\"V00819_min\":397.2,\"V00817total\":2.4,\"jypjz\":1.96},{\"V00819total\":2.4,\"nh\":32.4,\"V00817_max\":397.4,\"time\":\"2020-08-10 01:20:00\",\"jynh\":0.98,\"V00817_min\":395.0,\"V00819_max\":404.4,\"V00819_min\":402.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":32.8,\"V00817_max\":402.2,\"time\":\"2020-08-10 01:21:00\",\"jynh\":0.98,\"V00817_min\":399.8,\"V00819_max\":409.2,\"V00819_min\":406.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":33.2,\"V00817_max\":407.0,\"time\":\"2020-08-10 01:22:00\",\"jynh\":0.98,\"V00817_min\":404.6,\"V00819_max\":414.0,\"V00819_min\":411.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":33.6,\"V00817_max\":411.8,\"time\":\"2020-08-10 01:23:00\",\"jynh\":0.98,\"V00817_min\":409.4,\"V00819_max\":418.8,\"V00819_min\":416.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":34.0,\"V00817_max\":416.6,\"time\":\"2020-08-10 01:24:00\",\"jynh\":0.98,\"V00817_min\":414.2,\"V00819_max\":423.6,\"V00819_min\":421.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":34.4,\"V00817_max\":421.4,\"time\":\"2020-08-10 01:25:00\",\"jynh\":0.98,\"V00817_min\":419.0,\"V00819_max\":428.4,\"V00819_min\":426.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":34.8,\"V00817_max\":426.2,\"time\":\"2020-08-10 01:26:00\",\"jynh\":0.98,\"V00817_min\":423.8,\"V00819_max\":433.2,\"V00819_min\":430.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":35.2,\"V00817_max\":431.0,\"time\":\"2020-08-10 01:27:00\",\"jynh\":0.98,\"V00817_min\":428.6,\"V00819_max\":438.0,\"V00819_min\":435.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":35.6,\"V00817_max\":435.8,\"time\":\"2020-08-10 01:28:00\",\"jynh\":0.98,\"V00817_min\":433.4,\"V00819_max\":442.8,\"V00819_min\":440.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":36.0,\"V00817_max\":440.6,\"time\":\"2020-08-10 01:29:00\",\"jynh\":0.98,\"V00817_min\":438.2,\"V00819_max\":447.6,\"V00819_min\":445.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":36.4,\"V00817_max\":445.4,\"time\":\"2020-08-10 01:30:00\",\"jynh\":0.98,\"V00817_min\":443.0,\"V00819_max\":452.4,\"V00819_min\":450.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":36.8,\"V00817_max\":450.2,\"time\":\"2020-08-10 01:31:00\",\"jynh\":0.98,\"V00817_min\":447.8,\"V00819_max\":457.2,\"V00819_min\":454.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":37.2,\"V00817_max\":455.0,\"time\":\"2020-08-10 01:32:00\",\"jynh\":0.98,\"V00817_min\":452.6,\"V00819_max\":462.0,\"V00819_min\":459.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":37.6,\"V00817_max\":459.8,\"time\":\"2020-08-10 01:33:00\",\"jynh\":0.99,\"V00817_min\":457.4,\"V00819_max\":466.8,\"V00819_min\":464.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":38.0,\"V00817_max\":464.6,\"time\":\"2020-08-10 01:34:00\",\"jynh\":0.99,\"V00817_min\":462.2,\"V00819_max\":471.6,\"V00819_min\":469.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":38.4,\"V00817_max\":469.4,\"time\":\"2020-08-10 01:35:00\",\"jynh\":0.99,\"V00817_min\":467.0,\"V00819_max\":476.4,\"V00819_min\":474.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":38.8,\"V00817_max\":474.2,\"time\":\"2020-08-10 01:36:00\",\"jynh\":0.99,\"V00817_min\":471.8,\"V00819_max\":481.2,\"V00819_min\":478.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":39.2,\"V00817_max\":479.0,\"time\":\"2020-08-10 01:37:00\",\"jynh\":0.99,\"V00817_min\":476.6,\"V00819_max\":486.0,\"V00819_min\":483.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":39.6,\"V00817_max\":483.8,\"time\":\"2020-08-10 01:38:00\",\"jynh\":0.99,\"V00817_min\":481.4,\"V00819_max\":490.8,\"V00819_min\":488.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":40.0,\"V00817_max\":488.6,\"time\":\"2020-08-10 01:39:00\",\"jynh\":0.99,\"V00817_min\":486.2,\"V00819_max\":495.6,\"V00819_min\":493.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":40.4,\"V00817_max\":493.4,\"time\":\"2020-08-10 01:40:00\",\"jynh\":0.99,\"V00817_min\":491.0,\"V00819_max\":500.4,\"V00819_min\":498.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":40.8,\"V00817_max\":498.2,\"time\":\"2020-08-10 01:41:00\",\"jynh\":0.99,\"V00817_min\":495.8,\"V00819_max\":505.2,\"V00819_min\":502.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":41.2,\"V00817_max\":503.0,\"time\":\"2020-08-10 01:42:00\",\"jynh\":0.99,\"V00817_min\":500.6,\"V00819_max\":510.0,\"V00819_min\":507.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":41.6,\"V00817_max\":507.8,\"time\":\"2020-08-10 01:43:00\",\"jynh\":0.99,\"V00817_min\":505.4,\"V00819_max\":514.8,\"V00819_min\":512.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":42.0,\"V00817_max\":512.6,\"time\":\"2020-08-10 01:44:00\",\"jynh\":0.99,\"V00817_min\":510.2,\"V00819_max\":519.6,\"V00819_min\":517.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":42.4,\"V00817_max\":517.4,\"time\":\"2020-08-10 01:45:00\",\"jynh\":0.99,\"V00817_min\":515.0,\"V00819_max\":524.4,\"V00819_min\":522.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":42.8,\"V00817_max\":522.2,\"time\":\"2020-08-10 01:46:00\",\"jynh\":0.99,\"V00817_min\":519.8,\"V00819_max\":529.2,\"V00819_min\":526.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":43.2,\"V00817_max\":527.0,\"time\":\"2020-08-10 01:47:00\",\"jynh\":0.99,\"V00817_min\":524.6,\"V00819_max\":534.0,\"V00819_min\":531.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":43.6,\"V00817_max\":531.8,\"time\":\"2020-08-10 01:48:00\",\"jynh\":0.99,\"V00817_min\":529.4,\"V00819_max\":538.8,\"V00819_min\":536.4,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":44.0,\"V00817_max\":536.6,\"time\":\"2020-08-10 01:49:00\",\"jynh\":0.99,\"V00817_min\":534.2,\"V00819_max\":543.6,\"V00819_min\":541.2,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":44.4,\"V00817_max\":541.4,\"time\":\"2020-08-10 01:50:00\",\"jynh\":0.99,\"V00817_min\":539.0,\"V00819_max\":548.4,\"V00819_min\":546.0,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":44.8,\"V00817_max\":546.2,\"time\":\"2020-08-10 01:51:00\",\"jynh\":0.99,\"V00817_min\":543.8,\"V00819_max\":553.2,\"V00819_min\":550.8,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":45.2,\"V00817_max\":551.0,\"time\":\"2020-08-10 01:52:00\",\"jynh\":0.99,\"V00817_min\":548.6,\"V00819_max\":558.0,\"V00819_min\":555.6,\"V00817total\":2.4,\"jypjz\":1.97},{\"V00819total\":2.4,\"nh\":45.6,\"V00817_max\":555.8,\"time\":\"2020-08-10 01:53:00\",\"jynh\":0.99,\"V00817_min\":553.4,\"V00819_max\":562.8,\"V00819_min\":560.4,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":46.0,\"V00817_max\":560.6,\"time\":\"2020-08-10 01:54:00\",\"jynh\":0.99,\"V00817_min\":558.2,\"V00819_max\":567.6,\"V00819_min\":565.2,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":46.4,\"V00817_max\":565.4,\"time\":\"2020-08-10 01:55:00\",\"jynh\":0.99,\"V00817_min\":563.0,\"V00819_max\":572.4,\"V00819_min\":570.0,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":46.8,\"V00817_max\":570.2,\"time\":\"2020-08-10 01:56:00\",\"jynh\":0.99,\"V00817_min\":567.8,\"V00819_max\":577.2,\"V00819_min\":574.8,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":47.2,\"V00817_max\":575.0,\"time\":\"2020-08-10 01:57:00\",\"jynh\":0.99,\"V00817_min\":572.6,\"V00819_max\":582.0,\"V00819_min\":579.6,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":47.6,\"V00817_max\":579.8,\"time\":\"2020-08-10 01:58:00\",\"jynh\":0.99,\"V00817_min\":577.4,\"V00819_max\":586.8,\"V00819_min\":584.4,\"V00817total\":2.4,\"jypjz\":1.98},{\"V00819total\":2.4,\"nh\":48.0,\"V00817_max\":584.6,\"time\":\"2020-08-10 01:59:00\",\"jynh\":0.99,\"V00817_min\":582.2,\"V00819_max\":591.6,\"V00819_min\":589.2,\"V00817total\":2.4,\"jypjz\":1.98}],\"device\":[{\"V00341\":\"\",\"V00309\":\"\",\"V00310\":\"\",\"V00311\":\"\",\"V00313\":\"\",\"V00314\":\"\",\"V00319\":\"\",\"V00312\":\"\",\"deviceno\":\"10003\",\"bennum\":3,\"V00803\":0.0}]}}";
            Map map = JSON.parseObject(json, Map.class);
            Map data = (Map) map.get("data");
            List<Map<String, Object>> list = (List<Map<String, Object>>) data.get("list");
            String path = PdfUtil.getClassPath();//生成的word存放的目录
            /*生成折线图----------------开始*/

            List<String> xStr = new ArrayList();
            List<Double> pointStr = new ArrayList();
            for (Map<String, Object> objMap : list) {
                // 标注类别
                xStr.add(String.valueOf(objMap.get("time")));
                pointStr.add(Double.valueOf(String.valueOf(objMap.get("nh"))));
            }
            //设置x轴
            String[] categories = new String[xStr.size()];
            for (int i = 0; i < xStr.size(); i++) {
                categories[i] = xStr.get(i);
            }
            Vector<Serie> series = new Vector<Serie>();
            Double[] point = new Double[pointStr.size()];
            for (int i = 0; i < pointStr.size(); i++) {
                point[i] = pointStr.get(i);
            }
            // 柱子名称：柱子所有的值集合
            series.add(new Serie("", point));
            // 1：创建数据集合
            DefaultCategoryDataset dataset = ChartUtils.createDefaultCategoryDataset(series, categories);
            // 2：创建Chart[创建不同图形]
            JFreeChart chart = ChartFactory.createLineChart("能耗分析", "", "", dataset);
            // 3:设置抗锯齿，防止字体显示不清楚
            ChartUtils.setAntiAlias(chart);// 抗锯齿
            // 4:对柱子进行渲染[[采用不同渲染]]
            ChartUtils.setLineRender(chart.getCategoryPlot(), false, true);
            // 5:对其他部分进行渲染
            ChartUtils.setXAixs(chart.getCategoryPlot());// X坐标轴渲染
            ChartUtils.setYAixs(chart.getCategoryPlot());// Y坐标轴渲染
            // 设置标注无边框
            chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
            String photoPath = path + UUID.randomUUID() + ".png";
            ChartUtils.saveAsFile(chart, photoPath, 1000, 500);
            String base641 = PdfUtil.encodeBase64File(photoPath);
            data.put("base641", base641);
            /*生成折线图----------------结束*/

            String templateName = "device_energy.ftl";//模板名称

            String outWordPath = path + UUID.randomUUID() + ".doc";//生成word存放目录
            PdfUtil.createWord(templateName, outWordPath, data);//通过freemake生成word
            //word文档转pdf文档
            InputStream inputStream = PdfUtil.word2ConvertPdf(outWordPath);
            response.setContentType("application/pdf");
            OutputStream out = response.getOutputStream();
            response.addHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("单设备报表.pdf", "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1024];
            while (b != -1) {
                b = inputStream.read(buffer);
                if (b != -1) {
                    out.write(buffer, 0, b);
                }
            }
            out.flush();
            out.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
