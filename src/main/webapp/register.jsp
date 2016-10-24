<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="bootstrap/js/jquery-3.1.0.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>
<script src="/addr/AddressSelectList.min.js"></script>
<link rel="stylesheet" type="text/css" href="spiffyCal/spiffyCal_v2_1.css">
    <script type="text/javascript" src="spiffyCal/spiffyCal_v2_1.js"></script>
    <script type="text/javascript">
    (function(current){var app=current.AddressSeleclList={AdrressArray:[['台北市','中正區','大同區','中山區','松山區','大安區','萬華區','信義區','士林區','北投區','內湖區','南港區','文山區'],['新北市','萬里區','金山區','板橋區','汐止區','深坑區','石碇區','瑞芳區','平溪區','雙溪區','貢寮區','新店區','坪林區','烏來區','永和區','中和區','土城區','三峽鎮','樹林區','鶯歌區','三重區','新莊區','泰山區','林口區','蘆洲區','五股區','新莊區','八里區','淡水區','三芝區','石門區'],['台中區','中區','東區','南區','西區','北區','北屯區','西屯區','南屯區'],['台中縣','太平區','大里區','霧峰鄉','烏日鄉','豐原區','后里鄉','石岡鄉','東勢鎮','和平鄉','新社鄉','潭子鄉','大雅鄉','神岡鄉','大肚鄉','沙鹿鎮','龍井鄉','梧棲鎮','清水鎮','大甲鎮','外埔鄉','大安鄉'],['台東縣','台東區','綠島鄉','蘭嶼鄉','延平鄉','卑南鄉','鹿野鄉','關山鎮','海端鄉','池上鄉','東河鄉','成功鎮','長濱鄉','太麻里鄉','金峰鄉','大武鄉','達仁鄉'],['台南區','中西區','東區','南區','北區','安平區','安南區'],['台南縣','永康區','歸仁鄉','新化鎮','左鎮鄉','玉井鄉','楠西鄉','南化鄉','仁德鄉','關廟鄉','龍崎鄉','官田鄉','麻豆鎮','佳里鎮','西港鄉','七股鄉','將軍鄉','學甲鎮','北門鄉','新營區','後壁鄉','白河鎮','東山鄉','六甲鄉','下營鄉','柳營鄉','鹽水鎮','善化鎮','新區鄉','大內鄉','山上鄉','新區鄉','安定鄉'],['宜蘭縣','宜蘭區','頭城鎮','礁溪鄉','壯圍鄉','員山鄉','羅東鎮','三星鄉','大同鄉','五結鄉','冬山鄉','蘇澳鎮','南澳鄉','釣魚台'],['花蓮縣','花蓮區','新城鄉','秀林鄉','吉安鄉','壽豐鄉','鳳林鎮','976光復鄉','977豐濱鄉','978瑞穗鄉','979萬榮鄉','981玉里鎮','982卓溪鄉','983富里鄉'],['金門縣','890金沙鎮','891金湖鎮','892金寧鄉','893金城鎮','894烈嶼鄉','896烏坵鄉'],['南投縣','540南投區','541中寮鄉','542草屯鎮','544國姓鄉','545埔里鎮','546仁愛鄉','551名間鄉','552集集鎮','553水里鄉','555魚池鄉','556信義鄉','557竹山鎮','558鹿谷鄉'],['南海島','817東沙群島','819南沙群島'],['屏東縣','900屏東區','901三地門鄉','902霧台鄉','903瑪家鄉','904九如鄉','905里港鄉','906高樹鄉','907鹽埔鄉','908長治鄉','909麟洛鄉','911竹田鄉','912內埔鄉','913萬丹鄉','920潮州鎮','921泰武鄉','922來義鄉','923萬巒鄉','924崁頂鄉','925新埤鄉','926南州鄉','927林邊鄉','928東港鎮','929琉球鄉','931佳冬鄉','932新園鄉','940枋寮鄉','941枋山鄉','942春日鄉','943獅子鄉','944車城鄉','945牡丹鄉','946恆春鎮','947滿州鄉'],['苗栗縣','350竹南鎮','351頭份鎮','352三灣鄉','353南庄鄉','354獅潭鄉','356後龍鎮','357通霄鎮','358苑裡鎮','360苗栗區','361造橋鄉','362頭屋鄉','363公館鄉','364大湖鄉','365泰安鄉','366銅鑼鄉','367三義鄉','368西湖鄉','369卓蘭鎮'],['桃園縣','320中壢區','324平鎮區','325龍潭鄉','326楊梅鎮','327新屋鄉','328觀音鄉','330桃園區','333龜山鄉','334八德區','335大溪鎮','336復興鄉','337大園鄉','338蘆竹鄉'],['高雄區','800新興區','801前金區','802苓雅區','803鹽埕區','804鼓山區','805旗津區','806前鎮區','807三民區','811楠梓區','812小港區','813左營區','817東沙群島','819南沙群島'],['高雄縣','814仁武鄉','815大社鄉','820岡山鎮','821路竹鄉','822阿蓮鄉','823田寮鄉','824燕巢鄉','825橋頭鄉','826梓官鄉','827彌陀鄉','828永安鄉','829湖內鄉','830鳳山區','831大寮鄉','832林園鄉','833鳥松鄉','840大樹鄉','842旗山鎮','843美濃鎮','844六龜鄉','845內門鄉','846杉林鄉','847甲仙鄉','848桃源鄉','849那瑪夏鄉','851茂林鄉','852茄萣鄉'],['基隆區','200仁愛區','201信義區','202中正區','203中山區','204安樂區','205暖暖區','206七堵區'],['連江縣','209南竿鄉','210北竿鄉','211莒光鄉','212東引鄉'],['釣魚台','290釣魚台'],['雲林縣','630斗南鎮','631大埤鄉','632虎尾鎮','633土庫鎮','634褒忠鄉','635東勢鄉','636台西鄉','637崙背鄉','638麥寮鄉','640斗六區','643林內鄉','646古坑鄉','647莿桐鄉','648西螺鎮','649二崙鄉','651北港鎮','652水林鄉','653口湖鄉','654四湖鄉','655元長鄉'],['新竹區','300北區','300東區','300香山區'],['新竹縣','300寶山鄉','302竹北區','303湖口鄉','304新豐鄉','305新埔鎮','306關西鎮','307芎林鄉','308寶山鄉','310竹東鎮','311五峰鄉','312橫山鄉','313尖石鄉','314北埔鄉','315峨眉鄉'],['嘉義區','600西區','600東區'],['嘉義縣','602番路鄉','603梅山鄉','604竹崎鄉','605阿里山鄉','606中埔鄉','607大埔鄉','608水上鄉','611鹿草鄉','612太保區','613朴子區','614東石鄉','615六腳鄉','616新港鄉','621民雄鄉','622大林鎮','623溪口鄉','624義竹鄉','625布袋鎮'],['彰化縣','500彰化區','502芬園鄉','503花壇鄉','504秀水鄉','505鹿港鎮','506福興鄉','507線西鄉','508和美鎮','509伸港鄉','510員林鎮','511社頭鄉','512永靖鄉','513埔心鄉','514溪湖鎮','515大村鄉','516埔鹽鄉','520田中鎮','521北斗鎮','522田尾鄉','523埤頭鄉','524溪州鄉','525竹塘鄉','526二林鎮','527大城鄉','528芳苑鄉','530二水鄉'],['澎湖縣','880馬公區','881西嶼鄉','882望安鄉','883七美鄉','884白沙鄉','885湖西鄉']],defaultOptionCityText:'請選擇縣區',defaultOptionCityValue:'',defaultOptionAreaText:'請選擇鄉鎮',defaultOptionAreaValue:'',Initialize:function(city,area,defaultCityText,defaultCityValue,defaultAreaText,defaultAreaValue){var cityText=defaultCityText?defaultCityText:this.defaultOptionCityText;var cityValue=defaultAreaValue?defaultAreaValue:this.defaultOptionCityValue;var areaText=defaultAreaText?defaultAreaText:this.defaultOptionAreaText;var areaValue=defaultAreaValue?defaultAreaValue:this.defaultOptionAreaValue;var citySelect=document.getElementById(city);var areaSelect=document.getElementById(area);citySelect.options[0]=new Option(cityText,cityValue);areaSelect.options[0]=new Option(areaText,areaValue);for(var i=0;i<this.AdrressArray.length;i++){citySelect.options[i+1]=new Option(this.AdrressArray[i][0],this.AdrressArray[i][0]);}citySelect.addEventListener?citySelect.addEventListener('change',function(e){app.AppendArea(e,areaSelect,areaText,areaValue)},false):citySelect.attachEvent('onchange',function(e){app.AppendArea(e,areaSelect,areaText,areaValue)});},AppendArea:function(e,AreaSelect,areaText,areaValue){var target=e.target?e.target:e.srcElement;if(target.selectedIndex==0){AreaSelect.options.length=0;AreaSelect.options[0]=new Option(areaText,areaValue);return;}AreaSelect.options.length=this.AdrressArray[target.selectedIndex-1].length-1;for(var i=1;i<this.AdrressArray[target.selectedIndex-1].length;i++){AreaSelect.options[i-1]=new Option(this.AdrressArray[target.selectedIndex-1][i],this.AdrressArray[target.selectedIndex-1][i]);}},ReturnSelectAddress:function(city,area){var city=document.getElementById(city);var area=document.getElementById(area);return city.value+area.value;}};})(window);
    	window.onload = function () {
        	//當頁面載完之後，用AddressSeleclList.Initialize()，
       	 	//傳入要綁定的縣市下拉選單ID及鄉鎮市區下拉選單ID
        	AddressSeleclList.Initialize('city', 'town');

   		}


   function show() {
        //取出指定縣市及鄉鎮市區的下拉選單的值
        alert(AddressSeleclList.ReturnSelectAddress('縣市1', '鄉鎮市區1'));
    }
    	//月曆
      	var dateAvailable = new ctlSpiffyCalendarBox("dateAvailable", "registerForm", "birth","btnDate1","");
      	//照片上傳
    	var openFile = function(event) {
      	    var input = event.target;

      	    var reader = new FileReader();
      	    reader.onload = function(){
      	      var dataURL = reader.result;
      	      var output = document.getElementById('output');
      	      output.src = dataURL;
      	    };
      	    reader.readAsDataURL(input.files[0]);
      	  };
    </script>  
