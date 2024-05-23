package com.easychat.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WeiLI
 * @date 2024/5/23 11:13
 * @desciption:
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "哈哈哈哈哈";
    }
}
