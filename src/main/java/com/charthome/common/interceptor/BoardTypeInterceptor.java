package com.charthome.common.interceptor;

import com.charthome.common.entity.BoardTypeEntity;
import com.charthome.common.repository.BoardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardTypeInterceptor implements HandlerInterceptor {

    @Autowired
    private ServletContext application;
    @Autowired
    private BoardTypeRepository boardTypeRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(application.getAttribute("boardTypeList") == null) {
            List<BoardTypeEntity> boardTypeList = boardTypeRepository.findAll();
            application.setAttribute("boardTypeList", boardTypeList);
            application.setAttribute("contextPath", request.getContextPath());
        }
        return true;
    }

}
