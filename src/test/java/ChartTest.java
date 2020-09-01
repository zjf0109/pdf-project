import com.bowo.pojo.Serie;
import com.bowo.util.ChartUtils;
import com.bowo.util.HistogramChartUtil;
import com.bowo.util.PieChartUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import java.awt.*;
import java.util.Vector;

/**
 * @author zhaojufeng
 * @date 2020/8/28 9:52
 */
public class ChartTest {

    @Test
    public void test() throws Exception {
        // 标注类别
        String[] categories = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021" };
        Vector<Serie> series = new Vector<Serie>();
        // 柱子名称：柱子所有的值集合
        series.add(new Serie("", new Double[] { 49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 }));
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
        ChartUtils.saveAsFile(chart, "D:\\下载\\折线图.png", 800, 400);
    }

    /**
     * 饼图
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        PieChartUtil pieChartUtil = new PieChartUtil();
        double[] data = {9, 91};

        String[] keys = {"失败率", "成功率"};
        pieChartUtil.createValidityComparePimChar(pieChartUtil.getDataPieSetByUtil(data, keys), "在线率", "在线率.png", keys);
    }


    /**
     * 柱状图
     */
    @Test
    public void test3() {
        double[][] data = new double[][]{{672, 766, 223, 540, 126}};

        String[] rowKeys = {""};

        String[] columnKeys = {"北京", "上海", "广州", "成都", "深圳"};

        HistogramChartUtil.createBarChart(HistogramChartUtil.getBarData(data, rowKeys, columnKeys),"","","总出水量(m)","柱状图.png");
    }

}
