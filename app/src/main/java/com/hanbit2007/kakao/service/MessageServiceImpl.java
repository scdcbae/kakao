package com.hanbit2007.kakao.service;

import android.content.Context;

import com.hanbit2007.kakao.dao.MessageDAO;
import com.hanbit2007.kakao.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2007 on 2017-01-07.
 */

public class MessageServiceImpl implements MessageService{
    MessageDAO dao;
    public MessageServiceImpl(Context applicationContext) {
        dao = new MessageDAO(applicationContext);
    }

    @Override
    public void write(MessageBean msg) {

    }

    @Override
    public ArrayList<MessageBean> list() {
        return null;
    }

    @Override
    public ArrayList<MessageBean> findByWriter(String id) {
        return null;
    }

    @Override
    public MessageBean findBySeq(int seq) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int countByWriter(String id) {
        return 0;
    }

    @Override
    public void updateMSG(MessageBean msg) {

    }

    @Override
    public void deleteMSG(int seq) {

    }
}
