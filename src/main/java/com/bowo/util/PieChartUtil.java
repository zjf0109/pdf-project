package com.bowo.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author zhaojufeng
 * @date 2020/8/28 10:13
 */
public class PieChartUtil {

    /**
     * 生成饼状图
     */

    public void makePieChart() {
        double[] data = {9, 91};
        String[] keys = {"失败率", "成功率"};
        createValidityComparePimChar(getDataPieSetByUtil(data, keys), "饼状图",
                "饼状图.png", keys);
    }

    /**
     * 饼状图
     *
     * @param dataset    数据集
     * @param chartTitle 图标题
     * @param path       生成图的名字
     * @param pieKeys    分饼的名字集
     * @return
     */
    public static void createValidityComparePimChar(PieDataset dataset,
                                                    String chartTitle, String path, String[] pieKeys) {
        JFreeChart chart = ChartFactory.createPieChart("", dataset, true, false, false);

        //设置图表的标题
        chart.setTitle(new TextTitle(chartTitle, new Font("微软雅黑", Font.BOLD, 20)));

        //获取第一个图例。就是图表最下面的那行
        LegendTitle legend = chart.getLegend(0);

        //设置第一个图例的属性
        legend.setItemFont(new Font("微软雅黑", Font.TRUETYPE_FONT, 14));

        //获得饼图的Plot
        PiePlot plot = (PiePlot) chart.getPlot();

        //设置Plot样式，也就是整个图表中间的部分的显示样式
        //这些操作只是为了美化，为了更细致的控制图表的样式
        plot.setLabelFont(new Font("微软雅黑", Font.TRUETYPE_FONT, 16));
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
        // 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
        plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
        plot.setLabelFont(new Font("微软雅黑", Font.TRUETYPE_FONT, 12));
        // 指定图片的透明度(0.0-1.0)
        plot.setForegroundAlpha(1.0f);
        // 指定显示的饼图上圆形(false)还椭圆形(true)
        plot.setCircular(false);
        // 设置第一个 饼块section 的开始位置，默认是12点钟方向
        plot.setStartAngle(90);
        // // 设置分饼颜色
        plot.setSectionPaint(pieKeys[0], new Color(127, 255, 170));
        plot.setSectionPaint(pieKeys[1], new Color(255, 64, 64));
        FileOutputStream fos_jpg = null;
        try {
            File file = new File(path);
            fos_jpg = new FileOutputStream(file);
            // 高宽的设置影响椭圆饼图的形状
            ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos_jpg.close();
                System.out.println("create pie-chart.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 饼状图 数据集
    public static PieDataset getDataPieSetByUtil(double[] data, String[] datadescription) {
        if (data != null && datadescription != null) {
            if (data.length == datadescription.length) {
                DefaultPieDataset dataset = new DefaultPieDataset();
                for (int i = 0; i < data.length; i++) {
                    dataset.setValue(datadescription[i], data[i]);
                }
                return dataset;
            }
        }
        return null;
    }


}
