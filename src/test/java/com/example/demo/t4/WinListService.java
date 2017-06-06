package com.example.demo.t4;

/**
 * Created by Administrator on 2017/6/2.
 */
public class WinListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
