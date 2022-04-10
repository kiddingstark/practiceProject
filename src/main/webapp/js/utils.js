;
(function(){
    if (window.Utils) 
        return;
    
    var Utils = window.Utils = {
        parseUrlParams: function(){
            var s = window.location.search;
            s = s.substr(1);
            var sa = s.split('&');
            var rmap = {};
            for (var i in sa) {
                var kv = sa[i].split('=');
                rmap[kv[0]] = kv[1];
            }
            return rmap;
        },
        parseParentUrlParams: function(){
        	if (!!window.parent) {
	            var s = window.parent.location.href;
	            s = s.substr(1);
	            var sa = s.split("|");
	            var rmap = {};
	            if (sa.length > 1) {
	            	var params = sa[1];
	            	var ssa = params.split("&");
		            for (var i in ssa) {
		                var kv = ssa[i].split("=");
		                rmap[kv[0]] = kv[1];
		            }
	            }
	            return rmap;
        	}
        },
        parseMenuUrlParams: function(searchStr){
            var s = searchStr.substr(1);
            var sa = s.split('&menup=');
            var rmap = {};
            if(sa[1] != "undefined" && sa[1] != null && sa[1] != "")
            	rmap["menup"] = sa[1].substr(0);
            var ssa = sa[0].split('&');
            for (var i in ssa) {
                var kv = ssa[i].split('=');
                rmap[kv[0]] = kv[1];
            }
            return rmap;
        },
        formatDate: function(date){
            var thisDate = date;
			var m = thisDate.getMonth()+1;
			var d = thisDate.getDate();
            var thisDateStr = thisDate.getYear() + "-" + (m<10?('0'+m):m) + "-" + (d<10?('0'+d):d);
            return thisDateStr;
        },
        formatInputTime: function(date){
        	var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			var h = date.getHours();
			var n = date.getMinutes();
			var s = date.getSeconds();
			var str = '' + y + '-' + m + '-' + d + ' ' + (h<10?('0'+h):h) + ':' + (n<10?('0'+n):n) + ':' + (s<10?('0'+s):s);
			return str; 
        },
		formatDateTime: function(date){
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			var h = date.getHours();
			var n = date.getMinutes();
			var s = date.getSeconds();
			var str = '' + y + '年' + m + '月' + d + '日' + ' ' + (h<10?('0'+h):h) + ':' + (n<10?('0'+n):n) + ':' + (s<10?('0'+s):s);
			return str; 
		},
        parseDate: function(str, fmt){
            var today = new Date();
            var y = 0;
            var m = -1;
            var d = 0;
            var a = str.split(/\W+/);
            var b = fmt.match(/%./g);
            var i = 0, j = 0;
            var hr = 0;
            var min = 0;
            for (i = 0; i < a.length; ++i) {
                if (!a[i]) 
                    continue;
                switch (b[i]) {
                    case "%d":
                    case "%e":
                        d = parseInt(a[i], 10);
                        break;
                        
                    case "%m":
                        m = parseInt(a[i], 10) - 1;
                        break;
                        
                    case "%Y":
                    case "%y":
                        y = parseInt(a[i], 10);
                        (y < 100) && (y += (y > 29) ? 1900 : 2000);
                        break;
                        
                    case "%b":
                    case "%B":
                        for (j = 0; j < 12; ++j) {
                            if (Calendar._MN[j].substr(0, a[i].length).toLowerCase() == a[i].toLowerCase()) {
                                m = j;
                                break;
                            }
                        }
                        break;
                        
                    case "%H":
                    case "%I":
                    case "%k":
                    case "%l":
                        hr = parseInt(a[i], 10);
                        break;
                        
                    case "%P":
                    case "%p":
                        if (/pm/i.test(a[i]) && hr < 12) {
                            hr += 12;
                        } else if (/am/i.test(a[i]) && hr >= 12) {
                            hr -= 12;
                        }
                        break;
                        
                    case "%M":
                        min = parseInt(a[i], 10);
                        break;
                }
            }
            if (isNaN(y)) 
                y = today.getFullYear();
            if (isNaN(m)) 
                m = today.getMonth();
            if (isNaN(d)) 
                d = today.getDate();
            if (isNaN(hr)) 
                hr = today.getHours();
            if (isNaN(min)) 
                min = today.getMinutes();
            if (y != 0 && m != -1 && d != 0) 
                return new Date(y, m, d, hr, min, 0);
            y = 0;
            m = -1;
            d = 0;
            for (i = 0; i < a.length; ++i) {
                if (a[i].search(/[a-zA-Z]+/) != -1) {
                    var t = -1;
                    for (j = 0; j < 12; ++j) {
                        if (Calendar._MN[j].substr(0, a[i].length).toLowerCase() == a[i].toLowerCase()) {
                            t = j;
                            break;
                        }
                    }
                    if (t != -1) {
                        if (m != -1) {
                            d = m + 1;
                        }
                        m = t;
                    }
                } else if (parseInt(a[i], 10) <= 12 && m == -1) {
                    m = a[i] - 1;
                } else if (parseInt(a[i], 10) > 31 && y == 0) {
                    y = parseInt(a[i], 10);
                    (y < 100) && (y += (y > 29) ? 1900 : 2000);
                } else if (d == 0) {
                    d = a[i];
                }
            }
            if (y == 0) 
                y = today.getFullYear();
            if (m != -1 && d != 0) 
                return new Date(y, m, d, hr, min, 0);
            return today;
        }
    }
    
    var Map = function(){
    	var PREFIX = 'MAP_';
    	var count = 0;
    	var keymap = {};
    	
    	this.contains = function(key){
    		return !(keymap[PREFIX+key] === undefined); 	
    	}	
    	this.put = function(key, value){
    		if(!this.contains(key)){
	    		var ks = {'key':key, 'value':value};
	    		keymap[PREFIX + key] = ks;
	    		count++;
    		}else{
    			var ks = keymap[PREFIX + key];
    			ks.value = value;	
    		}
    	}
    	this.get = function(key){
    		if(this.contains(key)){
    			return keymap[PREFIX + key].value;
    		}
    	}
    	this.remove = function(key){
    		if(this.contains(key)){
    			var ks = keymap[PREFIX + key];
    			keymap[PREFIX + key] = undefined;
    			delete keymap[PREFIX + key];
    			count--;
    			return ks.value;
    		}
    	}
    	
    	this.clear = function(){
    		keymap = {};
    		count = 0;
    	}
    	
    	this.keySet = function(){
    		var ret = [];
    		for(var name in keymap){
    			if(name.indexOf(PREFIX) === 0){
    				var ks = keymap[name];
    				ret.push(ks);	
    			}	
    		}
    		return ret;
    	}
    	
    	this.size = function(){
    		return count;
    	}
    	
    	this.values = function(){
    		var ret = [];
    		for(var name in keymap){
    			if(name.indexOf(PREFIX) === 0){
    				var ks = keymap[name];
    				ret.push(ks.value);	
    			}	
    		}
    		return ret;
    	}
    }
    
    Utils.Map = Map;
    
    var ArrayUtils = window.ArrayUtils = {
    		
    	indexOf: function(arrayname, element) {
	    	var index = -1;
	    	for(var i=0; i<arrayname.length; i++) {
	    		if(arrayname[i] == element) return i;
	    	}
	    	return index;
    	},
    	
	    del: function(arrayname, index) {
    		arrayname.splice(index, 1);
	    },
	
	    remove: function(arrayname, element) {
	    	var index = arrayname.indexOf(element);
	    	if(index >= 0) arrayname.del(index);
	    },
	
	    exists: function(arrayname, element) {
	    	return this.indexOf(arrayname, element) >= 0;
	    }
    }
    
    Utils.ArrayUtils = ArrayUtils;
})();

