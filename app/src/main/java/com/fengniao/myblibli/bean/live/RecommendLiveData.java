package com.fengniao.myblibli.bean.live;


import java.util.List;

public class RecommendLiveData {


    private RecommendDataBean recommend_data;

    public RecommendDataBean getRecommend_data() {
        return recommend_data;
    }

    public void setRecommend_data(RecommendDataBean recommend_data) {
        this.recommend_data = recommend_data;
    }

    public static class RecommendDataBean {
        /**
         * lives : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/b30b947c58c6b1011136621a3ab54c0031c920fe.jpg","mid":93841264,"name":"梦醒三生梦"},"cover":{"src":"http://i0.hdslb.com/bfs/live/04bf0be43318e79d72f078fd148abba88e530d6b.jpg","height":180,"width":320},"room_id":3742025,"check_version":0,"online":66102,"area":"手游直播","area_id":12,"title":"二狗带你看懂王者荣耀","playurl":"http://txy.live-play.acgvideo.com/live-txy/193100/live_93841264_4272534.flv?wsSecret=1aa0f16662e2b60c686a8b71c682f0b8&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":35,"area_v2_name":"王者荣耀","area_v2_parent_id":3,"area_v2_parent_name":"手游"},{"owner":{"face":"http://i2.hdslb.com/bfs/face/38bec78e15db24022f36957e721d53c6ae85f886.jpg","mid":112789850,"name":"elfin_official"},"cover":{"src":"http://i0.hdslb.com/bfs/live/6852239a169f1411c22d7d14e855ee24e7e89d9b.jpg","height":180,"width":320},"room_id":4397198,"check_version":0,"online":37141,"area":"御宅文化","area_id":2,"title":"天籁精灵 日本美少女声优","playurl":"http://txy.live-play.acgvideo.com/live-txy/998016/live_112789850_5405345.flv?wsSecret=3dfd9b70bed66507dfb3307363c322c1&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":24,"area_v2_name":"声优","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"http://i1.hdslb.com/bfs/face/ef3f3fb14e17b7e4f43dd74c1629c2342827ea9e.jpg","mid":1653487,"name":"卯只只只只只只"},"cover":{"src":"http://i0.hdslb.com/bfs/live/ba9049bf55c8d4e381fc161f5f8096a5cce39b8d.jpg","height":180,"width":320},"room_id":100106,"check_version":0,"online":3836,"area":"生活娱乐","area_id":6,"title":"天野明展大悦城一日游","playurl":"http://live-play.acgvideo.com/live/973/live_1653487_8054932.flv?wsSecret=a4d5ec68ae137103056130c01e211e75&wsTime=59772313","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"http://i0.hdslb.com/bfs/face/0053321a0ec1e53824b8fc0ab8297469c9ce2816.jpg","mid":1864366,"name":"黑哲君丶"},"cover":{"src":"http://i0.hdslb.com/bfs/live/98a2f3578cc4410298e2560aa716ddd6000a68cf.jpg","height":180,"width":320},"room_id":83264,"check_version":0,"online":46778,"area":"电子竞技","area_id":4,"title":"(｀･д･´) 你感受过绝望吗？","playurl":"http://txy.live-play.acgvideo.com/live-txy/127594/live_1864366_1171676.flv?wsSecret=8329bff5f03fc10b69b89b4c4d02052a&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":86,"area_v2_name":"英雄联盟","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i2.hdslb.com/bfs/face/bcdf640faa16ebaacea1d4c930baabaec9087a80.jpg","mid":322892,"name":"痒局长"},"cover":{"src":"http://i0.hdslb.com/bfs/live/9808ad913ca29088ce78d28d37c80b3883e87814.jpg","height":180,"width":320},"room_id":5441,"check_version":0,"online":113746,"area":"单机联机","area_id":1,"title":"吃鸡","playurl":"http://xl.live-play.acgvideo.com/live-xl/518217/live_322892_3999292.flv?wsSecret=a9680d2de0139679b0c56b6c14573e22&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i0.hdslb.com/bfs/face/1efee088daeda80d473a5dfb77e05aaacb79d9fd.jpg","mid":4578433,"name":"老骚豆腐"},"cover":{"src":"http://i0.hdslb.com/bfs/live/14f0bc7d87b07094fed2f9be2737496e90853d22.jpg","height":180,"width":320},"room_id":763679,"check_version":0,"online":10570,"area":"单机联机","area_id":1,"title":"【绝地求生】我98K呢？","playurl":"http://txy.live-play.acgvideo.com/live-txy/713086/live_4578433_9339544.flv?wsSecret=6f716b481dc15a463fe81cc97c6bdbfd&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i2.hdslb.com/bfs/face/623ccce0ab28b721edb61dd64749d91de18fb384.jpg","mid":4162287,"name":"渗透之C君"},"cover":{"src":"http://i0.hdslb.com/group1/M00/82/08/oYYBAFbbzUSAM_RKAACX_jqIqfU665.jpg","height":180,"width":320},"room_id":1011,"check_version":0,"online":103634,"area":"生活娱乐","area_id":6,"title":"张哥房地产","playurl":"http://live-play.acgvideo.com/live/262/live_4162287_2085253.flv?wsSecret=ee25f51f0c68f5c34938ebb8c953b0f3&wsTime=59772313","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐"},{"owner":{"face":"http://i1.hdslb.com/bfs/face/27eef76504f3c940579cf8e8fed3ccdeb90b20d0.jpg","mid":582661,"name":"铃椛"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f12b0cfe7ceda8ae0cf87e4a925a2e1dc70a3787.jpg","height":180,"width":320},"room_id":39189,"check_version":0,"online":21287,"area":"单机联机","area_id":1,"title":"这很普遍！【黑暗之魂1】","playurl":"http://txy.live-play.acgvideo.com/live-txy/798097/live_582661_4957174.flv?wsSecret=4421aaa1c6da1fed3208eeb1aff0a042&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i0.hdslb.com/bfs/face/33ccb1a7c57cb12d2fd3c540601f823d26ffc938.jpg","mid":39334147,"name":"裕刺Fy"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f84855dedf92cf9bd60638828aa3b74af92e5c04.jpg","height":180,"width":320},"room_id":1250611,"check_version":0,"online":8932,"area":"单机联机","area_id":1,"title":"【大御姐】迟到大师与鸡搏斗","playurl":"http://txy.live-play.acgvideo.com/live-txy/581826/live_39334147_7458881.flv?wsSecret=cc85ecabf1b2355d5ba581b5061bbda1&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i0.hdslb.com/bfs/face/5057877d829c44c0f63d9e416b3d3eedb79d9d9d.gif","mid":9397500,"name":"心暖西瓜君"},"cover":{"src":"http://i0.hdslb.com/bfs/live/b2de0e1fa4a78f82b94c404212973c657677b80a.jpg","height":180,"width":320},"room_id":27532,"check_version":0,"online":37072,"area":"电子竞技","area_id":4,"title":"心暖：和茶师傅玩骚东西","playurl":"http://xl.live-play.acgvideo.com/live-xl/292386/live_9397500_4743304.flv?wsSecret=d7e5c847821a2f1d352a563dd959fe67&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":86,"area_v2_name":"英雄联盟","area_v2_parent_id":2,"area_v2_parent_name":"游戏"},{"owner":{"face":"http://i2.hdslb.com/bfs/face/10f2a92a95e5b118910547c388e5c23a5e15b6f1.gif","mid":6893484,"name":"小十里"},"cover":{"src":"http://i0.hdslb.com/bfs/live/c12d0394e7c01b74e9dbc1f2c1558e217cab5cfa.jpg","height":180,"width":320},"room_id":22714,"check_version":0,"online":6480,"area":"绘画专区","area_id":9,"title":"颈椎康复中心","playurl":"http://txy.live-play.acgvideo.com/live-txy/126357/live_6893484_2445810.flv?wsSecret=15e86875cf0f3a23c77e84960407a97b&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":51,"area_v2_name":"原创","area_v2_parent_id":4,"area_v2_parent_name":"绘画"},{"owner":{"face":"http://i0.hdslb.com/bfs/face/67870cefef5a6022fe8da3f103b2cb7d2134d8d7.jpg","mid":14308645,"name":"37不是37"},"cover":{"src":"http://i0.hdslb.com/bfs/live/f328014e53bdbf1b99447617f54ec8890a292ede.jpg","height":180,"width":320},"room_id":175412,"check_version":0,"online":18484,"area":"单机联机","area_id":1,"title":"【37】绝地 只想杀人 biu~","playurl":"http://xl.live-play.acgvideo.com/live-xl/381377/live_14308645_7533758.flv?wsSecret=61fb5434b1bf5f81c634758cafc99a1d&wsTime=1503570187","accept_quality":"4","broadcast_type":0,"is_tv":0,"area_v2_id":80,"area_v2_name":"绝地求生：大逃杀","area_v2_parent_id":2,"area_v2_parent_name":"游戏"}]
         * partition : {"id":0,"name":"推荐主播","area":"hot","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xxhdpi/-1.png?20170824165052","height":"63","width":"63"},"count":5305}
         * banner_data : [{"cover":{"src":"http://i0.hdslb.com/bfs/live/348fbbc30ca1578d900b44dda64acd1310b1d05e.png","height":180,"width":320},"title":"今天，你的小视频上榜了吗？","is_clip":1}]
         */

