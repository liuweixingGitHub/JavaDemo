'use strict';

/**
 * 提供基础方法,为其他UI组件开发,提供管理api.
 * 尽量减少该文件的代码量.
 */

/**
 * jj基础类型判断, 基础操作
 */
(function () {

    window.ss = window.ss || {};

    var _toString = Object.prototype.toString;

    /**
     * each方法的回调函数
     * @callback eachArrayCallback
     * @param {*} item 数组元素
     * @param {Number} index 数组元素索引
     * @param {Array} array 遍历的数组
     */

    /**
     * each方法的回调函数
     * @callback eachObjectCallback
     * @param {String} propName 属性名称
     * @param {*} propValue 属性值
     * @param {Object} object 遍历的对象
     */

    /**
     * 迭代处理数组中的每个元素
     * @method each
     * @param {Array|Object} array 如果不是数组的话
     * @param {eachArrayCallback|eachObjectCallback} callback 回调函数
     */
    ss.each = function (array, callback) {
        if (ss.isUndefinedOrNull(array)) {
            return;
        }

        if (this.isArray(array)) {
            if (array && array.length > 0) {
                for (var i = 0, len = array.length; i < len; i++) {
                    if (callback(array[i], i, array) === false) {
                        return;
                    }
                }
            }
        } else {
            for (var p in array) {
                if (array.hasOwnProperty(p)) {
                    callback(p, array[p], array);
                }
            }
        }
    };

    /**
     * <p>判断值是否为空</p>
     * <p>下面的值，将判断为空<div><ul>
     * <li>null</li>
     * <li>undefined</li>
     * <li>空的数组</li>
     * <li>长度为0的字符串</li>
     * </ul></div>
     * @method isEmpty
     * @param {String|Array} v
     * @return {Boolean}
     */
    ss.isEmpty = function (v) {
        return v === null || v === undefined || ((ss.isArray(v) && !v.length)) || v === '';
    };

    /**
     * 判断值是否不为空，与isEmpty方法的值相反
     * @method isNotEmpty
     * @param {String|Array} v
     * @return {Boolean}
     */
    ss.isNotEmpty = function (v) {
        return !this.isEmpty.apply(this, arguments);
    };

    /**
     * 如果传递的参数为数组，则返回true，否则返回false。
     * @method isArray
     * @param {*} v
     * @return {Boolean}
     */
    ss.isArray = function (v) {
        return _toString.apply(v) === '[object Array]';
    };

    /**
     * 如果传递的参数为日期对象，则返回true，否则返回false。
     * @method isDate
     * @param {*} v
     * @return {Boolean}
     */
    ss.isDate = function (v) {
        return _toString.apply(v) === '[object Date]';
    };

    /**
     * 如果传递的参数为字符串，则返回true，否则返回false。
     * @method isString
     * @param {*} v
     * @return {Boolean}
     */
    ss.isString = function (v) {
        return typeof v === 'string';
    };

    /**
     * 如果传递的参数为布尔值，则返回true，否则返回false。
     * @method isBoolean
     * @param {*} v
     * @return {Boolean}
     */
    ss.isBoolean = function (v) {
        return typeof v === 'boolean';
    };

    /**
     * 如果传递的参数为数字,则返回true，否则返回false。
     * @param {*} v 判断该值是否是数字,并且不是无穷数
     * @return {Boolean}
     */
    ss.isNumber = function (v) {
        return typeof v === 'number';
    };

    /**
     * 如果传递的参数为函数对象，则返回true，否则返回false。
     * @method isFunction
     * @param {*} v
     * @return {Boolean}
     */
    ss.isFunction = function (v) {
        return _toString.apply(v) === '[object Function]';
    };

    /**
     * 判断一个变量有定义且不为null
     * @method  isDefinedAndNotNull
     * @param {*} o
     * @return {Boolean}
     */
    ss.isDefinedAndNotNull = function (o) {
        return !this.isUndefinedOrNull(o);
    };

    /**
     * 判断一个变量没定义或者为null
     * @method isUndefinedOrNull
     * @param {*} o
     * @return {Boolean}
     */
    ss.isUndefinedOrNull = function (o) {
        return this.isUndefined(o) || o == null;
    };

    /**
     * 判断一个变量是否没定义
     * @method  isUndefined
     * @param {*} o
     * @return {Boolean}
     */
    ss.isUndefined = function (o) {
        return !this.isDefined(o);
    };

    /**
     * 如果传递的参数为undefined，则返回true，否则返回false。
     * @method isDefined
     * @param {*} v
     * @return {Boolean}
     */
    ss.isDefined = function (v) {
        return typeof v !== 'undefined';
    };

    /**
     * 拷贝属性的值(不拷贝从原型继承的属性)
     * @param src
     * @param dest
     */
    ss.copyTo = function (src, dest) {
        this.each(src, function (p, v) {
            dest[p] = v;
        });
        return dest;
    };

    ss.deepCopy = function (obj) {
        if (ss.isUndefined(obj)) {
            return undefined;
        }

        if (obj === null) {
            return null;
        }

        return JSON.parse(JSON.stringify(obj));
    };

    /**
     * 产生一个递增的id
     * @method nextId
     * @return {Number}
     */
    ss.nextId = (function () {
        var c = 0;
        return function () {
            return ++c;
        };
    })();

    /**
     * 合并URL和参数
     * @param url
     * @param param
     */
    ss.combineUrlParam = function (url, param) {
        if (url.indexOf('?') == -1) {
            return url + "?" + param;
        } else {
            return url + "&" + param;
        }
    };

})();

/**
 * 日志工具类
 */
(function () {

    var _console = window.console;

    var _logIf = function (msg) {
        if (_console && _console.log) {
            _console.log(msg);
        }
    };

    var _formatByNumber = function (stringTemplate) {
        if (arguments.length == 0) return "";
        var args = Array.prototype.slice.call(arguments, 1);

        if (!ss.isString(stringTemplate)) {
            stringTemplate = stringTemplate + "";
        }

        return stringTemplate.replace(/\{(\d+)\}/g, function (m, i) {
            var val = args[i];
            if (val === undefined || val === null) {
                val = "";
            }
            return val;
        });
    };

    ss.debug = function () {
        var msg = _formatByNumber.apply(this, arguments);

        if (_console && _console.debug) {
            _console.debug(msg);
        } else {
            _logIf(msg);
        }
    };

    ss.log = function () {
        var msg = _formatByNumber.apply(this, arguments);

        _logIf(msg);
    };

    ss.warn = function () {
        var msg = _formatByNumber.apply(this, arguments);

        if (_console && _console.warn) {
            _console.warn(msg);
        } else {
            _logIf(msg);
        }
    };

    ss.error = function () {
        var msg = _formatByNumber.apply(this, arguments);

        if (_console && _console.warn) {
            _console.error(msg);
        } else {
            _logIf(msg);
        }
    };

})();