function Event() {
	var listeners = [];
	var self = this;
	this.attach = function(func) {
		if(!ArrayUtils.exists(listeners, func)) listeners.push(func);
	};
	
	this.detach = function(func) {
		ArrayUtils.remove(listeners, func);
	};
	
	this.fire = function(ctx, data) {
		for(var i=0; i<listeners.length; i++) {
			listeners[i].call(ctx, data);
		}
	};
};

function isFunction(fn) {
    return !!fn && typeof fn != "string" && !fn.nodeName && fn.constructor != Array && /^[\s[]?function/.test(fn + "");
};

function getFullUrl(url, target, params) {
	if (params == null) {
		return url;
	} else {
		if (target == "_top") {
			if (url.indexOf("?") > 0) {
				var rArray = url.split("&menup=");
				var rUrl = rArray[0];
				var rParam = rArray[1];
				if (!!rParam) {
					rParam = rParam + "&" + params;
					return rUrl + "&menup=" + encodeURIComponent(rParam);
				} else {
					return url + "&menup=" + encodeURIComponent(params);
				}
			} else {
				return url + "?" + params;
			}
		} else {
			if (url.indexOf("?") > 0) {
				return url + "&" + params;
			} else {
				return url + "?" + params;
			}
		}
	}
};

String.prototype.trim= function(){
    // 用正则表达式将前后空格 
    // 用空字符串替代
    return this.replace(/(^\s*)|(\s*$)/g, "");
}