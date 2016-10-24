package org.iiiedu.eeit88.health.memberrecord.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

@WebServlet("/MembersOnly/borkenline")
public class BorkenLineChartServlet extends HttpServlet {

	private static final long serialVersionUID = 1585397081043433662L;

	public BorkenLineChartServlet() {
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
//		String startDay = "2016/10/8";
//		String endDay = "2016/10/25";
//		String type = "absorb";
		
		// 獲得資料集對像
		CategoryDataset dataset = createDataset(memId, startDay, endDay, type);
		// 建立圖形對像
		JFreeChart jfreechart = ChartFactory.createLineChart("Calories Record",
				null, "calories", dataset, PlotOrientation.VERTICAL, false, true,
				false);
		// 設定圖表的子標題
		//jfreechart.addSubtitle(new TextTitle("按月份"));
		// 建立一個標題
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(new Date());
		TextTitle texttitle = new TextTitle("製表日期: " + date);
		// 設定標題字體
		texttitle.setFont(new Font("黑體", 0, 10));
		// 設定標題向下對齊
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// 設定標題向右對齊
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// 增加圖表的子標題
		jfreechart.addSubtitle(texttitle);
		// 設定圖表的背景色為白色
		jfreechart.setBackgroundPaint(Color.white);
		// 獲得圖表區域對像
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinesVisible(false);
		// 獲顯示線條對像
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		// 設定折線加粗
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		// 設定折線拐點
		lineandshaperenderer.setSeriesShape(0,
				new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
		
		// 將圖表已資料流的方式傳回給客戶端
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				800, 370);
	}
	
	/**
	 * 傳回資料集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset(int memId,String startDay,String endDay,String type) {
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		// 算天數
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

		// 取熱量資料
		if (type.equalsIgnoreCase("ABSORB")) {
			ShowAbsorbDataHistoryService service = new ShowAbsorbDataHistoryService();
			List<AbsorbChartBean> bean = service.chart(memId, startDay, endDay);  System.out.println("bean="+bean);
			Double data = null;
			for (int i = 0; i < bean.size(); i++) {
				// 取出卡洛里資料並將她轉成double(白癡一開始型態就要設成double啊)
				Float temp = bean.get(i).getCalories();
				data = Double.valueOf(temp);
				System.out.println(data);

				// 取得攝取日的"日"
				String[] a = bean.get(i).getDate().split("-");
				String b = a[2];
				int c = Integer.parseInt(b);// System.out.println(a);

				// 將資料塞進圖表裡
				for (int j = 1; j <= diff; j++) { // 使用者所選日期的範圍		
					defaultdataset.addValue(data, "absorb", c + "");//放"每天"攝取/消耗卡洛里的值
				}
			} // end of for 計算卡洛里筆數
		} else if (type.equalsIgnoreCase("CONSUME")) {
			System.out.println("AAA");
			ShowConsumeDataHistoryService service = new ShowConsumeDataHistoryService();
			List<ConsumeChartBean> bean = service.chart(memId, startDay, endDay); // System.out.println("bean="+bean);
			Double data = null;
			for (int i = 0; i < bean.size(); i++) {
				// 取出卡洛里資料並將她轉成double(白癡一開始型態就要設成double啊)
				Float temp = bean.get(i).getCalories();
				data = Double.valueOf(temp);
				System.out.println(data);

				// 取得攝取日的"日"
				String[] a = bean.get(i).getDate().split("-");  
				String b = a[2];
				int c = Integer.parseInt(b);// System.out.println(a);

				// 將資料塞進圖表裡
				for (int j = 1; j <= diff; j++) { // 使用者所選日期的範圍		
					defaultdataset.addValue(data, "consume", c + "");//放"每天"攝取/消耗卡洛里的值
				}
			} // end of for 計算卡洛里筆數
		}
		
		return defaultdataset;
	}

}
