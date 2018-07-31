$(document).ready(function() {
    var start_time = {
        elem: '#beginDate',	 // 目标元素
        event: 'focus',		 // 响应事件
        format: 'YYYY-MM-DD hh:mm:ss',	 // 日期格式
        //min: laydate.now(),		//最小日期
        max: '2099-06-15 23:59:59', //最大日期
        festival: true, // 显示节日
        istime: true,		 // 显示时分秒

        choose: function(dates){     //回调函数
            var cur = strToDate(dates);   //将字符串转换为日期

            // 开始日选好后，重置结束日的最小日期为开始日
            end_time.min = convertDate2String(cur);
            //将结束日的初始值设定为开始日
            end_time.start = convertDate2String(cur);
        }
    };

    var end_time = {
        elem: '#endDate',		 // 目标元素
        event: 'focus',		 // 响应事件
        format: 'YYYY-MM-DD hh:mm:ss',	 // 日期格式
        min: laydate.now(),    //设置最小日期
        max: '2099-06-15 23:59:59',	 // 最大日期
        festival: true, // 显示节日
        istime: true,		 // 显示时分秒

        choose: function(dates){		//回调函数
            var cur = strToDate(dates);

            // 结束日选好后，重置开始日的最大日期结束日期
            start_time.max = convertDate2String(cur);
        }
    };

    laydate(start_time);
    laydate(end_time);
});

/**
 *
 * @function :格式化日期字符串
 *
 * @param date:日期
 *
 */
function convertDate2String(date){
    //获取年份
    var year = date.getFullYear();

    //获取月份，若月份为单数月份，则在月份前补0
    var month = (date.getMonth() + 1).toString();
    if(month.length < 2){
        month = "0" + month;
    }

    //获取日期，若日期为单数日期，则在日期前补0
    var day = date.getDate().toString();
    if(day.length < 2){
        day = "0" + day;
    }

    //获取小时，若小时为单数，则在小时前补0
    var hour = date.getHours().toString();
    if(hour.length < 2){
        hour = "0" + hour;
    }

    //获取分钟，若分钟数为单数，则在分钟数前补0
    var minute = date.getMinutes().toString();
    if(minute.length < 2){
        minute = "0" + minute;
    }

    //获取秒数，若秒数为单数，则在秒数前补0
    var second = date.getSeconds().toString();
    if(second.length < 2){
        second = "0" +second;
    }

    //拼接日期字符串，格式:yyyy-MM-dd HH:mm:ss
    var date_time = year + ":" + month + ":" + day + " " + hour + ":" + minute + ":" + second;

    return date_time;
}
//字符串转换为日期
function strToDate(date){
    return new Date(date.replace(/-/g,"/"));
}