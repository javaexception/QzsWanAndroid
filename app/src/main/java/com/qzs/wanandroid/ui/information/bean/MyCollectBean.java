package com.qzs.wanandroid.ui.information.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyCollectBean {


    /**
     * data : {"curPage":1,"datas":[{"author":"ITGungnir","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Kotlin + MVVM + 模块化 + 响应式 的WanAndroid客户端，简约优雅。  ## 技术点 * 基于APT和ASM的GRouter路由框架实现模块化通信； * 参考Redux的原理，实现一套事件总线框架； * 封装MVVM和UI库，可供其他应用使用； * 项目整体使用响应式编程风格，简介优雅易读。","envelopePic":"https://www.wanandroid.com/blogimgs/d95d3a13-85ae-4aa7-bec0-ca9f4bba9eae.png","id":73667,"link":"http://www.wanandroid.com/blog/show/2575","niceDate":"2019-07-25","origin":"","originId":8480,"publishTime":1564016243000,"title":"WanAndroid模块化响应式客户端 很赞","userId":27113,"visible":0,"zan":0,"chapterNa 2019-07-31 22:43:14.146 14109-14561/com.qzs.wanandroid D/OkHttp: me":1563862074000},{"author":"jimmysuncpt","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"UltraRecyclerView是一个封装多种特性的RecyclerView。主要功能包括： - 支持横向滑动／纵向滑动 - 支持分页滑动，并且支持对齐方式和距离 - 支持循环滚动 - 支持定时自动滚动，计时器使用Handler实现 - BannerView内置指示器，支持设置底部距离、已选/默认的颜色和宽度、高度和内部距离","envelopePic":"https://www.wanandroid.com/blogimgs/0858c600-1b34-41c1-a2ff-f67cdc376558.png","id":73666,"link":"http://www.wanandroid.com/blog/show/2574","niceDate":"2019-07-25","origin":"","originId":8467,"publishTime":1564016230000,"title":"UltraRecyclerView是一个封装多种特性的RecyclerView","userId":27113,"visible":0,"zan":0},{"author":"lulululbj","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Github 上关于 Wanandroid 的客户端也层出不穷，Java的，Kotlin 的，Flutter 的，Mvp 的，MVMM 的，各种各样，但是还没看到 Kotlin+MVVM+LiveData+协程 版本的，加上最近正在看 MVVM 和 LiveData，就着手把我之前写的 Mvp 版本的 Wanandroid 改造成 MVVM + Kotlin + LiveData + 协程 版本。","envelopePic":"https://wanandroid.com/blogimgs/54f4350f-039d-48b6-a38b-0933e1405004.png","id":73665,"link":"http://www.wanandroid.com/blog/show/2554","niceDate":"2019-07-25","origin":"","originId":8273,"publishTime":1564016226000,"title":"真香！Kotlin+MVVM+LiveData+协程 打造 Wanandroid！","userId":27113,"visible":0,"zan":0},{"author":"OnexZgj","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"该应用程序是玩Android部分api和干货网站部分api的flutter版本的技术类文章查看APP。 主要功能包括：首页、项目、公众号、搜索等。","envelopePic":"https://wanandroid.com/blogimgs/4681d6c0-0d76-4c69-a866-7ad66dde10cd.png","id":73664,"link":"http://www.wanandroid.com/blog/show/2550","niceDate":"2019-07-25","origin":"","originId":8269,"publishTime":1564016222000,"title":"是时候体验一波Flutter啦","userId":27113,"visible":0,"zan":0},{"author":"scsfwgy","chapterId":339,"chapterName":"K线图","courseId":13,"desc":"各种金融类的自定义View,基金走势图、分时图、蜡烛图、各种指标等，一步一步构建庞大的基金自定View... http://blog.csdn.net/wgyscsf ","envelopePic":"http://www.wanandroid.com/blogimgs/3a9d2cbb-24d7-4c85-8497-9e1af6b64d23.png","id":73661,"link":"http://www.wanandroid.com/blog/show/2105","niceDate":"2019-07-25","origin":"","originId":2799,"publishTime":1564014729000,"title":"走势图、分时图、蜡烛图 FinancialCustomerView","userId":27113,"visible":0,"zan":0},{"author":"simplezhli","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":" Flutter 练习项目。包括完整UI设计图，更贴近真实项目的练习。","envelopePic":"https://wanandroid.com/blogimgs/2c0ccd42-50b3-4d61-a019-c2dd4af368f0.png","id":73452,"link":"http://www.wanandroid.com/blog/show/2619","niceDate":"2019-07-23","origin":"","originId":8660,"publishTime":1563869432000,"title":" Flutter 实战项目","userId":27113,"visible":0,"zan":0},{"author":"jiwenjie","chapterId":294,"chapterNa 2019-07-31 22:43:14.146 14109-14561/com.qzs.wanandroid D/OkHttp: me":1563862074000,"title":"WanAndroid 个人第一个练手项目分享","userId":27113,"visible":0,"zan":0},{"author":"guofudong","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Meterail Design风格商城类项目","envelopePic":"https://www.wanandroid.com/blogimgs/5a3eb937-b429-49f4-9a77-d3ff15cf4988.png","id":73421,"link":"http://www.wanandroid.com/blog/show/2598","niceDate":"2019-07-23","origin":"","originId":8547,"publishTime":1563861706000,"title":"Meterail Design风格商城类项目","userId":27113,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":9}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"author":"ITGungnir","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Kotlin + MVVM + 模块化 + 响应式 的WanAndroid客户端，简约优雅。  ## 技术点 * 基于APT和ASM的GRouter路由框架实现模块化通信； * 参考Redux的原理，实现一套事件总线框架； * 封装MVVM和UI库，可供其他应用使用； * 项目整体使用响应式编程风格，简介优雅易读。","envelopePic":"https://www.wanandroid.com/blogimgs/d95d3a13-85ae-4aa7-bec0-ca9f4bba9eae.png","id":73667,"link":"http://www.wanandroid.com/blog/show/2575","niceDate":"2019-07-25","origin":"","originId":8480,"publishTime":1564016243000,"title":"WanAndroid模块化响应式客户端 很赞","userId":27113,"visible":0,"zan":0},{"author":"jimmysuncpt","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"UltraRecyclerView是一个封装多种特性的RecyclerView。主要功能包括： - 支持横向滑动／纵向滑动 - 支持分页滑动，并且支持对齐方式和距离 - 支持循环滚动 - 支持定时自动滚动，计时器使用Handler实现 - BannerView内置指示器，支持设置底部距离、已选/默认的颜色和宽度、高度和内部距离","envelopePic":"https://www.wanandroid.com/blogimgs/0858c600-1b34-41c1-a2ff-f67cdc376558.png","id":73666,"link":"http://www.wanandroid.com/blog/show/2574","niceDate":"2019-07-25","origin":"","originId":8467,"publishTime":1564016230000,"title":"UltraRecyclerView是一个封装多种特性的RecyclerView","userId":27113,"visible":0,"zan":0},{"author":"lulululbj","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Github 上关于 Wanandroid 的客户端也层出不穷，Java的，Kotlin 的，Flutter 的，Mvp 的，MVMM 的，各种各样，但是还没看到 Kotlin+MVVM+LiveData+协程 版本的，加上最近正在看 MVVM 和 LiveData，就着手把我之前写的 Mvp 版本的 Wanandroid 改造成 MVVM + Kotlin + LiveData + 协程 版本。","envelopePic":"https://wanandroid.com/blogimgs/54f4350f-039d-48b6-a38b-0933e1405004.png","id":73665,"link":"http://www.wanandroid.com/blog/show/2554","niceDate":"2019-07-25","origin":"","originId":8273,"publishTime":1564016226000,"title":"真香！Kotlin+MVVM+LiveData+协程 打造 Wanandroid！","userId":27113,"visible":0,"zan":0},{"author":"OnexZgj","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"该应用程序是玩Android部分api和干货网站部分api的flutter版本的技术类文章查看APP。 主要功能包括：首页、项目、公众号、搜索等。","envelopePic":"https://wanandroid.com/blogimgs/4681d6c0-0d76-4c69-a866-7ad66dde10cd.png","id":73664,"link":"http://www.wanandroid.com/blog/show/2550","niceDate":"2019-07-25","origin":"","originId":8269,"publishTime":1564016222000,"title":"是时候体验一波Flutter啦","userId":27113,"visible":0,"zan":0},{"author":"scsfwgy","chapterId":339,"chapterName":"K线图","courseId":13,"desc":"各种金融类的自定义View,基金走势图、分时图、蜡烛图、各种指标等，一步一步构建庞大的基金自定View... http://blog.csdn.net/wgyscsf ","envelopePic":"http://www.wanandroid.com/blogimgs/3a9d2cbb-24d7-4c85-8497-9e1af6b64d23.png","id":73661,"link":"http://www.wanandroid.com/blog/show/2105","niceDate":"2019-07-25","origin":"","originId":2799,"publishTime":1564014729000,"title":"走势图、分时图、蜡烛图 FinancialCustomerView","userId":27113,"visible":0,"zan":0},{"author":"simplezhli","chapterId":402,"chapterName":"跨平台应用","courseId":13,"desc":" Flutter 练习项目。包括完整UI设计图，更贴近真实项目的练习。","envelopePic":"https://wanandroid.com/blogimgs/2c0ccd42-50b3-4d61-a019-c2dd4af368f0.png","id":73452,"link":"http://www.wanandroid.com/blog/show/2619","niceDate":"2019-07-23","origin":"","originId":8660,"publishTime":1563869432000,"title":" Flutter 实战项目","userId":27113,"visible":0,"zan":0},{"author":"jiwenjie","chapterId":294,"chapterNa 2019-07-31 22:43:14.146 14109-14561/com.qzs.wanandroid D/OkHttp: me":1563862074000,"title":"WanAndroid 个人第一个练手项目分享","userId":27113,"visible":0,"zan":0},{"author":"guofudong","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"Meterail Design风格商城类项目","envelopePic":"https://www.wanandroid.com/blogimgs/5a3eb937-b429-49f4-9a77-d3ff15cf4988.png","id":73421,"link":"http://www.wanandroid.com/blog/show/2598","niceDate":"2019-07-23","origin":"","originId":8547,"publishTime":1563861706000,"title":"Meterail Design风格商城类项目","userId":27113,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 9
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * author : ITGungnir
             * chapterId : 294
             * chapterName : 完整项目
             * courseId : 13
             * desc : Kotlin + MVVM + 模块化 + 响应式 的WanAndroid客户端，简约优雅。  ## 技术点 * 基于APT和ASM的GRouter路由框架实现模块化通信； * 参考Redux的原理，实现一套事件总线框架； * 封装MVVM和UI库，可供其他应用使用； * 项目整体使用响应式编程风格，简介优雅易读。
             * envelopePic : https://www.wanandroid.com/blogimgs/d95d3a13-85ae-4aa7-bec0-ca9f4bba9eae.png
             * id : 73667
             * link : http://www.wanandroid.com/blog/show/2575
             * niceDate : 2019-07-25
             * origin :
             * originId : 8480
             * publishTime : 1564016243000
             * title : WanAndroid模块化响应式客户端 很赞
             * userId : 27113
             * visible : 0
             * zan : 0
             * chapterNa 2019-07-31 22:43:14.146 14109-14561/com.qzs.wanandroid D/OkHttp: me : 1563862074000
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;
            @SerializedName("chapterNa 2019-07-31 22:43:14.146 14109-14561/com.qzs.wanandroid D/OkHttp: me")
            private long _$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79; // FIXME check this code

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public long get_$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79() {
                return _$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79;
            }

            public void set_$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79(long _$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79) {
                this._$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79 = _$ChapterNa201907312243141461410914561ComQzsWanandroidDOkHttpMe79;
            }
        }
    }
}
