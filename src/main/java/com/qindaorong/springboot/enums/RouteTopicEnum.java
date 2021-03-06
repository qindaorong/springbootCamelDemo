package com.qindaorong.springboot.enums;

/**
 * @auther: qindaorong
 * @Date: 2018/6/26 14:51
 * @Description:
 */
public enum RouteTopicEnum {

    /**
     * bei_jing
     */
    BEI_JING("bj"),
    /**
     * fu_zhou
     */
    FU_ZHOU("fz"),
    /**
     * cheng_de
     */
    CHENG_DE("cd");

    private String topic;

    RouteTopicEnum(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
