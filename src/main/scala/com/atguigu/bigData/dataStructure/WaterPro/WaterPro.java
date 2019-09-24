package com.atguigu.bigData.dataStructure.WaterPro;

import javafx.scene.chart.BarChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DatasetUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class WaterPro {
    public static void main(String[] args) {
        double[][] arr=new double[2][8];
        arr[0]=new double[]{ 2., 5., 1., 2., 3., 5., 7., 2. };
        arr[1]=new double[]{ 0., 0., 4., 3., 2., 0.,0., 0. };
//        ArrayList arrayList = GetArea(arr[0]);
//        String[] rowKeys = { "墙", "水" };
//        for (int i = 0; i < ints.length/2; i++) {
//            double tmp=ints[i];
//            ints[i]=ints[ints.length-1];
//            ints[ints.length-1]=tmp;
//        }
//        Object[] array =arrayList.toArray();
//        for (int i = 0; i < array.length/2; i++) {
//            Object tmp=array[i];
//            array[i]=array[array.length-1];
//            array[array.length-1]=tmp;
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(Double.parseDouble(array[i].toString()));
//        }
//        double[] doubles = GetArea(arr[0]);
//        for (int i = 0; i < doubles.length; i++) {
//            System.out.println(doubles[i]);
//        }
//        System.out.println(GetArea(arr));
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


//        JFreeChart chart = ChartFactory.createBarChart("water", "横坐标", "纵坐标", dataset);
//
//        CategoryPlot plot = chart.getCategoryPlot();
//        CategoryAxis domainAxis=plot.getDomainAxis();
//        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));//设置X轴的标题的字体
//        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));//设置X轴坐标上的字体
//        //-----------------------------------------获取Y轴
//        ValueAxis rangeAxis=plot.getRangeAxis();
//        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));//设置Y轴坐标上的标题字体
//        //设置图样的文字样式
//        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD ,15));
//        //设置图形的标题
//        chart.getTitle().setFont(new Font("宋体",Font.BOLD ,20));
//
//        ChartPanel chartPanel = new ChartPanel(chart, true);//将已经画好的图形报表存放到面板中
//
        new DemoFrame(arr);
//        new MyFrame55("MyFrame");
    }



    public static double[] GetArea(double[] arr){
        int result=0;
//        HashMap hashMap = new HashMap();
        double[] rerr=new double[arr.length];
//        ArrayList arrayList = new ArrayList();
        int n=0;
        boolean all=false;
        String str="";
        for (int i=1;i<arr.length-1;i++){
            int j=i+1;
            int k=i-1;
            boolean find1=false;
            boolean find2=false;

            while (j<arr.length){
                if(arr[i]<=arr[j]){
                    find1=true;
                    break;
                }
                j++;
            }

            while (k>=0){
                if(arr[i]<=arr[k]){
                    find2=true;
                    break;
                }
                k--;
            }
            if(find1&&find2) {
//                hashMap.put(k,new HashMap(Math.min(arr[k],arr[j]),j));

//                result += (j - k-1) * (Math.min(arr[j], arr[k]) - arr[i]);
//                arrayList.add((j - k-1) * (Math.min(arr[j], arr[k]) - arr[i]));
                rerr[i]=(j - k-1) * (Math.min(arr[j], arr[k]) - arr[i]);
                n++;
            }
        }

        return rerr ;
    }
}

class Bar{
    Double[][] arr;
//    DefaultCategoryDataset dataset;
    JFreeChart chart;
    ChartPanel chartPanel;
//    private  void getDataset(){
//        dataset = new DefaultCategoryDataset();
//        for (int i = 0; i < arr.length; i++) {
//            dataset.addValue(new Double(arr[i]),"数组",new Integer(i+1));
//        }
//    }
    public CategoryDataset getBarData(double[][] data, String[] rowKeys,
                                  String[] columnKeys) {
        return DatasetUtilities
                .createCategoryDataset(rowKeys, columnKeys, data);
    }
    public Bar(double[][] arr){
        String[] rowKeys =new String[] {"墙","水"};

        String[] colume=new String[]{ "1", "2","3","4","5","6","7","8" };
        CategoryDataset barData = getBarData(arr, rowKeys, colume);
//        this.arr=arr;
//        getDataset();
//        CategoryDataset categoryDataset = DatasetUtilities.createCategoryDataset(rowKeys,colume,arr);
        chart = ChartFactory.createStackedBarChart("图标", // 图表标题
                "数组", // 目录轴的显示标签
                "数据", // 数值轴的显示标签
                barData, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例(对于简单的柱状图必须是false)
                false, // 是否生成工具
                false // 是否生成URL链接
        );
//        chart = ChartFactory.createStackedBarChart("water", "横坐标", "纵坐标", this.dataset);
//        chart.
//        BarRenderer renderer = new BarRenderer();
//        renderer.setItemMargin(0);
//        chart.setRender;
        CategoryPlot plot = chart.getCategoryPlot();
//        DecimalFormat df = new DecimalFormat("0.00%");
//        plot.setm
//        plot.setRenderer(renderer);
//        plot.setDomainAxis(AxisLocation.TOP_OR_RIGHT);

        StackedBarRenderer renderer = new StackedBarRenderer();
        renderer.setSeriesPaint(0, new Color(204, 255, 204));
        renderer.setSeriesPaint(1, new Color(255, 204, 153));
        plot.setRenderer(renderer);

        CategoryAxis domainAxis=plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));//设置X轴的标题的字体
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));//设置X轴坐标上的字体
        domainAxis.setCategoryMargin(0);
        //-----------------------------------------获取Y轴
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));//设置Y轴坐标上的标题字体
        //设置图样的文字样式
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD ,15));
        //设置图形的标题
        chart.getTitle().setFont(new Font("宋体",Font.BOLD ,20));

        chartPanel = new ChartPanel(chart, true);//将已经画好的图形报表存放到面板中
//        chartPanel.setMa

    }


    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}

class DemoFrame extends JFrame {

    //在构造方法中初始化窗体
    public DemoFrame(double[][] arr ) {
        //----------------------设置窗体大小
        this.setSize(800, 600);
        //---------------------------将报表面板添加到窗体中
        this.add(new Bar(arr).getChartPanel());
        //----------------------设置窗体大小不可变
        this.setResizable(false);
//        this.setItem
        //----------------------设置窗体相对于屏幕居中
        this.setLocationRelativeTo(null);
        //------------------------设置窗体可见
        this.setVisible(true);
    }
}




class MyFrame55 extends Frame {
    MyFrame55(String s){
        super(s);
        setLayout(null);
        setBounds(300,300,400,300);
        this.setBackground(new Color(204,204,255));
        setVisible(true);

        /*this.addWindowListener(new MywindowMonitor());*/

        /*匿名内部类，出了括号没人认识了，适用于方法逻辑简单，语句比较少，而且不经常变动的类*/
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                setVisible(false);
                System.exit(-1);
            }
        });
    }
//    /*内部类，只有这个类认识，出了这个类就不认识了*/
//    class MywindowMonitor extends WindowAdapter{
//        public void windowClosing(WindowEvent e){
//            setVisible(false);
//            System.exit(0);
//        }
//    }
}

