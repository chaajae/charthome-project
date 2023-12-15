package com.charthome.chart.model.service;

import com.charthome.chart.model.vo.ChartVO;

import java.io.IOException;
import java.util.List;

public interface ChartSerivce {

    List<ChartVO> getMelonChart(int rankCount) throws IOException;

    List<ChartVO> getGenieChart(int rankCount)throws IOException;

    List<ChartVO> getVibeChart(int rankCount)throws IOException;


}
