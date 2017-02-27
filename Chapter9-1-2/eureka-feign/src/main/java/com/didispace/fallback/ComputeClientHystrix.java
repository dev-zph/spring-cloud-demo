/**
 * 
 */
package com.didispace.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.didispace.service.ComputeClient;

/**
 * @author zph
 * @createTime 2017年2月27日 上午11:25:53
 * 
 */
@Component
public class ComputeClientHystrix  implements ComputeClient {
	    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
	        return -9999;
	    }
	}