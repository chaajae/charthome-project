package com.charthome.chart.controller;

import com.charthome.chart.model.service.ChartSerivce;
import com.charthome.chart.model.vo.ChartVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/chart")
public class ChartController {

    private final ChartSerivce chartSerivce;


    @GetMapping("/chartTop100")
    public String chart(Model model) throws IOException {
        List<ChartVO> melonChart = chartSerivce.getMelonChart(100);
        List<ChartVO> genieChart = chartSerivce.getGenieChart(100);
        List<ChartVO> vibeChart = chartSerivce.getVibeChart(100);

        model.addAttribute("melonTop100",melonChart);
        model.addAttribute("genieTop100",genieChart);
        model.addAttribute("vibeTop100",vibeChart);

        return "chart/chartTop100";
    }

}