        private Partition partition;
        private List<Live> lives;
        private List<BannerDataBean> banner_data;

        public Partition getPartition() {
            return partition;
        }

        public void setPartition(Partition partition) {
            this.partition = partition;
        }

        public List<Live> getLives() {
            return lives;
        }

        public void setLives(List<Live> lives) {
            this.lives = lives;
        }

        public List<BannerDataBean> getBanner_data() {
            return banner_data;
        }

        public void setBanner_data(List<BannerDataBean> banner_data) {
            this.banner_data = banner_data;
        }

        public static class BannerDataBean {
            /**
             * cover : {"src":"http://i0.hdslb.com/bfs/live/348fbbc30ca1578d900b44dda64acd1310b1d05e.png","height":180,"width":320}
             * title : 今天，你的小视频上榜了吗？
             * is_clip : 1
             */

            private CoverBeanX cover;
            private String title;
            private int is_clip;

            public CoverBeanX getCover() {
                return cover;
            }

            public void setCover(CoverBeanX cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIs_clip() {
                return is_clip;
            }

            public void setIs_clip(int is_clip) {
                this.is_clip = is_clip;
            }

            public static class CoverBeanX {
                /**
                 * src : http://i0.hdslb.com/bfs/live/348fbbc30ca1578d900b44dda64acd1310b1d05e.png
                 * height : 180
                 * width : 320
                 */

                private String src;
                private int height;
                private int width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
