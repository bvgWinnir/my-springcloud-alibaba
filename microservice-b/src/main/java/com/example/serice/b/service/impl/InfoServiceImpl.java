package com.example.serice.b.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.serice.b.dao.InfoDao;
import com.example.serice.b.entity.Info;
import com.example.serice.b.service.InfoService;
import org.springframework.stereotype.Service;

/**
 * (Info)表服务实现类
 *
 * @author guochen
 * @since 2021-05-07 09:52:49
 */
@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {

}
