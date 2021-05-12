package com.example.serice.a.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serice.a.dao.InfoDao;
import com.example.serice.a.entity.Info;

import com.example.serice.a.fegin.BmicroserviceFeignClient;
import com.example.serice.a.fegin.CmicroserviceFeignClient;
import com.example.serice.a.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Info)表服务实现类
 *
 * @author guochen
 * @since 2021-05-06 17:38:59
 */
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
}
