package com.ghost.utils.test;

import com.ghost.utils.bo.UserBo;
import com.ghost.utils.utils.Base64Util;
import com.ghost.utils.utils.DateUtils;
import com.ghost.utils.utils.JsonUtil;
import com.ghost.utils.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author xhh
 * @version 1.0
 * @date 2020/6/29 12:03
 * @description
 */
@Slf4j
public class UtilsTest {

    @Test
    public void jsonTest(){
        UserBo userBo = new UserBo();
        userBo.setName("123");
        log.info(JsonUtil.bean2Json(userBo));
    }

    @Test
    public void base64Test(){
        String name="麤鱻";
        String encodeData = Base64Util.encodeData(name);
        log.info("加密前的明文："+name+" — 加密的密文："+encodeData);
        String decodeData = Base64Util.decodeData(encodeData);
        log.info("解密前的密文："+encodeData+" — 解密后的明文："+decodeData);
        String encodeData2 = "6Y6P55Ck5bOj5o6x6Ie46Z2Y";
        String decodeData2 = Base64Util.decodeData(encodeData2);
        log.info("解密前的密文："+encodeData2+" — 解密后的明文："+decodeData2);
    }

    @Test
    public void md5Test(){
        String password="jianghao082435";
        String md5 = Md5Utils.getMD5(password);
        log.info("md5加密密文："+md5);
        log.info("md5加密密文："+md5);
    }

    @Test
    public void dateTest(){
        DateTimeFormatter dateTimeFormatter = DateUtils.timeFormatter();
        log.info(JsonUtil.bean2Json(dateTimeFormatter));
        String currentTime = DateUtils.getCurrentTime();
        log.info(JsonUtil.bean2Json(currentTime));
        String timestamp = DateUtils.getTimestamp();
        log.info(JsonUtil.bean2Json(timestamp));
        Long millisecond = DateUtils.getMillisecond();
        log.info(JsonUtil.bean2Json(millisecond));
        String formatTime = DateUtils.getFormatTime("yyyy年MM月dd日 HH时mm分ss秒");
        log.info(JsonUtil.bean2Json(formatTime));
        String s = DateUtils.formatTime(LocalDateTime.now());
        log.info(JsonUtil.bean2Json(LocalDateTime.now())+"————"+JsonUtil.bean2Json(s));
        String s1 = DateUtils.formatDate(LocalDate.now());
        log.info(JsonUtil.bean2Json(LocalDate.now())+"————"+JsonUtil.bean2Json(s1));
        LocalDateTime localDateTime = DateUtils.date2LocalDateTime(new Date());
        log.info(JsonUtil.bean2Json(new Date())+"————"+JsonUtil.bean2Json(localDateTime));
        String s2 = DateUtils.formatDate(new Date());
        log.info(JsonUtil.bean2Json(new Date())+"————"+JsonUtil.bean2Json(s2));
    }

    @Test
    public void test(){
        UserBo userBo = new UserBo();
        userBo.setName("jh");
        userBo.setNum(null);
        int num = userBo.getNum();
        System.out.println(num);
        log.info((0==num)+"");
    }

}
