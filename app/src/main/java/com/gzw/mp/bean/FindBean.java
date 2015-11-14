package com.gzw.mp.bean;

import java.util.List;

/**
 * coder by 背离记 on 2015/11/13.
 */
public class FindBean {

    private List<Data> data;

    /** 获取数据列表，第一项是banner广告集合，第二项是话题集合，以后的暂时没用
     * @return
     */
    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    public class Data {
        /**
         * 话题或广告ID
         */
        private String  id;
        /**
         * 话题或广告name
         */
        private String name;
        /**
         * 广告图片
         */
        private String picture;
        /**
         * 话题索引顺序
         */
        private int index;

        /** 话题或广告ID
         * @return
         */
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        /** 话题或广告name
         * @return
         */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 广告图片
         */
        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        /**
         * 话题索引顺序
         */
        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
