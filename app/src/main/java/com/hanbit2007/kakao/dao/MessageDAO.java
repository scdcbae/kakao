package com.hanbit2007.kakao.dao;

import android.content.Context;

import com.hanbit2007.kakao.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2007 on 2017-01-07.
 */

public class MessageDAO {
    public MessageDAO(Context applicationContext) {

    }

    public void insert(MessageBean msg) { //createMessage
    }
    public ArrayList<MessageBean> selectAll() { //readAll
        ArrayList<MessageBean> list = new ArrayList<MessageBean>();
        return list;
    }
    public ArrayList<MessageBean> selectByWriter(String id) { //readGroup
        ArrayList<MessageBean> list = new ArrayList<MessageBean>();
        return list;
    }
    public MessageBean selectBySeq(int seq) { //readOne
        MessageBean msg = new MessageBean();
        return msg;
    }
    public int count() { //readCount
        int count = 0;
        return count;
    }
    public int countByWriter(String id){
        int count = 0;
        return count;
    }
    public void update(MessageBean msg) { //updateMessage
    }
    public void delete(int seq) { //deleteMessage
    }
}
