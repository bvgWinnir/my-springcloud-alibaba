package com.example.serice.c.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serice.c.dao.InfoDao;
import com.example.serice.c.entity.Info;
import com.example.serice.c.service.InfoService;
import org.springframework.stereotype.Service;

/**
 * (Info)表服务实现类
 *
 * @author guochen
 * @since 2021-05-07 09:56:54
 */
@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {

}
