package com.aini.express.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.aini.express.service.TestService;
import com.aini.express.utils.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CommonController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    private TestService testService;
    
    /**
     * 테스트 목록
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/test/test.do")
    public String testList(HttpServletRequest request, ModelMap model) throws Exception {
        try {
            model.addAttribute("list", testService.getData());
            
        } catch (Exception e) {
            //log.error(e.getMessage());
            //logService.errLogRgstProc(this.getClass().getName(), "pollList", e.getMessage());
            e.printStackTrace();
        } finally {
        }
        return CommonUtil.page(request);
    }

}
