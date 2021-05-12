package com.example.serice.a.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serice.a.entity.Info;

/**
 * (Info)表服务接口
 *
 * @author guochen
 * @since 2021-05-06 17:38:59
 */
public interface InfoService extends IService<Info> {

    R getFromBandC(Long id);

    R getFromC(Long id);

    R getFromB(Long id);
}
