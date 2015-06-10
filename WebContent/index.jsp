<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加票号</title>
<script type="text/javascript">
  
	function createXmlHttp() {
	    var xmlHttp = null;
	     
	    try {
	        xmlHttp = new XMLHttpRequest();
	    } catch (e) {
	        try {
	            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	        } catch (e) {
	            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	    }
	    return xmlHttp;
	}
	 
	function submitForm() {
	    var xmlHttp = createXmlHttp();
	    if(!xmlHttp) {
	        alert("您的浏览器不支持AJAX！");
	        return 0;
	    }
	    
	    var url = 'addNo';
	    var postData = "";
	    postData = "no=" + document.getElementById('no').value;
	    postData += "&t=" + Math.random();
	    
	    xmlHttp.open("POST", url, true);
	    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xmlHttp.onreadystatechange = function() {
	        if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
	        	 str = xmlHttp.responseText;
			  	 if(str==-1){
			  		 alert('怡馨苑温泉会馆友情提示:您的票号已经使用过');
			  	 }else if(str==1){
			  		 alert('怡馨苑温泉会馆友情提示:票号已记录数据库中');
			  	 }else if(str==-2){
			  		 alert('输入票号错误');
			  	 }
				 window.location.reload(true);			  	 
	        }
	    }
	    xmlHttp.send(postData);
	}
	
</script>
</head>
<body>
    <div style="text-align:center;margin:200px auto;width:400px;height:200px;background:#f36;">
	    <label><strong style="font-size:25px;">输入票号</strong></label>
	    </br>
		<input type="text" style="font-size:18px;font-weight:bold;" id="no" name="no"/>
		<input type="button" value="提交" onClick="submitForm()"/>
	</div>	
</body>
</html>