package com.ning.architecturedemo.bean;

/**
 * Created by chenning on 2020/3/30
 */
public class Translation {
    public int status;

    public content content;
    public class content {
        public String from;
        public String to;
        public String vendor;
        public String out;
        public int errNo;

        @Override
        public String toString() {
            return "content{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", vendor='" + vendor + '\'' +
                    ", out='" + out + '\'' +
                    ", errNo=" + errNo +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Translation{" +
                "status=" + status +
                ", content=" + content +
                '}';
    }
}
