package com.example.serice.a.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.serice.a.entity.Info;
import com.example.serice.a.service.InfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Info)表控制层
 *
 * @author guochen
 * @since 2021-05-06 17:39:00
 */
@RestController
@RequestMapping("ainfo")
public class InfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private InfoService infoService;

    @Value("server.port")
    private String port;

    @Value("spring.application.name")
    private String serviceName;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param info 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Info> page, Info info) {
        return success(this.infoService.page(page, new QueryWrapper<>(info)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.infoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param info 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Info info) {
        info.setPort(port);
        info.setServiceName(serviceName);
        return success(this.infoService.save(info));
    }

    /**
     * 修改数据
     *
     * @param info 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Info info) {
        return success(this.infoService.updateById(info));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.infoService.removeByIds(idList));
    }



    /**
     * @Classname InfoController
     * @param
     * @return
     * @Description 通过a服务获取a和b服务数据
     * @Date 2021/5/7 10:50
     * @auther by GUOCHEN
     */
     @GetMapping("getFromB/{id}")
     public R getFromB(@PathVariable("id") Long id){

        return this.infoService.getFromB(id);
     }


    /**
     * @Classname InfoController
     * @param
     * @return
     * @Description 通过a服务获取a和c服务数据
     * @Date 2021/5/7 10:50
     * @auther by GUOCHEN
     */
    @GetMapping("getFromC/{id}")
    public R getFromC(@PathVariable("id") Long id){

        return this.infoService.getFromC(id);
    }

    /**
     * @Classname InfoController
     * @param
     * @return
     * @Description 通过a服务获取a和b还有c服务数据
     * @Date 2021/5/7 10:50
     * @auther by GUOCHEN
     */
    @GetMapping("getFromBandC/{id}")
    public R getFromBandC(@PathVariable("id") Long id){
        return this.infoService.getFromBandC(id);
    }


    /**
     * @Classname InfoController
     * @param
     * @return
     * @Description 从A 请求 经过 b 最后实际去查c
     * @Date 2021/5/31 15:40
     * @auther by GUOCHEN
     */
     @GetMapping("fromAcourseBarriveC/{id}")
     public R fromAcourseBarriveC(@PathVariable("id") long id){
        return this.infoService.fromAcourseBarriveC(id);
     }

    /**
     * @Classname
     * @param
     * @param info
     * @return
     * @Description not seate
     * @Date 2021/5/27 10:13
     * @auther by GUOCHEN
     */
    @PostMapping("A2B2C")
    public R post(@RequestBody Info info) {
        return infoService.insertNoSeateBandC(info);
    }

}
