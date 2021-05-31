package com.example.serice.b.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.serice.b.entity.Info;

/**
 * (Info)表服务接口
 *
 * @author guochen
 * @since 2021-05-07 09:52:48
 */
public interface InfoService extends IService<Info> {

    R getCInfoFromB(Long id);
}
