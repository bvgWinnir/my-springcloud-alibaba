package com.example.serice.a.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serice.a.dao.InfoDao;
import com.example.serice.a.entity.Info;

import com.example.serice.a.fegin.BmicroserviceFeignClient;
import com.example.serice.a.fegin.CmicroserviceFeignClient;
import com.example.serice.a.service.InfoService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Info)表服务实现类
 *
 * @author guochen
 * @since 2021-05-06 17:38:59
 */
@Slf4j
@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {

    @Autowired
    private BmicroserviceFeignClient bmicroserviceFeignClient;
    @Autowired
    private CmicroserviceFeignClient cmicroserviceFeignClient;

    @Override
    public R getFromBandC(Long id) {
        Info byId = this.getById(id);
        R bInfo = bmicroserviceFeignClient.getBInfo(id);
        R cInfo = cmicroserviceFeignClient.getCInfo(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aInfo",byId);
        jsonObject.put("bInfo",bInfo);
        jsonObject.put("cInfo",cInfo);
        return R.ok(jsonObject);
    }

    @Override
    public R getFromC(Long id) {
        Info byId = this.getById(id);
        R cInfo = cmicroserviceFeignClient.getCInfo(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aInfo",byId);
        jsonObject.put("cInfo",cInfo);
        return R.ok(jsonObject);
    }

    @Override
    public R getFromB(Long id) {
        Info byId = this.getById(id);
        R bInfo = bmicroserviceFeignClient.getBInfo(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aInfo",byId);
        jsonObject.put("bInfo",bInfo);
        return R.ok(jsonObject);
    }

    /**
     * 功能描述: 没有seate 从A 保存B和C
     *
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:17
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertNoSeateBandC(Info info) {
        info.setServiceName("microservice-a");
        JSONObject jsonObject = new JSONObject();
        boolean save = this.save(info);
        jsonObject.put("aInfo",save);

            info.setServiceName("a->b");
            R r = bmicroserviceFeignClient.insertBInfo(info);
            log.info("bmicroserviceFeignClient.insertBInfo ->result:{}", JSON.toJSONString(r));

            info.setServiceName("a->b->c");
            R r1 = cmicroserviceFeignClient.insertCInfo(info);
            log.info("cmicroserviceFeignClient.insertCInfo ->result:{}", JSON.toJSONString(r1));

            jsonObject.put("bInfo",r);
            jsonObject.put("cInfo",r1);

        return R.ok(jsonObject);
    }

    /**
     * 功能描述: 没有seate 按顺序保存
     *
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertNoSeateA2B2C(Info info) {
        return null;
    }

    /**
     * 功能描述: seate 从A 保存B和C
     *
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:21
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(rollbackFor = Exception.class)
    public R insertSeateBandC(Info info) {
        info.setServiceName("microservice-a");
        JSONObject jsonObject = new JSONObject();
        boolean save = this.save(info);
        jsonObject.put("aInfo",save);

        info.setServiceName("a->b");
        R r = bmicroserviceFeignClient.insertBInfo(info);
        log.info("bmicroserviceFeignClient.insertBInfo ->result:{}", JSON.toJSONString(r));

        info.setServiceName("a->b->c");
        R r1 = cmicroserviceFeignClient.insertCInfo(info);
        log.info("cmicroserviceFeignClient.insertCInfo ->result:{}", JSON.toJSONString(r1));

        jsonObject.put("bInfo",r);
        jsonObject.put("cInfo",r1);

        return R.ok(jsonObject);
    }

    /**
     * 功能描述: 按顺序保存
     *
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:21
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(rollbackFor = Exception.class)
    public R insertSeateA2B2C(Info info) {
        info.setServiceName("microservice-a");
        JSONObject jsonObject = new JSONObject();
        boolean save = this.save(info);
        jsonObject.put("aInfo",save);
        if (!save){
            return R.failed("amicroserviceFeignClient.insertaInfo failed");
        }
        info.setServiceName("a->b");
        R r = bmicroserviceFeignClient.insertBInfo(info);
        log.info("bmicroserviceFeignClient.insertBInfo ->result:{}", JSON.toJSONString(r));
        if (!r.ok()){
            return R.failed("bmicroserviceFeignClient.insertBInfo failed");
        }
        info.setServiceName("a->b->c");
        R r1 = cmicroserviceFeignClient.insertCInfo(info);
        log.info("cmicroserviceFeignClient.insertCInfo ->result:{}", JSON.toJSONString(r1));
        if (!r1.ok()){
            return R.failed("cmicroserviceFeignClient.insertCInfo failed");
        }
        jsonObject.put("bInfo",r);
        jsonObject.put("cInfo",r1);

        return R.ok(jsonObject);
    }

    /**
     * seata 回滚
     *
     * @param info
     * @return
     */
    @Override
    @GlobalTransactional
    public R insertSeateA2B2CRollBack(Info info)  {
        info.setServiceName("microservice-a");
        JSONObject jsonObject = new JSONObject();
        boolean save = this.save(info);
        jsonObject.put("aInfo",save);
        if (!save){
            return R.failed("amicroserviceFeignClient.insertaInfo failed");
        }

        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        info.setServiceName("a->b");
        R r = bmicroserviceFeignClient.insertBInfo(info);
        log.info("bmicroserviceFeignClient.insertBInfo ->result:{}", JSON.toJSONString(r));
        if (!r.ok()){
            return R.failed("bmicroserviceFeignClient.insertBInfo failed");
        }
        info.setServiceName("a->b->c");
        R r1 = cmicroserviceFeignClient.insertCInfo(info);
        log.info("cmicroserviceFeignClient.insertCInfo ->result:{}", JSON.toJSONString(r1));
        if (!r1.ok()){
            return R.failed("cmicroserviceFeignClient.insertCInfo failed");
        }
        jsonObject.put("bInfo",r);
        jsonObject.put("cInfo",r1);

        return R.ok(jsonObject);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertMQBandC(Info info) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertMQA2B2C(Info info) {
        return null;
    }

    @Override
    public R fromAcourseBarriveC(long id) {
        return bmicroserviceFeignClient.getCInfoFromB(id);
    }
}
