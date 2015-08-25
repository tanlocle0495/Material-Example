package com.example.loc.lybrarymenu.animation;

import java.text.SimpleDateFormat;

/**
 * Created by loc on 25/04/2015.
 */
/* day la mot lop giao dien (interface)*/
public interface PaperDatepicker {
    /* dung de khoi tao gia tri mac dinh cho ngay hien tai
    *  theo mot y rieng cua minh
    * */
    SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd");
    SimpleDateFormat MOUNHT_NAME_FORMAT=new SimpleDateFormat("MMMM");/* lay cai   thang theo gia tri la chu*/
    SimpleDateFormat DAY_NAME_FORMAT=new SimpleDateFormat("EEEE");/* lay cai ten cura no de hien cai nay len tren trang layou*/
    SimpleDateFormat DD_MM_YYY_FORMAT=new SimpleDateFormat("dd-MM-yyy");/* format theo date mounth year*/

}