/**
 * 数组操作工具类
 */
(function () {

    ss.array = ss.array || {};

    /**
     * 检查索引是否在数组范围内
     * @param {Array} array
     * @param {number} index
     * @returns {boolean}
     */
    ss.array.checkArrayIndexRange = function(array, index){
        return 0 <= index && index <= array.length - 1;
    };

    /**
     * 差集
     * @param {Array} array
     * @param {Array} array2
     * @returns {Array}
     */
    ss.array.diffArray = function(array, array2){
        var result =[];
        ss.array.each(array, function(item){
            if(! ss.array.contains(array2, item)){
                result.push(item);
            }
        });
        return result;
    };

    /**
     * 取子集
     */
    ss.array.subarray = function (array, startIndex, endIndex) {

        if (endIndex == -1 || ss.isUndefinedOrNull(endIndex)) {
            endIndex = array.length;
        } else if (endIndex > array.length) {
            endIndex = array.length;
        }

        var result = [];
        for (var i = startIndex; i < endIndex; i++) {
            result.push(array[i]);
        }
        return result;
    };

    /**
     * 迭代处理数组中的每个元素
     * @method each
     * @param {Array} array 如果不是数组的话
     * @param {eachArrayCallback} callback 回调函数
     */
    ss.array.each = function (array, callback) {
        if (array && array.length > 0) {
            for (var i = 0, len = array.length; i < len; i++) {
                if (callback(array[i], i, array) === false) {
                    return;
                }
            }
        }
    };

    ss.array.eachDesc = function (array, callback) {
        if (array && array.length > 0) {
            for (var i = array.length - 1; i >= 0; i--) {
                if (callback(array[i], i, array) === false) {
                    return;
                }
            }
        }
    };

    ss.array.map = function (array, callback) {
        var result = [];
        this.each(array, function (item) {
            result.push(callback(item));
        });
        return result;
    };

    /**
     * 将一个数组融合到目标数组中
     * 说明: 不使用concat方法，concat方法不会修改原数组。
     * @method  addAll
     * @param {Array} target 目标数组
     * @param {Array} array 数组
     * @return {Array}
     */
    ss.array.addAll = function (target, array) {
        ss.array.each(array, function (item) {
            ss.array.add(target, item);
        });
    };

    /**
     * 将目标数组中的某一部分对象移除
     * @method removeAll
     * @param {Array} target 目标数组
     * @param {Array} array 对象组成的数组
     */
    ss.array.removeAll = function (target, array) {
        ss.array.each(array, function (obj) {
            ss.array.remove(target, obj);
        });
    };

    /**
     * 将一个变量转换成数组
     * @method itemToArray
     * @param {*} item
     * @return {Array}
     */
    ss.array.itemToArray = function (item) {
        if (!ss.isArray(item)) {
            return [item];
        }
        return item;
    };

    /**
     * 交换数组中两个索引项的值
     * @method  exchangeArrayItem
     * @param {Array} array
     * @param {Number} index1
     * @param {Number} index2
     */
    ss.array.exchangeArrayItem = function (array, index1, index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    };

    /**
     * 将对象移到数组的后面
     * @method moveToLast
     * @param {Array} array
     * @param {*} item
     */
    ss.array.moveToLast = function (array, item) {
        this.remove(array, item);
        array.push(item);
    };

    /**
     * 将一个对象放到数组的某个索引中
     * @method add
     * @param {Array} array
     * @param {Object} item
     * @param {Number} [index]
     */
    ss.array.add = function (array, item, index) {
        if (ss.isDefined(index)) {
            array.splice(index, 0, item);
        } else {
            array.push(item);
        }
    };

    /**
     * 根据索引值移除数组中的某一项
     * @method removeByIndex
     * @param {Array} array
     * @param {Number} i
     * @return {*}
     */
    ss.array.removeByIndex = function (array, i) {
        if (0 <= i && i < array.length) {
            return array.splice(i, 1);
        }
    };

    /**
     * 移除数组中某个索引值后面的全部项
     * @method removeAfter
     * @param {Array} array
     * @param {Number} index
     */
    ss.array.removeAfter = function (array, index) {
        for (var i = index + 1; i < array.length; i++) {
            this.removeByIndex(array, i);
        }
    };

    /**
     * 融合一个数组到目标数组中
     * @method  combine
     * @param {Array} thisArray  目标数组
     * @param {Array} array
     * @param {Boolean} [excludeSame]  是否排除相等的元素,默认为true
     */
    ss.array.combine = function (thisArray, array, excludeSame) {
        for (var i = 0, l = array.length; i < l; i++) {
            if (excludeSame) {
                ss.array.addIf(thisArray, array[i]);
            } else {
                thisArray.push(array[i]);
            }
        }
        return thisArray;
    };

    /**
     * 判断数组是否包含某个项
     * @method contains
     * @param {Array} thisArray
     * @param {*} item
     * @param {Number} [from] 从数组的某个索引开始判断，默认从第0个开始
     * @return {Boolean}
     */
    ss.array.contains = function (thisArray, item, from) {
        if (thisArray) {
            from = from || 0;
            for (var i = from; i < thisArray.length; i++) {
                if (thisArray[i] == item) {
                    return true;
                }
            }
        }
        return false;
    };

    ss.array.containsCompareString = function (thisArray, item, from) {
        if (thisArray) {
            from = from || 0;
            for (var i = from; i < thisArray.length; i++) {
                if (thisArray[i] + "" == item + "") {
                    return true;
                }
            }
        }
        return false;
    };

    /**
     * 选择排序，默认按从小到大的顺序进行排序
     * @method sort
     * @param {Array} array
     * @param {String} dir  dir的值包括"asc", "desc"
     * @return {Array}
     */
    ss.array.sort = function (array, dir) {

        var desc = dir == 'desc';

        for (var i = 0; i < array.length - 1; i++) {

            var selectedIndex = i;
            for (var j = i + 1; j < array.length; j++) {
                if (desc) {
                    if (array[j] > array[selectedIndex]) {
                        selectedIndex = j;
                    }
                } else {
                    if (array[j] < array[selectedIndex]) {
                        selectedIndex = j;
                    }
                }
            }

            // 交换两者的值
            if (i != selectedIndex) {
                var temp = array[i];
                array[i] = array[selectedIndex];
                array[selectedIndex] = temp;
            }
        }

        return array;

    };

    /**
     * 获取最好一个元素
     * @method getLast
     * @param {Array} array
     * @return {*}
     */
    ss.array.getLast = function (array) {
        return (array.length) ? array[array.length - 1] : null;
    };

    /**
     * 移除最后一个元素,并返回
     * @method removeLast
     * @param {Array} array
     * @return {*}
     */
    ss.array.removeLast = function (array) {
        if (array.length > 0) {
            var item = array[array.length - 1];
            array.length = array.length - 1;
            return item;
        } else {
            return null;
        }
    };

    /**
     * 删除值为null或undefined的值
     * @param array
     * @returns {Array|*}
     */
    ss.array.removeNullOrUndefined = function(array){
        return ss.array.filter(array, function(item){
            return ss.isDefinedAndNotNull(item);
        });
    };

    /**
     * 获取某对象在数组中的索引
     * @method indexOf
     * @param {Array} thisArray
     * @param {Number} item
     * @return {Number}
     */
    ss.array.indexOf = function (thisArray, item) {
        var ret = -1;
        ss.array.each(thisArray, function (ele, i) {
            if (ele == item) {
                ret = i;
                return false;
            }
        });
        return ret;
    };


    /**
     * 移除数组中某几项
     * @method remove
     * @param {Array} thisArray
     * @param {Function} func
     * @return {*}
     */
    ss.array.removeSome = function (thisArray, func) {
        var removed = [];
        for(var i = 0; i<thisArray.length; i++){
            if(func(thisArray[i], i)){
                removed.push(thisArray[i]);
                thisArray.splice(i, 1);
            }
        }

        return removed;
    };

    /**
     * 移除数组中某一项
     * 通过找到该项在数组中的位置，再将其移除
     * @method remove
     * @param {Array} thisArray
     * @param {*} item
     * @return {*}
     */
    ss.array.remove = function (thisArray, item) {
        var index = this.indexOf(thisArray, item);
        return this.removeByIndex(thisArray, index);
    };

    /**
     * 移入变量，判断数组中是否存在某变量，
     * 如果不存在则将其移入数组中
     * @method include
     * @param {Array} thisArray
     * @param {*} item
     */
    ss.array.addIf = function (thisArray, item) {
        if (!ss.array.contains(thisArray, item)) thisArray.push(item);
        return thisArray;
    };

    /**
     * 拷贝数组
     * @method copy
     * @param {Array} array
     * @return {Array}
     */
    ss.array.copy = function (array) {
        var ret = [];
        for (var i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    };

    /**
     * 获取包含的元素的个数(相同的元素只计算一次)
     * @method countUniqueItem
     * @param array
     * @param item
     * @returns {number}
     */
    ss.array.countUniqueItem = function (array, item) {
        var count = 0;
        for (var i = 0; i < array.length; i++) {
            if (array[i] == item) {
                count++;
            }
        }
        return count;
    };

    /**
     * 出栈
     * @method pop
     * @param {Array} array
     * @return {*}
     */
    ss.array.pop = function (array) {
        var item = array[array.length - 1];
        array.splice(array.length - 1, 1);
        return item;
    };

    /**
     * 获取栈中最新一项
     * @method peek
     * @param {Array} array
     * @return {*}
     */
    ss.array.peek = function (array) {
        return array[array.length - 1];
    };

    /**
     * 入栈
     * @method push
     * @param {Array} array
     * @param {*} item
     */
    ss.array.push = function (array, item) {
        array.push(item);
    };

    /**
     * 获取数组中每一项的某属性对应的值
     * @method getPropertyValues
     * @param {Array} array
     * @param {String} propertyName
     * @return {Array}
     */
    ss.array.getPropertyValues = function (array, propertyName) {
        var ret = [];
        if (array) {
            for (var i = 0; i < array.length; i++) {
                var v = array[i][propertyName];
                ret.push(v);
            }
        }
        return ret;
    };

    /**
     * 根据属性过滤
     * @method filterByProperty
     * @param {Array} array
     * @param {String} propertyName
     * @return {Array}
     */
    ss.array.filterByProperty = function (array, propertyName, propertyValue) {
        var ret = [];
        if (array) {
            for (var i = 0; i < array.length; i++) {
                var v = array[i][propertyName];
                if (v == propertyValue) {
                    ret.push(array[i]);
                }
            }
        }
        return ret;
    };

    /**
     * 根据属性过滤
     * @method filterByProperty
     * @param {Array} array
     * @param {String} propertyName
     * @return {Array}
     */
    ss.array.findIndexFilterByProperty = function (array, propertyName, propertyValue) {
        var ret = [];
        if (array) {
            for (var i = 0; i < array.length; i++) {
                var v = array[i][propertyName];
                if (v == propertyValue) {
                    ret.push(i);
                }
            }
        }
        return ret;
    };

    /**
     * 根据函数的执行结果,进行过滤
     * @method filter
     * @param {Array} array
     * @param {Function} callback
     * @return {Array}
     */
    ss.array.filter = function (array, callback) {
        var ret = [];
        if (array) {
            for (var i = 0; i < array.length; i++) {
                if (callback(array[i])) {
                    ret.push(array[i]);
                }
            }
        }
        return ret;
    };

    /**
     * 根据对象的属性进行排序. 默认按从小到大的顺序进行排序
     * @method sortByProperty
     * @param {Array} array
     * @param {String} propertyName  属性名
     * @param {String} dir  dir的值包括"asc", "desc"
     * @return {Array}
     */
    ss.array.sortByProperty = function (array, propertyName, dir) {
        if(! array){
            return ;
        }


        var desc = dir == 'desc';

        for (var i = 0; i < array.length - 1; i++) {

            var selectedIndex = i;
            for (var j = i + 1; j < array.length; j++) {
                if (desc) {
                    if (array[j][propertyName] > array[selectedIndex][propertyName]) {
                        selectedIndex = j;
                    }
                } else {
                    if (array[j][propertyName] < array[selectedIndex][propertyName]) {
                        selectedIndex = j;
                    }
                }
            }

            // 交换两者的值
            if (i != selectedIndex) {
                var temp = array[i];
                array[i] = array[selectedIndex];
                array[selectedIndex] = temp;
            }
        }

        return array;

    };

    ss.array.searchAndCopyPropertyTo = function (config) {
        var oldData = containerApp.table.getData();
        ss.each(config.dest, function (destItem) {
            var matchedItem = ss.array.filterByProperty(config.src, config.searchField, destItem[config.searchField])[0];
            if (matchedItem) {
                destItem[config.copyField] = matchedItem[config.copyField];
            }
        });
    };

    ss.array.searchByLabel = function (array, label) {
        var t1 = new Date().getTime();

        var result = [];
        ss.each(array, function (item) {
            if (ss.string.equalIgnoreCase(item.label, label)) {
                ss.array.add(result, item, 0);
            } else {
                if (ss.string.containsIgnoreCase(item.label, label)) {
                    result.push(item);
                }
            }
        });

        ss.log("searchByLabel, 数组长度{0},花费{1}毫秒", array.length, new Date().getTime() - t1);

        return result;
    };

    ss.array.optionsToMap = function (options) {
        var map = {};
        ss.each(options, function (o) {
            map[o.value] = o.label;
        });
        return map;
    };

    /**
     * 数组转换成Map
     * @param array
     * @param keyProp
     * @param valueProp
     * @returns {{}}
     */
    ss.array.toMap = function (array, callback) {
        var ret = {};
        ss.each(array, function (item) {
            var kv = callback(item);
            if (ss.isNotEmpty(kv)) {
                ret[kv[0]] = ret[kv[1]];
            }
        });
        return ret;
    };

    ss.array.sortOptions = function (options) {
        ss.array.sortByProperty(options, "label");
    };

    ss.array.removeOptionToFirst = function(options, label){
        if(ss.isNotEmpty(options)){
            ss.assert.notEmpty(label);
            for(var i = 0; i<options.length; i++){
                if(options[i].label == label){
                    // 交换
                    var temp = options[i];
                    options[i] = options[0];
                    options[0] = temp;
                }
            }
        }
    };

    ss.optionArray = ss.optionArray || {};

    /**
     * 返回一个新的数组
     * @param {Array} options
     * @param {string} value
     * @returns {Array}
     */
    ss.optionArray.removeByValue = function(options, value){
        return ss.array.filter(options, function(item){
            return item.value != value;
        });
    };

    ss.optionArray.findLabelByValue = function (options, value) {
        return ss.array.filterByProperty(options, "value", value)[0].label;
    };

})();

/**
 * 日期工具类
 */
(function () {

    ss.date = ss.date || {};

    ss.date.isDate = function (v) {
        return Object.prototype.toString.apply(v) === '[object Date]';
    };

    /**
     * 获得最晚日期，比如参数为2013/09/01,2013/09/09,
     * 则返回2013/09/09
     * @method max
     * @param {Date} date
     * @param {Date} date2
     * @return {Date}
     */
    ss.date.max = function (date, date2) {
        if (!date) {
            return date2;
        }
        if (!date2) {
            return date;
        }
        if (date.getTime() > date2.getTime()) {
            return date;
        } else {
            return date2;
        }
    };

    /**
     * 切换月份. 如果设置之后，月份值不匹配(例如2月与31号不匹配)，则重新设置(将日期设置成1号)。
     * @method setMonth
     * @param {Date} date
     * @param {Number} month 可能为负数
     */
    ss.date.switchMonth = function (date, month) {
        var day = date.getDate();

        date.setDate(1);
        date.setMonth(month);

        // 每月几号,对月份可能有影响
        var oldMonth = date.getMonth();
        date.setDate(day);
        var newMonth = date.getMonth();

        if (newMonth != oldMonth) {
            date.setDate(1);
            date.setMonth(oldMonth);
        }

    };

    /**
     * 将日期字符串格式化，比如将
     * "2013/09/09"转换为"2013-09-09"
     * @method parseDate
     * @param {String} string
     * @return {Date}
     */
    ss.date.parseDate = function (string) {
        string = string.replace(/-/g, "/");
        return new Date(string);
    };

    /**
     * 获取年月. 月份从0开始
     * @method getYM
     * @param {Date} date
     * @return {Array} 由年、月组成的数组
     */
    ss.date.getYM = function (date) {
        return [date.getFullYear(), date.getMonth()];
    };

    /**
     * 获取年月日. 月份从0开始
     * @method getYMD
     * @param {Date} date
     * @return {Array} 由年、月、日组成的数组
     */
    ss.date.getYMD = function (date) {
        return [date.getFullYear(), date.getMonth(), date.getDate()];
    };

    /**
     *  比较两个日期的年月
     *  @method compareYearMonth
     *  @param {Date} date
     *  @param {Date} date2
     *  @return {Number} 前者大则返回1，后者大则返回-1，相等则返回0
     */
    ss.date.compareYearMonth = function (date, date2) {
        return this._compareDateUseArray(this.getYM(date), this.getYM(date2));
    };

    /**
     *  比较两个日期的年月日
     *  @method compareYMD
     *  @param {Date} date
     *  @param {Date} date2
     *  @return  {Number} 前者大则返回1，后者大则返回-1，相等则返回0
     */
    ss.date.compareYMD = function (date, date2) {
        return this._compareDateUseArray(this.getYMD(date), this.getYMD(date2));
    };

    /**
     * 比较两个日期是否相等。参数为数组，
     * 数组项按年份，月份，日，时，分，秒往后排列。
     * @method compareDateUseArray
     * @param {Array} array
     * @param {Array} array2
     * @return {Number} 前者大则返回1，后者大则返回-1，相等则返回0
     */
    ss.date._compareDateUseArray = function (array, array2) {

        for (var i = 0; i < array.length; i++) {
            if (array[i] > array2[i]) {
                return 1;
            } else if (array[i] < array2[i]) {
                return -1;
            }
        }
        return 0;
    };
    /**
     * 格式化时间，
     * 如将[12,4,0]譬如将格式化为[12,04,00]
     * 数组对应的三个项分别为时、分、秒
     * @method formatTime
     * @param {Array} time 例如[12, 4, 0]
     * @param {String} format 例如"hh时mm分ss秒"
     * @return {String}
     */
    ss.date.formatTime = function (time, format) {
        var o = {
            "h+": time[0], // hour
            "m+": time[1], // minute
            "s+": time[2] // second
        };

        for (var k in o) {
            if (o.hasOwnProperty(k)) {
                if (new RegExp("(" + k + ")").test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                        : ("00" + o[k]).substr(("" + o[k]).length));
                }
            }
        }
        return format;
    };
    /**
     * 格式化日期,如
     * <pre><code>
     *   var today = new Date();
     *   ss.date.format(today,'yyyy-MM-dd hh:mm:ss');
     *   // 2013-09-09 12:34:05
     * </code></pre>
     * @method  format
     * @param {Date} date
     * @param {String} format
     * @return {String}
     */
    ss.date.format = function (date, format) {
        var _dateFormat = {
            "M+": date.getMonth() + 1, // month
            "d+": date.getDate(), // day
            "h+": date.getHours(), // hour
            "m+": date.getMinutes(), // minute
            "s+": date.getSeconds(), // second
            "q+": Math.floor((date.getMonth() + 3) / 3), // quarter
            'S': date.getMilliseconds()  // millisecond
        };

        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (date.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        }

        for (var k in _dateFormat) {
            if (_dateFormat.hasOwnProperty(k)) {
                var pv = _dateFormat[k];
                if (new RegExp("(" + k + ")").test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? pv
                        : ("00" + pv).substr(("" + pv).length));
                }
            }
        }
        return format;
    };
    /**
     * 添加年份
     * @method addYears
     * @param {Date} date
     * @param {Number} years
     * @return {Date}
     */
    ss.date.addYears = function (date, years) {
        return this.addMonths(date, years * 12);
    };

    /*
     * 添加月份
     * 月份从0开始,保持日期不变
     * @method addMonths
     * @param {Date} date
     * @param {Number} months
     * @return {Date}
     */
    ss.date.addMonths = function (date, months) {

        var n = date.getDate();
        date.setDate(1);
        date.setMonth(date.getMonth() + months);
        date.setDate(Math.min(n, this.getDaysInMonth(date)));
        return date;

    };

    /**
     * 获取前一个月的日期
     * @param date
     * @returns {*}
     */
    ss.date.prevMonth = function(date){
        var d = new Date();
        d.setTime(date.getTime());
        return ss.date.addMonths(d, -1);
    };

    /**
     * 判断是否闰年
     * @method isLeapYear
     * @param {Number} year
     * @return {Boolean}
     */
    ss.date.isLeapYear = function (year) {
        return (((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0));
    };

    /**
     * 获取日期当月的一号
     * @method getFirstDateOfMonth
     * @param {Date} date
     * @return {Date}
     */
    ss.date.getFirstDateOfMonth = function (date) {
        var ret = new Date(date);
        ret.setDate(1);
        return ret;
    };

    /**
     * 获取某一年中某个月份的天数
     * month从0开始
     * @method getDaysInMonth
     * @param {Number | Date} year
     * @param {Number}  [month]
     * @return {Number}
     */
    ss.date.getDaysInMonth = function (year, month) {

        if (this.isDate(year)) {
            var date = year;
            year = date.getFullYear();
            month = date.getMonth();
        }

        return [31, (this.isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];
    };
    /**
     * 获取某两个日期之间间隔的时间周期
     * @method  getInterval
     * @param {Date} d1
     * @param {Date} d2
     * @return {Object} 返回格式化后的时间周期，如{ h:12,m:2,s:23,ms:340}
     */
    ss.date.formatInterval = function (d1, d2) {

        var d3 = d1 - d2;
        var h = Math.floor(d3 / 3600000);
        var m = Math.floor((d3 - h * 3600000) / 60000);
        var s = (d3 - h * 3600000 - m * 60000) / 1000;
        var ms = d3 - h * 3600000 - m * 60000 - s * 1000;

        return {
            h: h,
            m: m,
            s: s,
            ms: ms
        }

    };

})();

/**
 * 数字工具类
 */
(function () {

    ss.number = ss.number || {};

    /**
     * 整除
     * @method div
     * @param {Number} dividend
     * @param {Number} divisor
     * @return {Number}
     */
    Math.div = function (dividend, divisor) {
        return Math.floor(dividend / divisor);
    };

    /**
     * 取余
     * @method mod
     * @param {Number} dividend
     * @param {Number} divisor
     * @return {Number}
     */
    Math.mod = function (dividend, divisor) {
        return dividend - Math.floor(dividend / divisor) * divisor;
    };

    /**
     * 判断数字是否是奇数
     * @method isOdd
     * @param {Number} i
     * @return {Boolean}
     */
    ss.number.isOdd = function (i) {
        return Math.mod(i, 2) == 1;
    };

    /**
     * 判断数字是否是偶数
     * @method isEven
     * @param {Number} i
     * @return {Boolean}
     */
    ss.number.isEven = function (i) {
        return Math.mod(i, 2) == 0;
    };

    /**
     * 抽取字符串中的数字，
     * 如抽取"Abc123com456",返回[123,456]
     * @method  extractInts
     * @param {String} str
     * @return {Array}
     */
    ss.number.extractInts = function (str) {
        var results = str.match(/\d+/g);

        var ret = [];
        for (var i = 0; i < results.length; i++) {
            ret.push(parseInt(results[i]));
        }

        return ret;
    };

    /**
     * 抽取字符串中第一个数字,
     * 如抽取"Abc123com"中的123
     * @method  extractInt
     * @param {String} str
     *  @return {Number}
     */
    ss.number.extractInt = function (str) {
        var ints = this.extractInts(str);
        return ints[0];
    };

    /**
     * 获取小数位数
     * @method  getDecimalDigits
     * @param num
     * @return {number}
     */
    ss.number.getDecimalDigits = function (num) {
        var str = num + "";
        var pointIndex = str.indexOf(".");
        if (pointIndex < 0) {
            return 0;
        } else {
            return str.length - 1 - pointIndex;
        }
    };

    /**
     * 取小数点后n位
     * @method  fixedNumberString
     * @param {String} numStr
     * @param {number} count
     * @return {String}
     */
    ss.number.fixedNumberString = function (numStr, count) {
        var str = numStr + "";
        var index = str.indexOf(".");
        if (index >= 0) {
            str = str.substring(0, index + count + 1);
        }
        return str;
    };

    /**
     * 取小数点后n位
     * @method  fixNumber
     * @param {number} num
     * @param {number} count
     * @return {Number}
     */
    ss.number.fixNumber = function (num, count) {
        return parseFloat(this.fixedNumberString(num + "", count));
    };

    /**
     * 取最小值
     * @method  min
     * @param {Array} nums
     * @return {number}
     */
    ss.number.min = function (nums) {
        var min = Number.MAX_VALUE;
        ss.each(nums, function (num) {
            min = Math.min(min, num);
        });
        return min;
    };

    /**
     * 取最大值
     * @method  max
     * @param {Array} nums
     * @return {number}
     */
    ss.number.max = function (nums) {
        var max = Number.MIN_VALUE;
        ss.each(nums, function (num) {
            max = Math.max(max, num);
        });
        return max;
    };

    /**
     * 将数值约束在一个范围内
     * @method  containment
     * @param {number} value
     * @param {number} min
     * @param {number} max
     * @return {number}
     */
    ss.number.containment = function (value, min, max) {

        if (ss.isArray(min)) {
            max = min[1];
            min = min[0];
        }

        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    };

    /* 遍历数字范围[min, max] */
    ss.number.eachRange = function (min, max, func) {
        for (var i = min; i <= max; i++) {
            func(i);
        }
    };

    /* 遍历数字范围[min, max],映射成不同的元素 */
    ss.number.mapRange = function (min, max, mapFunc) {
        var ret = [];
        ss.number.eachRange(min, max, function (i) {
            ret.push(mapFunc(i));
        });
        return ret;
    };

})();

/**
 * 字符串工具类
 */
(function () {

    ss.string = ss.string || {};

    /**
     * 删除空白字符
     * @param str
     * @returns {*}
     */
    ss.string.removeSpaceChar = function (str) {
        return str.replace(/\s+/g, "");
    };

    ss.string.equalIgnoreCase = function (str, str2) {
        return str.toLowerCase() == str2.toLowerCase();
    };

    ss.string.containsIgnoreCase = function (str, str2) {
        return ss.string.contains(str.toLowerCase(), str2.toLowerCase());
    };

    /**
     * 将字符串用空格分隔，并去掉空字符串
     * @param str
     * @returns {*}
     */
    ss.string.splitAndRemoveEmpty = function (str) {
        if (str) {
            var array = str.split(/\s+/g);
            var result = [];
            for (var i = 0; i < array.length; i++) {
                var item = array[i];
                if (item) {
                    result.push(item);
                }
            }

            return result;
        }

        return null;
    };

    /**
     * 将值为null的变量转换为空字符串
     * @method nullToEmpty
     * @param {String} obj
     * @return {*} 如果值为null，返回"",否则返回原参数
     */
    ss.string.nullToEmpty = function (obj) {
        if (obj === undefined || obj == null) {
            return "";
        } else {
            return obj;
        }
    };


    /**
     * 字符串局部替换功能
     * 比如，将"{}"替换成其他内容
     */
    ss.string.formatByEmpty = function (src, value) {
        if (arguments.length == 0) return "";
        var args = Array.prototype.slice.call(arguments, 1);
        return src.replace(/\{\}/g, function (m, i) {
            return value;
        });
    };

    /**
     * 根据参数顺序,替换字符串中的占位符{}
     * @param str
     */
    ss.string.formatByOrder = function(string){
        var index = 1;
        var args = arguments;
        return string.replace(/\{([0-9A-Za-z_]+)\}/g, function (m, i) {
            var r = args[index];
            index ++;
            return r;
        });
    };

    /**
     * 字符串局部替换功能
     * 比如，将"abc{0}d{1}"中的{0}和{1}替换成G,F， 代码如下
     * <pre><code>
     *    ss.string.formatByNumber('abc{0}d{1}','G','F');
     * </code></pre>
     * @method formatByNumber
     * @param {String} src
     * @return {String}
     */
    ss.string.formatByNumber = function (src) {
        if (arguments.length == 0) return "";
        var args = Array.prototype.slice.call(arguments, 1);
        return src.replace(/\{(\d+)\}/g, function (m, i) {
            var val = args[i];
            if (val === undefined || val == null) {
                val = "";
            }
            return val;
        });
    };
    /**
     * 字符串局部替换功能
     * 将"abc{abc}d{name}"中的{abc}和{name}替换成一个对象中的属性的值.代码如下
     * <pre><code>
     *    ss.string.format('abc{abc}d{name}',{ abc:123, name: 456});
     * </code></pre>
     * @method format
     * @param string
     * @param obj
     */
    ss.string.format = function (string, obj) {
        return string.replace(/\{([0-9A-Za-z_]+)\}/g, function (m, i) {
            //m：{abc}{name} ; i: abc name
            return obj[i];
        });
    };

    /**
     * 替换字符串中的数字
     * @param string
     * @param callback
     * @returns {*}
     */
    ss.string.replaceNumber = function (src, callback) {
        if (arguments.length == 0) return "";
        var args = Array.prototype.slice.call(arguments, 1);
        return src.replace(/(\d+)/g, function (m, i) {
            return callback(i);
        });
    };

    /**
     * 判断字符传中是否包含指定的子字符串
     * @method contains
     * @param {String} str
     * @param {String} substr
     * @return {Boolean}
     */
    ss.string.contains = function (str, substr) {
        return ss.isDefinedAndNotNull(str) && str.indexOf(substr) != -1;
    };

    /**
     * 判断字符传中是否包含数组中某个指定的子字符串
     * @method containsSome
     * @param string
     * @param substrarray
     */
    ss.string.containsSome = function (string, substrarray) {
        var result = false;
        for (var i = 0; i < substrarray.length; i++) {
            if (this.contains(string, substrarray[i])) {
                result = true;
            }
        }
        return result;
    };

    /**
     * 将字符串中首尾两端的空格去除
     * @method trim
     * @param {String} string
     * @param {Boolean} nullToEmpty  是否将值为null的变量转换为“”
     * @return {String}
     */
    ss.string.trim = function (string, nullToEmpty) {
        if (ss.isUndefinedOrNull(string)) {
            if (nullToEmpty) {
                return "";
            } else {
                return string;
            }
        }
        return String(string).replace(/^\s+|\s+$/g, '');
    };
    /**
     * 判断某字符串是否以某子字符串做结尾
     * @method endsWith
     * @param {String} string
     * @param {String} pattern
     * @return {Boolean}
     */
    ss.string.endsWith = function (string, pattern) {
        if (ss.isUndefinedOrNull(string)) {
            return false;
        }
        var d = string.length - pattern.length;
        return d >= 0 && string.lastIndexOf(pattern) === d;
    };
    /**
     * 判断某字符串是否以某子字符串做开头
     * @method startWith
     * @param {String} string
     * @param {String} subString
     * @return {Boolean}
     */
    ss.string.startWith = function (string, subString) {
        if (ss.isUndefinedOrNull(string)) {
            return false;
        }
        return string.indexOf(subString) == 0;
    };
    /**
     * 获取末尾几个字符组成的字符串
     * @method getEndChars
     * @param {String} string
     * @param {Number} count 指定字符的个数
     * @return {String}
     */
    ss.string.getEndChars = function (string, count) {
        return string.substring(string.length - count);
    };

    /**
     * 计算不相同的字符串的个数
     * @method  countUniqueItem
     * @param {Array} array
     * @return {number}
     */
    ss.string.countUniqueItem = function (array) {
        var map = {};
        var count = 0;
        for (var i = 0; i < array.length; i++) {
            var value = array[i];
            if (!map[value]) {
                count += 1;
                map[value] = true;
            }
        }
        return count;
    };

    /**
     * 移除相同的字符串
     * @method  removeSameItem
     * @param {Array} array
     * @return {Array}
     */
    ss.string.removeSameItem = function (array) {
        var map = {};
        var ret = [];
        for (var i = 0; i < array.length; i++) {
            var value = array[i];
            if (!map[value]) {
                ret.push(value);
                map[value] = true;
            }
        }
        return ret;
    };

    /**
     * 如果一个字符串是以某字符串开头，则将其删除
     * @method removeStart
     * @param {String} str
     * @param {String} substring
     * @param {Boolean} iterator 是否迭代删除
     * @return {String}
     */
    ss.string.removeStart = function (str, substring, iterator) {

        if (this.startWith(str, substring)) {
            str = str.substring(substring.length);

            if (iterator) {
                return this.removeStart(str, substring, iterator);
            } else {
                return str;
            }

        } else {
            return str;
        }
    };

    /**
     * 如果一个字符串是以某字符串结尾，则将其删除
     * @method removeEnd
     * @param {String} str
     * @param {String} substring
     * @return {String}
     */
    ss.string.removeEnd = function (str, substring) {
        if (this.endsWith(str, substring)) {
            return str.substring(0, str.length - substring.length);
        } else {
            return str;
        }
    };

    ss.string.insert = function (str, index, substr) {
        return str.substring(0, index) + substr + str.substring(index);
    };

})();

(function () {

    ss.Set = function () {
        this._elements = [];
    };

    ss.Set.prototype.add = function (object) {
        if (!this.contains(object)) {
            this._elements.push(object);
        }
    };

    ss.Set.prototype.remove = function (object) {
        for (var i = 0; i < this._elements.length; i++) {
            if (this._elements[i] === object) {
                this._elements.splice(i, 1);
                break;
            }
        }
    };

    ss.Set.prototype.contains = function (object) {
        for (var i = 0; i < this._elements.length; i++) {
            if (this._elements[i] === object) {
                return true;
            }
        }
        return false;
    };

    ss.Set.prototype.toArray = function () {
        return this._elements.slice();
    };

})();

(function () {

    ss.Map = function () {
        this._innerMap = {};
        this._keys = new ss.Set();
    };

    ss.Map.prototype.put = function (key, value) {
        this._innerMap[key] = value;
        this._keys.add(key);
    };

    ss.Map.prototype.get = function (key) {
        return this._innerMap[key];
    };

    ss.Map.prototype.getKeys = function () {
        return this._keys.toArray();
    };

})();

(function () {

    ss.MultiValueMap = function () {
        this._innerMap = new ss.Map();
    };

    ss.MultiValueMap.prototype.put = function (key, value) {
        var array = this._innerMap.get(key);
        if (array === undefined) {
            array = [];
            this._innerMap.put(key, array);
        }

        array.push(value);
    };

    ss.MultiValueMap.prototype.getValues = function (key) {
        return this._innerMap.get(key);
    };

})();

/* 用来生成html */
(function () {

    var _isSelfClosed = function (tagName) {
        var _notSelfClosingTags = ['textarea', 'script', 'em', 'strong', 'option', 'select'];
        return !ss.array.contains(_notSelfClosingTags, tagName);
    };

    ss.HtmlNode = function (tagName) {
        this._tagName = tagName;
        this._attrs = new ss.Map();
        this._children = [];
        this._classNames = [];
    };

    ss.HtmlNode.prototype.html = function (html) {
        this._children.push(html);
        return this;
    };


    ss.HtmlNode.prototype.attr = function (name, value) {
        this._attrs.put(name, value);
        return this;
    };

    ss.HtmlNode.prototype.addClass = function (className) {
        this._classNames.push(className);
        return this;
    };

    ss.HtmlNode.prototype.setOnclick = function (onclick) {
        this._attrs.put("onclick", onclick);
        return this;
    };

    ss.HtmlNode.prototype.child = function (htmlNode) {
        this._children.push(htmlNode);
        return this;
    };

    ss.HtmlNode.prototype._renderAttrs = function () {
        var ret = "";

        var keys = this._attrs.getKeys();
        for (var i = 0; i < keys.length; i++) {
            var key = keys[i];
            var value = this._attrs.get(key);
            ret += " " + key + "='" + value + "' ";
        }

        if (this._classNames.length > 0) {
            ret += " class='" + this._classNames.join(' ') +
                "'"
        }

        return ret;
    };

    ss.HtmlNode.prototype.render = function () {
        var ret = "<" + this._tagName + this._renderAttrs();
        if (_isSelfClosed(this._tagName) && this._children.length == 0) {
            ret += "/>";
        } else {
            ret += ">";

            ret += this.renderChildren();

            ret += "</" + this._tagName + ">";
        }

        return ret;
    };

    ss.HtmlNode.prototype.renderChildren = function () {
        var ret = "";
        for (var i = 0; i < this._children.length; i++) {
            var child = this._children[i];
            if (child.render) {
                ret += child.render();
            } else {
                ret += child;
            }
        }
        return ret;
    };

    ss.createTag = function (tagName) {
        return new ss.HtmlNode(tagName);
    };

})();

(function () {

    window.ss = window.ss || {};

    ss.aopMethod = function (callback, scope, methodName) {
        return function () {
            ss.log(methodName + ",参数为:" + ss.toJSONString(arguments));
            var result = callback.apply(scope, arguments);
            ss.log(methodName + ",返回结果为:" + ss.toJSONString(result));
            return result;
        };
    };

    ss.toJSONString = function (o) {
        if (JSON && JSON.stringify) {
            return JSON.stringify(o);
        } else {
            return o;
        }
    };

    ss.getParamValue = ss.aopMethod(function (url, paramName) {
        var reg = new RegExp('(\\?|&)' + paramName + '=([^&?]*)', 'i');
        var arr = url.match(reg);

        if (arr) {
            return arr[2];
        }

        return "";
    }, "getParameter方法");

    ss.getPageParameter = function (paramName) {
        return ss.getParamValue(location.href, paramName);
    };

    /**
     * 计算匹配得分。
     * 如果返回一个数值，则是匹配的。
     * 如果返回null或undefined，则匹配失败。
     */
    ss.filterByPropertyAndSortByScore = function (array, propertyName, substr) {
        var startWithArray = [];
        var containsArray = [];
        ss.each(array, function (item) {
            var value = item[propertyName];
            if (ss.string.startWith(value, substr)) {
                startWithArray.push(item);
            } else if (ss.string.contains(value, substr)) {
                containsArray.push(item);
            }
        });

        ss.array.sortByProperty(startWithArray, propertyName);
        ss.array.sortByProperty(containsArray, propertyName);

        ss.array.addAll(startWithArray, containsArray);
        return startWithArray;
    };


    ss.getNestedValue = function (obj, prop) {
        var result = obj;
        var props = prop.split(".");
        ss.each(props, function (p) {
            result = result[p];
            if (ss.isUndefinedOrNull(obj)) {
                return false;
            }
        });
        return result;
    };

    var delayMap = {};
    ss.delay = function (callback, time, id) {
        var oldCallback = delayMap[id];
        if (ss.isDefinedAndNotNull(oldCallback)) {
            clearTimeout(oldCallback);
        }

        var num = setTimeout(function () {
            delete delayMap[id];
            callback();
        }, 200);
        delayMap[id] = num;
    };

})();


(function () {

    window.ss = window.ss || {};

    ss.assert = ss.assert || {};

    ss.assert.notEmpty = function (v, message) {
        if (ss.isEmpty(v)) {
            throw new Error("不能为空,实际值为" + v + "," + (message || ""));
        }
    };

    ss.assert.isNumber = function (v, message) {
        if (!ss.isNumber(v)) {
            throw new Error("值应该是数字,实际值类型为" + (typeof v) + "," + (message || ""));
        }
    };

    ss.assert.isString = function (v, message) {
        if (!ss.isString(v)) {
            throw new Error("值应该是字符串,实际值类型为" + (typeof v) + "," + (message || ""));
        }
    };

    ss.assert.gt1 = function (v, message) {
        ss.assert.isNumber(v, message);

        if (!v > 1) {
            throw new Error("值应该大于1,实际值为" + v + "," + (message || ""));
        }
    };

    ss.assert.inRange = function (v, min, max, message) {
        ss.assert.isNumber(v, message);

        if (!(min <= v && v <= max)) {
            throw new Error("值应该大于等于" + min + ",小于等于" + max + ",实际值为" + v + "," + (message || ""));
        }
    }

})();

/* 管理弹出层layer */
(function () {
    // 其他的组件可能会依赖该弹出层，例如List组件
    var layers = [];

    var setIdIfNotExist = function ($ele) {
        var id = $ele.attr("id");
        if (!id) {
            id = ss.nextComponentId("layer");
            $ele.attr("id", id);
        }
        return id;
    };

    var inited = false;
    var initDocumentClickIfNot = function () {
        if (inited) {
            return;
        }

        $(document).click(function (e) {
            if ($(e.target).existAttr("data-layer-anchor")) {
                return;
            }

            ss.array.eachDesc(layers, function (layerId, i) {
                var $layer = $("#" + layerId);
                if (!$(e.target).containedBy($layer)) {
                    ss.layer.hide($layer);
                }
            });
        });

        inited = true;
    };

    ss.layer = ss.layer || {};

    ss.layer.show = function ($target) {
        var id = setIdIfNotExist($target);
        $target.show();
        layers.push(id);

        initDocumentClickIfNot();
    };

    ss.layer.hide = function ($target) {
        $target.hide();
        ss.array.remove(layers, $target.attr("id"));
    };

})();

/* component管理 */
(function () {

    ss.nextComponentId = function (compType) {
        return compType + "_js_auto_comp_" + ss.nextId();
    };

    ss.getComponent = function (elementId) {
        var $element = null;
        if (ss.isString(elementId)) {
            $element = $("#" + elementId);
        } else {
            $element = elementId;
        }
        return $element.data("ui-component");
    };

    ss.getFontSize = function(){
        return 16;
    };

    /* 校验规则管理 */
    var rules = {};

    ss.rules =  ss.rules || {};

    ss.rules.add = function(ruleName, rule){
        rules[ruleName] = rule;
    };

    ss.rules.get = function(ruleName){
        var rule = rules[ruleName];
        if(ss.isUndefinedOrNull(rule)){
            ss.warn("ruleName=" + ruleName + ',没有找到规则');
        }
        return rule;
    };

    ss.createUrlFormat = function(url){
        return function (){
            var args = [];
            args.push(url);
            ss.array.each(arguments, function(arg){
                args.push(arg);
            });
            return ss.string.formatByOrder.apply(ss.string, args);
        };
    };

    ss.uri = function(url, args){
        return ss.string.formatByOrder.apply(ss.string, arguments);
    };

    ss.parseInt_emptyTo0 = function(string){
        return string ? parseInt(string) : 0;
    };

})();