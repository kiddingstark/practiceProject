var Views = [];

var _default_options = {
	type: "GET",
    url: "/",
    cache: false,
    async: false,
    data: {},
    processData: true,
    contentType: "application/xml",
    dataType: "xml"
};

var mergeOptions = function(destOpt, srcOpt) {
    for (var name in srcOpt) {
        if (typeof srcOpt[name] == 'object') {
            destOpt[name] = ((srcOpt[name] && srcOpt[name].constructor == Array) ? [] : (!!destOpt[name] ? destOpt[name] : {}));
            typeof destOpt[name] == 'object' && mergeOptions(destOpt[name], srcOpt[name]);
        } else 
            destOpt[name] = srcOpt[name];
    }
};

var setFolderPath = function(callback){
	try{
		var Message = "请选择文件夹"; 
		var Shell = new ActiveXObject( "Shell.Application" );
		var Folder = Shell.BrowseForFolder(0,Message,0x0040,0x11);
		if(Folder != null){
			Folder = Folder.items(); 
			Folder = Folder.item(); 
			Folder = Folder.Path; 
			if(Folder.charAt(Folder.length-1) != "\\"){
				Folder = Folder + "\\";
			}
			return Folder;
		}
	}catch(e){
		if(!!callback){
			callback.apply(this);
		}
	}
};


var getXMLData = window.getXMLData = function (options) {
	var returnXML = null;
	var _options = {};
	if(!!options){
		mergeOptions(_options, _default_options);
		mergeOptions(_options, options);
		
		$.ajax({
			type: _options.type,
	        url: _options.url,
	        cache: _options.cache,
	        async: _options.async,
	        data: _options.data,
	        processData: _options.processData,
	        contentType: _options.contentType,
	        dataType: _options.dataType,
	        success: function(xmlData){
				if (!!xmlData) {
					returnXML = xmlData;
				}
	        }
	    });
	}
	return returnXML;
};

var getJSONData = window.getJSONData = function (options) {
	var returnXML = null;
	var _options = {};
	if(!!options){
		mergeOptions(_options, _default_options);
		mergeOptions(_options, options);
		contentType = options.contentType ? options.contentType : (!!options.type && options.type.toUpperCase() == "POST") ? "application/x-www-form-urlencoded;charset=UTF-8" : "text/json;charset=UTF-8";
		$.ajax({
			type: _options.type,
	        url: _options.url,
	        cache: _options.cache,
	        async: _options.async,
	        data: _options.data,
	        processData: _options.processData,
	        contentType: contentType,
	        dataType: "json",
	        success: function(xmlData){
				if (!!xmlData) {
					returnXML = xmlData;
					if (!!options.callback && isFunction(options.callback)) {
						options.callback(xmlData);
					}
				}
	        }
	    });
	}
	return returnXML;
};

