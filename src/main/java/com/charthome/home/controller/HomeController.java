package com.charthome.home.controller;

import com.charthome.chart.model.service.ChartSerivce;
import com.charthome.chart.model.vo.ChartVO;
import com.charthome.home.model.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final ChartSerivce chartSerivce;






    @GetMapping("/")
    public String getChartTop10(Model model) throws Exception {
        List<ChartVO> melonTop10 = chartSerivce.getMelonChart(10);
        List<ChartVO> genieTop10 = chartSerivce.getGenieChart(10);
        List<ChartVO> vibeTop10 = chartSerivce.getVibeChart(10);

        model.addAttribute("melonTop10",melonTop10);
        model.addAttribute("genieTop10",genieTop10);
        model.addAttribute("vibeTop10",vibeTop10);
        return "home";
    }


}
