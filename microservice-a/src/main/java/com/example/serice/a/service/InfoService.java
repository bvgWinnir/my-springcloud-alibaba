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

    /**
     * 功能描述: 没有seate 从A 保存B和C
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:17
     */
    R insertNoSeateBandC(Info info);

    /**
     * 功能描述: 没有seate 按顺序保存
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:18
     */
    R insertNoSeateA2B2C(Info info);

    /**
     * 功能描述: seate 从A 保存B和C
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:21
     */
    R insertSeateBandC(Info info);

    /**
     * 功能描述: 按顺序保存
     * @param info
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/27 10:21
     */
    R insertSeateA2B2C(Info info);

    /**
     * seata 回滚
     * @param info
     * @return
     */
    R insertSeateA2B2CRollBack(Info info);

    R insertMQBandC(Info info);

    R insertMQA2B2C(Info info);

    /**
     * 功能描述: 从A 发请求经过B 最后去查c 链路追踪
     * @param id
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/31 15:43
     */
    R fromAcourseBarriveC(long id);
}
