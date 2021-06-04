package com.example.serice.a.fegin;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.serice.a.entity.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: my-springcloud-alibaba
 * @description: C服务的feign接口
 * @author: GUOCHEN
 * @create: 2021/05/07 10:38
 */
@FeignClient("microservice-c")
public interface CmicroserviceFeignClient {

    /**
     * 功能描述: 查询 C 服务的数据
     *
     * @param id
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/7 10:42
     */
    @GetMapping("/cinfo/{id}")
    R getCInfo(@PathVariable("id") Long id);

    @PostMapping("/cinfo")
    R insertCInfo(@RequestBody Info info);
}
