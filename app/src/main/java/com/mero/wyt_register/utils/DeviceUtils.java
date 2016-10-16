package com.mero.wyt_register.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.mero.wyt_register.R;

import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

/**
 * Created by chenlei on 2016/10/15.
 */

public class DeviceUtils {
    private static  final String TAG = "DeviceUtils";
    private DeviceUtils(){
        throw new ExceptionInInitializerError("不可实例化");
    }
    public static String getIMEI(Context context){
        String IMEI= "";
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            IMEI = tm.getDeviceId();
            if(TextUtils.isEmpty(tm.getDeviceId())){
                IMEI = "IMEI无效";
            }
        }catch (Exception e){
          String msg = e.getMessage()==null?"e.getMessage为空":e.getMessage();
            Log.e(TAG,msg);
          IMEI = "获取deviceId失败";
        }
        return IMEI;
    }
    //获取手机号
    public static String getPhoneNum(Context context){
        String phoneNum = "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            phoneNum = tm.getLine1Number();
        }catch (Exception e){
            phoneNum = "获取手机号失败"+e.getMessage();
        }finally {
            return phoneNum;
        }
    }
    //获取手机国家
    public static String getCountryZipCode(Context context) {
        String countryID = "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            countryID = tm.getSimCountryIso();
        }catch (Exception e){
            countryID = "获取国家码失败";
        }finally {
            return countryID;
        }
    }
    //获取手机运营商信息
    public static String getProviderInfo(Context context){
        String providerInfo= "";
        String IMSI="";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            IMSI = tm.getSubscriberId();
            if(IMSI.startsWith("46000")||IMSI.startsWith("46002")){
                providerInfo = "中国移动";
            }
            if(IMSI.startsWith("46001")){
                providerInfo = "中国联通";
            }
            if(IMSI.startsWith("46003")){
                providerInfo = "中国电信";
            }
        }catch (Exception e){
            providerInfo = "获取运营商信息失败"+e.getMessage();
        }finally {
            return providerInfo;
        }
    }
    //获取运营商代码
    public static String getSubScriberId(Context context){
        String subScriberId= "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            subScriberId = tm.getSubscriberId();
        }catch (Exception e){
            Log.e(TAG,e.getMessage()==null?"e.getMessage()为null":e.getMessage());
            subScriberId = "获取运营商代码失败";
        }finally {
            return subScriberId;
        }
    }
    //获取IMSI
    public static String getIMSI(Context context){
        String IMSI = "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            IMSI = tm.getSubscriberId();
        }catch (Exception e){
            IMSI = "获取IMSI失败"+e.getMessage();
        }finally {
            return  IMSI;
        }
    }

    //获取sim卡序列号
    public static String getSimNumber(Context context){
        String simNumber = "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            simNumber = tm.getSimSerialNumber();
        }catch (Exception e){
            String msg = e.getMessage()==null?"e.getMessage()为空":e.getMessage();
            Log.e(TAG,msg);
            simNumber = "获取sim卡序列号失败";
        }finally {
            return simNumber;
        }
    }
}