var isFunction = function(fn) {
    return !!fn && typeof fn != "string" && !fn.nodeName &&
    fn.constructor != Array &&
    /^[\s[]?function/.test(fn + "");
};


//打开模态窗口，并且可以传入回调函数
function showWin(url, callBack, opt){
	var ret;
	if(navigator.userAgent.indexOf("Chrome") > 0){		
		//获得窗口的垂直位置 
		var iTop = (window.screen.availHeight - 30 - 600) / 2; 
		//获得窗口的水平位置 
		var iLeft = (window.screen.availWidth - 10 - 1000) / 2; 
		var winOption = "width=1000,height=600,top="+iTop+",left="+iLeft;
		ret = window.open(url+"&temp="+Math.random(), "_blank", winOption);		
	}else{
		ret = window.showModalDialog(url, "", "dialogWidth:1000px;dialogHeight:600px");
	}	
	if (!!callBack && isFunction(callBack) && ret == 1) {
		if ((opt instanceof Array) == false) {
			var optArr = [];
			optArr.push(opt);
			opt = optArr;
		}	
		callBack.apply(this, opt);
	}
}


//打开非模态窗口
function openWin(url, width, height, top, left, other) {
	var w = !!width ? width : 600;
	var h = !!height ? height : 500;
	var t = !!top ? top : (screen.height-h)/2 - 10;
	var l = !!left ? left : (screen.width-w)/2;
	var opt = "scrollbars=yes,width=" + w + ",height=" + h + ",top=" + t + ",left=" + l;
	if (!!other)
		opt += "," + other;
	window.open(url, "", opt);
}

function doDelete(url, tips, callBack, opt) {
	if(confirm("是否删除？" + "\n\n" + tips)){
		var returnData = getJSONData({url: url});
		if (!!returnData && returnData.Message == "OK") {
			alert("删除成功!");
			if (!!callBack && isFunction(callBack)) {
				if ((opt instanceof Array) == false) {
					var optArr = [];
					optArr.push(opt);
					opt = optArr;
				}	
				callBack.apply(this, opt);
			}
		}else if(!!returnData &&returnData.Message == "NOTICEEXIT"){
			alert("存在公告使用该标签！");
			
		}else {
			alert("删除失败!");
		}
	}
}

//使用post请求删除
function doDelete2(url, tips, callBack, opt) {
	if(confirm("是否删除？" + "\n\n" + tips)){
		var returnData = getJSONData({url: url,type:'POST'});
		if (!!returnData && returnData.Message == "OK") {
			alert("删除成功!");
			if (!!callBack && isFunction(callBack)) {
				if ((opt instanceof Array) == false) {
					var optArr = [];
					optArr.push(opt);
					opt = optArr;
				}	
				callBack.apply(this, opt);
			}
		}else if(!!returnData &&returnData.Message == "NOTICEEXIT"){
			alert("存在公告使用该标签！");
		}else {
			alert("删除失败!");
		}
	}
}

function doClear(url, tips, callBack, opt) {
	if(confirm("是否清除？" + "\n\n" + tips)){
		var returnData = getJSONData({url: url});
		if (!!returnData && returnData.Message == "OK") {
			alert("清除成功!");
			if (!!callBack && isFunction(callBack)) {
				if ((opt instanceof Array) == false) {
					var optArr = [];
					optArr.push(opt);
					opt = optArr;
				}	
				callBack.apply(this, opt);
			}
		}else if(!!returnData &&returnData.Message == "NOTICEEXIT"){
			alert("存在公告使用该标签！");
			
		}else {
			alert("删除失败!");
		}
	}
}

function createXmlByStr(str) {
	if(document.all) {
	    var xmlDom = new ActiveXObject("Microsoft.XMLDOM");
	    xmlDom.loadXML(str);
	    return xmlDom;
	} else {
	    return new DOMParser().parseFromString(str, "text/xml");
	}
}

function log(s) {
	try {
		if (!!console && !!console.log)
			console.log(s);
	} catch (e) {}
}

function getTickCount(date) {
	var secs = date.getHours() * 3600 + date.getMinutes() * 60 + date.getSeconds();
	return secs * 1000 + date.getMilliseconds();
}

function duration(date1, date2) {
	var ms1 = this.getTickCount(date1);
	var ms2 = this.getTickCount(date2);
	return ms1 - ms2;
}

function parseTime(sec) {
	var h=Math.floor(sec/3600);
    var m=Math.floor(sec%3600/60);
    var s=sec%60;
    var nh=h>=10?h:('0'+h);
    var nm=m>=10?m:('0'+m);
    var ns=s>=10?s:('0'+s);
    return nh+':'+nm+':'+ns;
}

function sec2min(sec, decimal) {
	var min = sec / 60;
	if (!!decimal) {
		return min.toFixed(decimal);
	} else {
		return min.toFixed(1);
	}
}

function sec2hour(sec, decimal) {
	var min = sec / 3600;
	if (!!decimal) {
		return min.toFixed(decimal);
	} else {
		return min.toFixed(1);
	}
}

function fixed(num, decimal) {
	if (typeof(num) == "number") {
		num = parseFloat(num);
	} else {
		return num;
	}
	if (!!decimal) {
		return num.toFixed(decimal);
	} else {
		return num.toFixed(1);
	}
}

function division(a, b, decimal) {
	var divisor = a;
	var dividend = b;
	if (decimal === "" && typeof(decimal) === "undefined") {
		decimal = 1;
	}
	if (a === "" || typeof(a) === "undefined" || b === "" || typeof(b) === "undefined" || a === 0 || b === 0 || (typeof(a) !== "number" && !(a instanceof Array)) || (typeof(b) !== "number" && !(b instanceof Array))) {
		return 0;
	}
	if (a instanceof Array && a.length > 0) {
		divisor = a[0];
		for (var i=1; i<a.length; i++) {
			divisor *= a[i];
		}
	}
	if (b instanceof Array && b.length > 0) {
		dividend = b[0];
		for (var i=1; i<b.length; i++) {
			dividend *= b[i];
		}
	}
	if (dividend != 0) {
		return (divisor / dividend).toFixed(decimal);
	} else {
		return 0;
	}
}

function getGuid() {
	var guid = "";
     for (var i = 1; i <= 32; i++){
       var n = Math.floor(Math.random()*16.0).toString(16);
       guid +=   n;
       if((i==8)||(i==12)||(i==16)||(i==20))
         guid += "-";
     }
     return guid;
}

function date2time() {
	$(".time").each(function(){
		var timeStrText = $(this).text();
		if (!!timeStrText) {
			timeStrText = timeStrText.substring(11, 19);
			$(this).text(timeStrText);
		}
		var timeStrVal = $(this).val();
		if (!!timeStrVal) {
			timeStrVal = timeStrVal.substring(11, 19);
			$(this).val(timeStrVal);
		}
	});
}

function dateAddMinute(date,mins){
    var thisDate = Date.parse(date);
	thisDate.addMinutes(mins);
	var newDate = thisDate.toString("yyyy-MM-dd HH:mm:ss");
	return newDate;
}

function strSplit(str, separator, index) {
	var sList = str.split(separator);
	if (index === "undefined" || index === null) {
		return sList;
	} else if (index < sList.length) {
		return sList[index];
	} else {
		return sList[sList.length - 1];
	}
}

function getSysProperty(key) {
	var data = getJSONData({url: "/manage/sysProperty/findByKey.json?key=" + key});
	if (!!data && !!data.Data) {
		return data.Data.value;
	}
	return "";
}

function emptyTd(num){
	var str = "";
	for(var i=0; i<num; i++){
		str += "<td>-</td>";
	}
	return str;
}

function getArrow(key){
	var str = 	'{{if ' + key + '>0}}<span style="color:red">↑</span>{{else}}<span style="color:green">↓</span>{{/if}}';
	return str;
}


function getThematicreportRowSpan(obj){
	var data = obj.data;
	var num = 0;
	for(attr in data){
		if(typeof(data[attr])=="object"){
			num++;
		}
	}
	return num;
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "H+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//保存原生alert
var _OLD_ALERT = window.alert;
//覆盖原生alert
window.alert = function(msg, opts) {
	//是否ie6浏览器
	var ie6=!-[1,]&&!window.XMLHttpRequest;
	if (ie6) {
		_OLD_ALERT(msg);
	} else if (!!window.top && window.top.art) {//如果页面加载了art组件，则调用art的方法，若没有，则调用原生alert
		if (!!opts) {
			opts.content = msg + "";
			var dialog = window.top.art.dialog(opts);
			if (!!opts.follow) {
				dialog.follow(opts.follow);
			}
		} else {
			window.top.art.dialog({content: msg + "", title: "", lock: true});
		}
	} else {
		if (!!window.art) {
			if (!!opts) {
				opts.content = msg + "";
				art.dialog(opts);
			} else {
				art.dialog({content: msg + "", title: "", lock: true});
			}
		} else {
			_OLD_ALERT(msg);
		}
	}
};

//移除前后空格
String.prototype.trim= function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
};

window.clearIframe = function(id){
    var el = document.getElementById(id),
    iframe = el.contentWindow;
	if(el){
	    el.src = 'about:blank';
	    try{
	    	iframe.document.body.innerHTML = "";
	        iframe.document.write('');
	        iframe.document.clear();
	        iframe.close();
	        CollectGarbage();  
	    }catch(e){};
	}
};
//$(document).ready(function() {
//	var _onunload = window.onunload;
//    window.onunload = function() {
//    	try{
//	    	document.body.innerHTML = "";
//			document.write('');
//			document.clear();
//    	}catch(e){};
//		if (_onunload) _onunload();
//        window.onunload = null;     
//    }
//});
Number.prototype.toFixed = function(fractionDigits) {
	var retainDigit = parseInt(fractionDigits) || 0;
	if(retainDigit < 0 || retainDigit > 20) { 
		throw new RangeError("tofixed()数字参数必须是0和20之间");
	}
	var source = Number(this);
	if(isNaN(source)) {
		return "NaN";
	}
	var s = "";
	if(source < 0) {
		s = "-";
		source = -source;
	}
	if( source >= Math.pow(10, 21)) {
		return s + source.toString();
	}
	var target = "";
	var n = Math.round(source * Math.pow(10, retainDigit));
	if(n == 0){
		target = "0";
	} else {
		// 设M是N的字符串组成的十进制数字（顺序，没有前导零）。
		target =  n.toString();
	}
	if(retainDigit == 0) {
		return s + target;
	}
	var k = target.length;
	if(k <= retainDigit) {
		var z = Math.pow(10, retainDigit + 1 - k).toString().substring(1);
		target = z + target;
		k = retainDigit + 1;
	}
	if(retainDigit > 0) {
		var integer = target.substring(0, k - retainDigit);
		var decimal = target.substring(k - retainDigit);
		target = integer + "." + decimal;
	}
	return s + target;
	

};