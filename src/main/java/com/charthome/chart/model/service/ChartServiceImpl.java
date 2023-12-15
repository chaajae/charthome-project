package com.charthome.chart.model.service;

import com.charthome.chart.model.vo.ChartVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChartServiceImpl implements ChartSerivce{


    @Override
    public List<ChartVO> getMelonChart(int rankCount) throws IOException {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = Jsoup.connect(url).userAgent("Chrome").get();

        List<String> artistNames = getTextsOfElements(doc, ".wrap_song_info .rank02 span");
        List<String> titles = getTextsOfElements(doc, ".wrap_song_info .rank01 span a");
        List<String> albumNames = getTextsOfElements(doc, ".wrap_song_info .rank03 a");
        List<String> albumArts = getAttrsOfElements(doc, ".image_typeAll img", "src");
        List<String> songNumbers = getAttrsOfElements(doc, "tr[data-song-no]", "data-song-no");

        List<ChartVO> melonChart = new ArrayList<>();
        for (int i = 0; i < rankCount; i++) {
            melonChart.add(ChartVO.builder()
                        .rank(i + 1)
                        .artistName(artistNames.get(i))
                        .title(titles.get(i))
                        .albumName(albumNames.get(i))
                        .albumArt(albumArts.get(i))
                        .songNumber(songNumbers.get(i))
                        .build());
        }
        return melonChart;
    }

    @Override
    public List<ChartVO> getGenieChart(int rankCount) throws IOException {
        String url1 = "https://www.genie.co.kr/chart/top200?rtm=Y&pg=1";
        String url2 = "https://www.genie.co.kr/chart/top200?rtm=Y&pg=2";
        Document doc1 = Jsoup.connect(url1).userAgent("Chrome").get();
        Document doc2 = Jsoup.connect(url2).userAgent("Chrome").get();

        List<String> artistNames = getTextsOfElements(doc1, "table .artist");
        artistNames.addAll(getTextsOfElements(doc2, "table .artist"));

        List<String> titles = getTextsOfElements(doc1, "table .title");
        titles.addAll(getTextsOfElements(doc2, "table .title"));

        List<String> albumNames = getTextsOfElements(doc1, "table .albumtitle");
        albumNames.addAll(getTextsOfElements(doc2, "table .albumtitle"));

        List<String> albumArts = getAttrsOfElements(doc1, "table .cover img", "src");
        albumArts.addAll(getAttrsOfElements(doc2, "table .cover img", "src"));

        List<String> songNumbers = getAttrsOfElements(doc1, "table tr[songid]", "songid");
        songNumbers.addAll(getAttrsOfElements(doc2, "table tr[songid]", "songid"));

        List<ChartVO> genieChart = new ArrayList<>();
        for (int i = 0; i < rankCount; i++) {
            genieChart.add(ChartVO.builder()
                        .rank(i + 1)
                        .artistName(artistNames.get(i))
                        .title(titles.get(i))
                        .albumName(albumNames.get(i))
                        .albumArt("https://" + albumArts.get(i).split("//")[1])
                        .songNumber(songNumbers.get(i))
                        .build());
        }
        return genieChart;
    }


    @Override
    public List<ChartVO> getVibeChart(int rankCount) throws IOException {
        String url = "https://apis.naver.com/vibeWeb/musicapiweb/vibe/v1/chart/track/total";
        Document doc = Jsoup.connect(url).userAgent("Chrome").get();
        List<ChartVO> vibeChart = new ArrayList<>();
        int count = 0;
        for (Element element : doc.select("response > result > chart > items > tracks > track")) {
            String searchedArtistName = element.select("album > artists > artist > artistName").text();
            if(rankCount == 10 && count == 10){
                break;
            }
            vibeChart.add(ChartVO.builder()
                        .rank(Integer.parseInt(element.select("rank > currentRank").text()))
                        .artistName(element.select("album > artists > artist > artistName").text())
                        .title(element.select("trackTitle").text())
                        .albumName(element.select("album > albumTitle").text())
                        .albumArt(element.select("album > imageUrl").text())
                        .songNumber(element.select("trackId").text())
                        .build());
            count++;
        }
        return vibeChart;
    }

    private List<String> getTextsOfElements(Document doc, String selector) {
        return doc.select(selector).stream()
                .map(Element::text)
                .collect(Collectors.toList());
    }

    // Get tag attribute values
    private List<String> getAttrsOfElements(Document doc, String selector, String attr) {
        return doc.select(selector).stream()
                .map(element -> element.attr(attr))
                .collect(Collectors.toList());
    }
}
