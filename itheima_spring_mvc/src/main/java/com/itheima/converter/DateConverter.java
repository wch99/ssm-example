package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//定义一个converter类实现Converter<?,?>接口，是要把前面的类型转换成后面的类型，实现里面的convert方法
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            //将日期字符串转换成日期对象
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
