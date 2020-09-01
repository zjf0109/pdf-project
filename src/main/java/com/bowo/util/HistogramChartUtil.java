package com.bowo.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

/**
 * @author zhaojufeng
 * @date 2020/8/28 10:36
 */
public class HistogramChartUtil {

    /**
     * 生成柱状图
     *
     * @param dataset    生成图形的数据
     * @param xName      x轴名称
     * @param yName      y轴名称
     * @param chartTitle 图形标题
     * @param path       生成文件的地址
     * @return
     */
    public static String createBarChart(CategoryDataset dataset, String xName,
                                        String yName, String chartTitle, String path) {

        JFreeChart chart = ChartFactory.createBarChart(chartTitle, // 图表标题
                xName, // 目录轴的显示标签
                yName, // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例(对于简单的柱状图必须是false
                false, // 是否生成工具
                false // 是否生成URL链接

        );
        // 设置图标题的字体重新设置title
        Font font = new Font("微软雅黑", Font.BOLD, 20);
        TextTitle title = new TextTitle(chartTitle);
        title.setFont(font);
        chart.setTitle(title);
        Font labelFont = new Font("微软雅黑", Font.TRUETYPE_FONT, 12);
        // 设置图表下方的图例说明字体
        chart.getLegend().setItemFont(new Font("微软雅黑", Font.BOLD, 12));
        chart.setTextAntiAlias(false);
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = chart.getCategoryPlot();
        // 设置横虚线可见
        plot.setRangeGridlinesVisible(true);
        // 虚线色彩
        plot.setRangeGridlinePaint(Color.gray);
        // 数据轴精度
        NumberAxis vn = (NumberAxis) plot.getRangeAxis();
        DecimalFormat df = new DecimalFormat("#0.00");
        vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式
        // x轴设置
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(labelFont);// 轴标题
        domainAxis.setTickLabelFont(labelFont);// 轴数值
        // Lable（Math.PI/3.0）度倾斜
        // domainAxis.setCategoryLabelPositions(CategoryLabelPositions
        // .createUpRotationLabelPositions(Math.PI / 3.0));
        domainAxis.setMaximumCategoryLabelWidthRatio(0.6f);// 横轴上的 Lable 是否完整显示
        // 设置距离图片左端距离
        domainAxis.setLowerMargin(0.1);
        // 设置距离图片右端距离
        domainAxis.setUpperMargin(0.1);
        // 设置 columnKey 是否间隔显示
        // domainAxis.setSkipCategoryLabelsToFit(true);
        plot.setDomainAxis(domainAxis);
        // 设置柱图背景色（注意，系统取色的时候要使用16位的模式来查看颜色编码，这样比较准确）
        plot.setBackgroundPaint(new Color(255, 255, 255));
        // y轴设置
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(labelFont);
        rangeAxis.setTickLabelFont(labelFont);
        // 设置最高的一个 Item 与图片顶端的距离
        rangeAxis.setUpperMargin(0.15);
        // 设置最低的一个 Item 与图片底端的距离
        rangeAxis.setLowerMargin(0.15);
        plot.setRangeAxis(rangeAxis);
        BarRenderer renderer = new BarRenderer();
        // 设置柱子宽度
        renderer.setMaximumBarWidth(0.05);
        // 设置柱子高度
        renderer.setMinimumBarLength(0.2);
        // 设置柱子边框颜色
        renderer.setBaseOutlinePaint(Color.BLACK);
        // 设置柱子边框可见
        renderer.setDrawBarOutline(true);
        //设置柱的颜色
        renderer.setSeriesPaint(0, new Color(255, 93, 88));
        renderer.setSeriesPaint(1, new Color(255, 237, 54));
        renderer.setSeriesPaint(2, new Color(131, 182, 204));
        //设置每个地区所包含的平行柱的之间距离
        renderer.setItemMargin(0.0);
        //显示每个柱的数值，并修改该数值的字体属性
        renderer.setIncludeBaseInRange(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        plot.setRenderer(renderer);
        // 设置柱的透明度
        plot.setForegroundAlpha(1.0f);
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            outputStream = new FileOutputStream(file);
            ChartUtilities.writeChartAsPNG(outputStream, chart, 500, 530, true, 10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    /**
     * 判断文件夹是否存在，如果不存在则新建
     *
     * @param chartPath
     */

    private static void isChartPathExist(String chartPath) {
        File file = new File(chartPath);
        if (!file.exists()) {
            file.mkdirs();

        }
    }

    public static CategoryDataset getBarData(double[][] data, String[] rowKeys,

                                             String[] columnKeys) {
        return DatasetUtilities
                .createCategoryDataset(rowKeys, columnKeys, data);

    }
}
