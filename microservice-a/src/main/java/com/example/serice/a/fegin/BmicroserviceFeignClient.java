package com.example.serice.a.fegin;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.serice.a.entity.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @program: my-springcloud-alibaba
 * @description: B服务的feign接口
 * @author: GUOCHEN
 * @create: 2021/05/07 10:38
 */
@FeignClient("B-service")
public interface BmicroserviceFeignClient {
    /**
     * 功能描述:查询 b服务的数据
     * @param id
     * @return: com.baomidou.mybatisplus.extension.api.R
     * @author: 郭辰
     * @date: 2021/5/7 10:42
     */
    @GetMapping("/info/{id}")
    R getBInfo(@PathVariable("id") Long id);

    @PostMapping("/info")
    R insertBInfo(@RequestBody Info info);
}
