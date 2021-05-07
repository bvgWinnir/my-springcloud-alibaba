package com.example.serice.a.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serice.a.dao.InfoDao;
import com.example.serice.a.entity.Info;
import com.example.serice.a.service.InfoService;
import org.springframework.stereotype.Service;

/**
 * (Info)表服务实现类
 *
 * @author guochen
 * @since 2021-05-06 17:38:59
 */
@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {

}
