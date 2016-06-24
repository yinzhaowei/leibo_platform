
package com.yzw.timer.action;
import com.yzw.timer.dto.Dto;
import com.yzw.timer.dto.LocalDto;
import com.yzw.timer.socket.TCPClient;
import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.util.LogUtil;
import com.yzw.timer.util.ProcessSqlUtil;
import com.yzw.timer.vo.HistroyVO;
import com.yzw.timer.vo.carInfo.CarVO;
import com.yzw.timer.vo.socket.CarRegisterVO;
import java.util.Iterator;
import java.util.List;


/**
 * Created by BoYang on 2015/10/30.
 */
public class Action_ALL {
    public Action_ALL() {
    }

    public void execute() {
        Dto dto = new Dto();
        Boolean create = this.createNewTable();
        LogUtil.info("是否需要创建新表 【" + create + "】");
        String last_xid = String.valueOf(LocalDto.getHistroyIndex());
        List histroyVOs = dto.getHistoryData(last_xid);
        String historySql = ProcessSqlUtil.getHistorySql(histroyVOs);
        String last_evId = String.valueOf(LocalDto.getCarInfoIndex());
        List carInfoVOs = dto.getCarInfoData(last_evId);
        String carinfoSql = ProcessSqlUtil.getCarInfoSql(carInfoVOs);
        if(!historySql.equals("")) {
            LogUtil.info("**********增加历史信息表BEGIN*********");
            LocalDto.addHistory(historySql);
            LogUtil.info("**********增加历史信息表END*********");
        }

        if(!carinfoSql.equals("")) {
            LogUtil.info("**********增加车辆信息表BEGIN*********");
            LocalDto.addCarInfo(carinfoSql);
            LogUtil.info("**********增加车辆信息表END*********");
        }

        List infoVOS = LocalDto.getRealTimeData();
        List infoVOS2 = LocalDto.getRealTimeData1();
        infoVOS = ProcessSqlUtil.handelVOS(infoVOS, infoVOS2);
        String infoSql = ProcessSqlUtil.getHistorySql(infoVOS);
        String delSql = ProcessSqlUtil.delRealTimeInfo();
        if(!infoSql.equals("")) {
            LogUtil.info("**********清空记录表BEGIN*********");
            LocalDto.addHistory(delSql);
            LogUtil.info("**********清空记录表END*********");
            LogUtil.info("**********更新实时信息表BEGIN*********");
            LocalDto.addHistory(infoSql);
            LogUtil.info("**********更新实时信息表ENDsdfsdf*********");
        }

        LogUtil.info("**********查询车辆注册信息表BEGIN*********");
        List registerVOS = LocalDto.getRealRegisterData();
        LogUtil.info("**********查询车辆注册信息表END*********");
        TCPClient gyptrc = new TCPClient();
        boolean flag = false;
        Iterator i$ = registerVOS.iterator();

        while(i$.hasNext()) {
            HistroyVO vo = (HistroyVO)i$.next();
            int code = gyptrc.sendRenZheng();
            CarRegisterVO vo1 = new CarRegisterVO();
            vo1.setKccs(LocalDto.getCarName(vo.getEV_ID()));
            vo1.setMsgVIN(vo.getVINCODE());
            LogUtil.info("**********查询车辆[" + vo.getVINCODE() + "]注册*********");
            LogUtil.info("**********平台[" + vo.getVINCODE() + "]认证status:【" + code + "】*********");
            int flag1 = gyptrc.sendCarRegister(vo1);
            LogUtil.info("**********查询车辆[" + vo.getVINCODE() + "]注册status:【" + flag1 + "】*********");
            if(flag1 == 1) {
                CarVO car = new CarVO();
                car.setFlag("1");
                car.setEV_ID(vo.getEV_ID());
                String carSql = car.toTHead() + car.toSql();
                LogUtil.info("**********车辆[" + car.getEV_ID() + "]注册落库BEGIN*********");
                LocalDto.addHistory(carSql);
                LogUtil.info("**********车辆[" + car.getEV_ID() + "]注册成功落库END*********");
            }
        }

    }

    public Boolean createNewTable() {
        String curTableName = CommonConstrants.osa_history + DateUtil.getCurrentMonth();
        String sql = ProcessSqlUtil.createTableByMonth();
        CommonConstrants.curTable = curTableName;
        boolean isCreate = LocalDto.isExistCurMonth(curTableName);
        if(!isCreate) {
            LogUtil.info("***********创建新新表【" + curTableName + "】BEGIN***********************");
            LocalDto.addHistory(sql);
            sql = ProcessSqlUtil.getNewCount();
            LocalDto.addHistory(sql);
            LogUtil.info("***********创建新新表【" + curTableName + "】END***********************");
            return Boolean.valueOf(true);
        } else {
            return Boolean.valueOf(false);
        }
    }
}