</head>
<body>
		
<jsp:include page="/global/default.jsp" />
		<div id="spiffycalendar" class="text"></div>
		<div id="wrapper" align="center">
			<form ENCTYPE="multipart/form-data" method="POST" action="<c:url value='register.do' />"  id="register.do" name="registerForm">
			<table  width="80%" cellspacing="0" bgColor='#90ee90'>
					<tr><!-- 帳密資料 -->
						<td align="center" width="45%">
							<div align="right" style="width: 90%">帳密資料</div>
							     
						</td>
						<td width="70%">
							<table width="100%">
								<tr>
									<td width="20%">
										帳號
									</td>
									<td >
										<input type="text" id="account" name="account" value="">
									</td>
								</tr>
								<tr>
									<td >
										密碼
									</td>
									<td>
										<input type="text" id="password" name="password" value="${param.password}">
									</td>
								</tr>
								<tr>
									<td >
										再次確認密碼
									</td>
									<td>
										<input type="text" id="password2" name="password2"  value="${param.checkPassword}">
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
					<tr><!-- 個人資料 -->
						<td align="center" >
							<div align="right" style="width: 90%">個人資料</div>
							     
						</td>
						<td>
							<table width="100%">
								<tr >
									<td width="20%">
										姓氏/名字
									</td>
									<td>
										<input type="text" id="lastname" name="lastname" value="${param.lastname}"> \ <input type="text" id="firstname" name = "firstname" value="${param.firstname}">
										
									</td>
								</tr>
								<tr>
									<td>
										暱稱
									</td>
									<td>
										<input type="text" name="nickname" id="nickname" value="${param.nickname}">
									</td>
								</tr>
								<tr>
									<td>性別</td>
									<td>
										<select name="gender">  
											<option value="男">男</option>  
											<option value="女">女</option>  
										</select>
									</td>
								<tr class="dataTableRow">
									<td>
										出生年月日
									</td>
									 <td align="left">&nbsp;
									 	<script type="text/javascript">
									 		dateAvailable.writeControl(); 
									 		dateAvailable.dateFormat="yyyy-MM-dd";
									 	</script> 
									 </td>
   				

								</tr>
								<tr>
									<td>
										聯絡電話
									</td>
									<td>
										<input type="text" id="phone" name="phone" value="${param.phone}">
									</td>
								</tr>
								<tr>
									<td>
										聯絡地址
									</td>
									<td>
									 <select id="city" name="city" >
    								</select>
    								<select id="town" name="county"></select>
    								<input type="text" id="addr" name="addr" />
									</td>
								</tr>
								<tr>
									<td>
										
									</td>
									<td>
										<!-- 地址 -->
										
									</td>
								</tr>
								<tr>
									<td>
										E-mail
									</td>
									<td>
										<input type="text" id="email" name="email" value="${param.email}">
									</td>
								</tr>
								<tr>
									<td>
										身高
									</td>
									<td>
										<input type="text" id="height" name="height"  value="${param.height}">
									</td>
								</tr>
								<tr>
									<td>
										體重
									</td>
									<td>
										<input type="text" id="weights" name="weights"  value="${param.weight}">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="radio"> 是否參於配對
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><!-- 帳密資料 -->
						<td align="center" >
							<div align="right" style="width: 90%">興趣填寫</div>
							     
						</td>
						<td>
							<table width="50%">
								<tr>
									<td width="50%">
										<input type="checkbox" name="inter1" value="1"> 慢跑
									</td>
									<td width="50%">
										<input type="checkbox"  name="inter2" value="2"> 游泳
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox"  name="inter3" value="3"> 瑜珈
									</td>
									<td>
										<input type="checkbox"  name="inter4" value="4"> 羽毛球
									</td>
								</tr>
								<tr>
									<td>
										<input type="checkbox"  name="inter5" value="5"> 爬 山
									</td>
									<td>
										<input type="checkbox"  name="inter6" value="6"> 籃 球
									</td>
								</tr>
								<tr>
									<td >
										<input type="checkbox"  name="inter7" value="7"> 網 球
									</td>
									<td>
										<input type="checkbox"  name="inter8" value="8"> 攀 岩
									</td>
								</tr>
								<tr>
									<td >
										<input type="checkbox"  name="inter9" value="9"> 散 步
									</td>
									<td>
										<input type="checkbox"  name="inter10" value="10"> 自行車
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr >
						<td align="center" >
							<div align="right" style="width: 90%">上傳照片</div>
							     
						</td>
						<td>
							
								<table>
									<tr>
										<td>
											<input type='file' name="pic" accept='image/*' onchange='openFile(event)'>
										</td>
									</tr>
									<tr>
										<td>
											<img id='output'  width="300px" height="300px">
										</td>
									</tr>
								</table>
								
							
						</td>
						<td>
							
							
						</td>
					</tr>
			</table>
			<div align="center" style="margin-top: 20px">
				<input type="submit" name="submit" id="submit" value="儲存"/>
         		<input type="reset" name="cancel" id="cancel" value="重填">
			</div>	
			</form>

		</div>
		
		
<jsp:include page="/global/default_bottom.jsp" />		

</body>
</html>