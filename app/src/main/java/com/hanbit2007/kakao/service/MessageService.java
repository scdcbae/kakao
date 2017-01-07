package com.hanbit2007.kakao.service;

import com.hanbit2007.kakao.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2007 on 2017-01-07.
 */

public interface MessageService {
    public void write(MessageBean msg); //createMessage
    public ArrayList<MessageBean> list(); //readAll
    public ArrayList<MessageBean> findByWriter(String id); //readGroup
    public MessageBean findBySeq(int seq); //readOne
    public int count(); //readCount
    public int countByWriter(String id);
    public void updateMSG(MessageBean msg); //updateMessage
    public void deleteMSG(int seq); //deleteMessage
}
