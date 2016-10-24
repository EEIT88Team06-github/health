package org.iiiedu.eeit88.health.memberrecord.controller;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.food.model.AbsorbChartBean;
import org.iiiedu.eeit88.health.memberrecord.service.ShowAbsorbDataHistoryService;
import org.iiiedu.eeit88.health.memberrecord.service.ShowConsumeDataHistoryService;
import org.iiiedu.eeit88.health.sport.model.ConsumeChartBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@WebServlet("/MembersOnly/linechart")
public class LineChartServlet extends HttpServlet {

	private static final long serialVersionUID = 935480272440185396L;

	public LineChartServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 設定傳回類型為圖片
		response.setContentType("image/png");
		
		String tempMemId = request.getParameter("memId");
		int memId = Integer.parseInt(tempMemId);
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		String type = request.getParameter("type");
//		int memId=1;
//		String startDay = "2016/10/1";
//		String endDay = "2016/10/15";
//		String type = "absorb";
		
		// 獲得資料集對像
		IntervalXYDataset dataset = createDataset(memId, startDay, endDay, type);
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createXYBarChart("Calories Record", null,
				false, "calories", dataset, PlotOrientation.VERTICAL, true, false,
				false);
		// 設定背景為白色
		jfreechart.setBackgroundPaint(Color.white);
		// 獲得圖表區域對像
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		// 設定區域對像背景為灰色
		xyplot.setBackgroundPaint(Color.lightGray);
		// 設定區域對像網格線調為白色
		xyplot.setDomainGridlinePaint(Color.white);
		xyplot.setRangeGridlinePaint(Color.white);
		// 獲顯示圖形對像
		XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer();
		// 設定不顯示邊框線
		xybarrenderer.setDrawBarOutline(false);

		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				500, 270);
	}

	/**
	 * 傳回資料集
	 * 
	 * @return
	 */
	private static IntervalXYDataset createDataset(int memId,String startDay,String endDay,String type) {
		// 建立基本資料
		XYSeries xyseries = new XYSeries("date");
		
		//算天數
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    long diff = 0;
	    long start = 0;
		long end = 0;
		try {
			start = sdf.parse(startDay).getTime();
			end = sdf.parse(endDay).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    diff = (end - start) / (24 * 60 * 60 * 1000);
		
		

		//取熱量資料
		if(type.equalsIgnoreCase("ABSORB")){
			ShowAbsorbDataHistoryService service = new ShowAbsorbDataHistoryService();
			List<AbsorbChartBean> bean = service.chart(memId, startDay, endDay);  //System.out.println("bean="+bean);
			Double data = null;
			for(int i=0;i<bean.size();i++){
				//取出卡洛里資料並將她轉成double(白癡一開始型態就要設成double啊)
				Float temp = bean.get(i).getCalories();
				data = Double.valueOf(temp);
				System.out.println(data);
				
			    //取得攝取日的"日"
			    String[] a = bean.get(i).getDate().split("-");
			    String b = a[2];
			    int c = Integer.parseInt(b);//System.out.println(a);
			    
			    //將資料塞進圖表裡
				for (int j = 1; j <= diff; j++) {  //使用者所選日期的範圍	
						xyseries.add(c,data);  //放"每天"攝取/消耗卡洛里的值
				}
			}  //end of for 計算卡洛里筆數
		}else if(type.equalsIgnoreCase("CONSUME")){
			ShowConsumeDataHistoryService service = new ShowConsumeDataHistoryService();
			List<ConsumeChartBean> bean = service.chart(memId, startDay, endDay);  //System.out.println("bean="+bean);
			Double data = null;
			for(int i=0;i<bean.size();i++){
				//取出卡洛里資料並將她轉成double(白癡一開始型態就要設成double啊)
				Float temp = bean.get(i).getCalories();
				data = Double.valueOf(temp);
				System.out.println(data);
				
			    //取得攝取日的"日"
			    String[] a = bean.get(i).getDate().split("-");
			    String b = a[2];
			    int c = Integer.parseInt(b);//System.out.println(a);
			    
			    //將資料塞進圖表裡
				for (int j = 1; j <= diff; j++) {  //使用者所選日期的範圍	
						xyseries.add(c,data);  //放"每天"攝取/消耗卡洛里的值
				}
			}  //end of for 計算卡洛里筆數
		}
	    
	    
		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		xyseriescollection.addSeries(xyseries);
		return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
	}
}
