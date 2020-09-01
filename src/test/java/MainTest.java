import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author zhaojufeng
 * @date 2020/8/31 11:31
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        JFreeChart chart = ChartFactory.createPieChart("某公司组织结构2D饼图",	getDataset(), true, false, false);

        //设置图表的标题
        chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD, 24)));

        //获取第一个图例。就是图表最下面的那行
        LegendTitle legend = chart.getLegend(0);

        //设置第一个图例的属性
        legend.setItemFont(new Font("微软雅黑", Font.BOLD, 14));

        //获得饼图的Plot
        PiePlot plot = (PiePlot) chart.getPlot();

        //设置Plot样式，也就是整个图表中间的部分的显示样式
        //这些操作只是为了美化，为了更细致的控制图表的样式
        plot.setLabelFont(new Font("隶书", Font.BOLD, 16));

        //JFreeChart只支持两种格式的图片：PNG和JPEG/JPG
        //由于是要将生成的图片写到硬盘上，所以就需要用到输出流
        //而且生成的图片的本身就是一个文件，因此使用文件输出流
        File file=new File("D:/下载/test.png");
        OutputStream os = new FileOutputStream(file);

        //将JFreeChart对象写到文件输出流中
        //这中间是一个很复杂的过程，但是JFreeChart为我们提供了ChartUtilities类
        //帮助我们大大简化了工作量，并且生成的图片会自动保存在Web应用的根目录下
        ChartUtilities.writeChartAsJPEG(os, chart, 1024, 768);

        //关闭输出流
        os.close();
    }

    /**
     * 创建饼图数据集的方法
     */
    private static DefaultPieDataset getDataset() {
        DefaultPieDataset dpd = new DefaultPieDataset();
        dpd.setValue("管理人员", 25);
        dpd.setValue("市场人员", 25);
        return dpd;
    }
}
