package com.example.demo.service;

import com.example.demo.domain.Singer;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SingerService {

    boolean addSinger (Singer singer);

    boolean updateSingerMsg(Singer singer);

    boolean updateSingerPic(Singer singer);

    boolean deleteSinger(Integer id);

    List<Singer> allSinger();
    void exportAllSinger(HttpServletResponse response);

    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(Integer sex);
}
