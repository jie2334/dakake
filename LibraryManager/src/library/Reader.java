package library;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class Reader {

    private String name;

    private Date registrationTime;

    private List<BorrowRecord> recordList;

    /*uuid唯一字段*/
    private String uuid;


    public Reader(String name, Date registrationTime, List<BorrowRecord> recordList,String uuid) {
        this.name = name;
        this.registrationTime = registrationTime;
        this.recordList = recordList;
        this.uuid = uuid;
    }

    public Reader(String name,String uuid){
        this.name = name;
        this.uuid = uuid;
    }

    public Reader(String uuid, String name, Date parse) {
        this.name= name;
        this.uuid = uuid;
        this.registrationTime = parse;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BorrowRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<BorrowRecord> recordList) {
        this.recordList = recordList;
    }


    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", registrationTime=" + registrationTime +
                ", recordList=" + recordList +
                ", uuid='" + uuid + '\'' +
                '}';
    }


}
