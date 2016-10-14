package com.example.daidaijie.youdao;

import java.util.List;

/**
 * Created by daidaijie on 2016/5/31.
 */
public class TransResult {


    @Override
    public String toString() {
        return "翻译结果\n\t" + translation +"\n"+
                "网络释义\n" + web;
    }

    /**
     * translation : ["曼迪"]
     * query : Mandy
     * errorCode : 0
     * web : [{"value":["蔓迪","曹敏莉","蒋雅文"],"key":"Mandy"},{"value":["曼迪·穆尔","曼迪·摩尔","曼迪"],"key":"Mandy Moore"},{"value":["刘碧丽","白兰氏极品金丝盛燕"],"key":"Mandy Lieu"}]
     */

    private String query;
    private int errorCode;
    private List<String> translation;
    /**
     * value : ["蔓迪","曹敏莉","蒋雅文"]
     * key : Mandy
     */

    private List<WebBean> web;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public static class WebBean {
        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "\t"+ key +  "\n"+
                    "\t\t" + value +"\n";
        }
    }
}
