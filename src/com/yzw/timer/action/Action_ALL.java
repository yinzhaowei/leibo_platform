
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
        LogUtil.info("�Ƿ���Ҫ�����±� ��" + create + "��");
        String last_xid = String.valueOf(LocalDto.getHistroyIndex());
        List histroyVOs = dto.getHistoryData(last_xid);
        String historySql = ProcessSqlUtil.getHistorySql(histroyVOs);
        String last_evId = String.valueOf(LocalDto.getCarInfoIndex());
        List carInfoVOs = dto.getCarInfoData(last_evId);
        String carinfoSql = ProcessSqlUtil.getCarInfoSql(carInfoVOs);
        if(!historySql.equals("")) {
            LogUtil.info("**********������ʷ��Ϣ��BEGIN*********");
            LocalDto.addHistory(historySql);
            LogUtil.info("**********������ʷ��Ϣ��END*********");
        }

        String phones = LocalDto.getPhones();

        if(!carinfoSql.equals("")) {
            LogUtil.info("**********���ӳ�����Ϣ��BEGIN*********");
            LocalDto.addCarInfo(carinfoSql);
            LogUtil.info("**********���ӳ�����Ϣ��END*********");
        }

        List infoVOS = LocalDto.getRealTimeData(phones);
        List infoVOS2 = LocalDto.getRealTimeData1(phones);
        infoVOS = ProcessSqlUtil.handelVOS(infoVOS, infoVOS2);
        String infoSql = ProcessSqlUtil.getHistorySql(infoVOS);
        String delSql = ProcessSqlUtil.delRealTimeInfo();
        if(!infoSql.equals("")) {
            LogUtil.info("**********��ռ�¼��BEGIN*********");
            LocalDto.addHistory(delSql);
            LogUtil.info("**********��ռ�¼��END*********");
            LogUtil.info("**********����ʵʱ��Ϣ��BEGIN*********");
            LocalDto.addHistory(infoSql);
            LogUtil.info("**********����ʵʱ��Ϣ��ENDsdfsdf*********");
        }

        LogUtil.info("**********��ѯ����ע����Ϣ��BEGIN*********");
        List registerVOS = LocalDto.getRealRegisterData();
        LogUtil.info("**********��ѯ����ע����Ϣ��END*********");
        TCPClient gyptrc = new TCPClient();
        boolean flag = false;
        Iterator i$ = registerVOS.iterator();
        if(registerVOS.size()<=0)
            LogUtil.info("**********û���³�ע��*********");
        while(i$.hasNext()) {
            HistroyVO vo = (HistroyVO)i$.next();
            int code = gyptrc.sendRenZheng();
            CarRegisterVO vo1 = new CarRegisterVO();
            vo1.setKccs(LocalDto.getCarName(vo.getEV_ID()));
            vo1.setMsgVIN(vo.getVINCODE());
            LogUtil.info("**********��ѯ����[" + vo.getVINCODE() + "]ע��*********");
            LogUtil.info("**********ƽ̨[" + vo.getVINCODE() + "]��֤status:��" + code + "��*********");
            int flag1 = gyptrc.sendCarRegister(vo1);
            LogUtil.info("**********��ѯ����[" + vo.getVINCODE() + "]ע��status:��" + flag1 + "��*********");
            if(flag1 == 1) {
                CarVO car = new CarVO();
                car.setFlag("1");
                car.setEV_ID(vo.getEV_ID());
                String carSql = car.toTHead() + car.toSql();
                LogUtil.info("**********����[" + car.getEV_ID() + "]ע�����BEGIN*********");
                LocalDto.addHistory(carSql);
                LogUtil.info("**********����[" + car.getEV_ID() + "]ע��ɹ����END*********");
            }
        }

    }

    public Boolean createNewTable() {
        String curTableName = CommonConstrants.osa_history + DateUtil.getCurrentMonth();
        String sql = ProcessSqlUtil.createTableByMonth();
        CommonConstrants.curTable = curTableName;
        boolean isCreate = LocalDto.isExistCurMonth(curTableName);
        if(!isCreate) {
            LogUtil.info("***********�������±�" + curTableName + "��BEGIN***********************");
            LocalDto.addHistory(sql);
            sql = ProcessSqlUtil.getNewCount();
            LocalDto.addHistory(sql);
            LogUtil.info("***********�������±�" + curTableName + "��END***********************");
            return Boolean.valueOf(true);
        } else {
            return Boolean.valueOf(false);
        }
    }
}
